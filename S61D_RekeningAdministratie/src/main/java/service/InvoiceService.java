/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import dao.DriverDAO;
import dao.InvoiceDAO;
import dao.InvoiceJMSDAO;
import dao.InvoiceRowDAO;
import dao.RateDAO;
import dao.VehicleDAO;
import domain.Beacon;
import domain.Driver;
import domain.Invoice;
import domain.InvoiceJMS;
import domain.InvoiceRow;
import domain.Movement;
import domain.Rate;
import domain.Vehicle;
import factory.BeaconTransmitter;
import factory.InvoiceTransmitter;
import factory.JMSSender;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;

/**
 *
 * @author fhict
 */
@Stateless
public class InvoiceService {

    @Inject
    InvoiceDAO invoiceDAO;

    @Inject
    InvoiceRowDAO invoiceRowDAO;

    @Inject
    InvoiceTransmitter invoiceTransmitter;

    @Inject
    DriverDAO driverDAO;
    @Inject
    VehicleDAO vehicleDAO;
    @Inject
    MovementService movementService;

    @Inject
    BeaconTransmitter beaconTransmitter;

    @Inject
    RateDAO rateDAO;
    
    @Inject
    InvoiceJMSDAO invoiceJMSDAO;

    // URL of the JMS server. DEFAULT_BROKER_URL will just mean
    // that JMS server is on localhost
    private static final String nlUrl = "tcp://192.168.24.41:61616";
    private static final String deUrl = "tcp://192.168.24.38:61616";
    private static final String bgUrl = "tcp://192.168.25.69:61616";
    private static final String chUrl = "tcp://192.168.24.27:61616";
    // default broker URL is : tcp://localhost:61616"

    private static final String subject = "factuurInternal"; //Queue Name
    private static final String subjectForeign = "invoicequeue";
    Gson gson = new Gson();

    public Invoice createInvoice(Driver driver) {
        Invoice invoice = new Invoice();

        try {
            Calendar c = Calendar.getInstance();
            String month = new SimpleDateFormat("MMMM").format(c.getTime());
            int year = c.get(Calendar.YEAR);

            InvoiceRow invoiceRow = new InvoiceRow();
            invoice.setDriver(driver);
            invoice.setMonth(String.valueOf(month + " " + year));
            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
            invoice.setTimestamp(timeStamp.getTime());
            if (!invoiceDAO.checkInvoice(invoice)) {

                invoice = invoiceDAO.createNewInvoice(invoice);

                List<Rate> rates = rateDAO.getAllRates();

                List<Vehicle> vehicles = vehicleDAO.getVehicleByOwner(driver.getId());

                for (Vehicle v : vehicles) {
                    List<Beacon> beaconList = new ArrayList<>();
                    beaconList = beaconTransmitter.GetAllMovementsPerVehicle(v.getiCan());
                    if (!beaconList.isEmpty()) {
                        List<Movement> movements = createTempMovement(beaconList, invoice.getMonth(),v.getiCan(), rates);
                        invoiceRow.setVehicle(v);
                        double price = (long) movementService.getMonthprice(movements);
                        invoiceRow.setPrice(price);
                        invoiceRow.setInvoice(invoice);
                        invoiceRow = invoiceRowDAO.createNewInvoiceRow(invoiceRow);
                        invoiceRow.getVehicle().setHistory(new ArrayList<>());
                        invoiceRow.getVehicle().setOwner(null);

                        invoice.getDriver().setAllVehicle(new ArrayList<>());
                        invoiceRow.setInvoice(invoice);
                        JMSSender.sendInvoiceInternal(gson.toJson(invoiceRow), nlUrl, subject);
                    }
                }
                return invoice;
            }
            return null;
        } catch (JSONException ex) {
            return null;
        }

    }

    public void createForeignInvoice(InvoiceJMS invoiceJMS) {
        InvoiceRow invoiceRow = null;
        Driver driver = vehicleDAO.getDriverByICan(invoiceJMS.getICan());
        if (driver != null) {
            Vehicle vehicle = vehicleDAO.getVehicleByIcan(invoiceJMS.getICan()).get(0);
            Calendar c = Calendar.getInstance();
            Date d = new Date(invoiceJMS.getTimestamp());
            c.setTime(d);
            String month = new SimpleDateFormat("MMMM").format(c.getTime());
            int year = c.get(Calendar.YEAR);
            String monthWithYear = month + " " + year;
            Invoice invoice = new Invoice(monthWithYear, false, driver, invoiceJMS.getTimestamp());
            if (!invoiceDAO.checkInvoice(invoice)) {
                invoice = invoiceDAO.createNewInvoice(invoice);
            } else {
                invoice = invoiceDAO.getInvoiceByDriverAndMonth(invoice);
            }
            invoiceRow = new InvoiceRow(invoiceJMS.getTotalPrice(), "Foreign invoice", invoice, vehicle);
            invoiceRow = invoiceRowDAO.createNewInvoiceRow(invoiceRow);
            invoiceRow.getVehicle().setHistory(new ArrayList<>());
            invoiceRow.getVehicle().setOwner(null);

            invoice.getDriver().setAllVehicle(new ArrayList<>());
            invoiceRow.setInvoice(invoice);
            JMSSender.sendInvoiceInternal(gson.toJson(invoiceRow), nlUrl, subject);
        }
    }

    public void createAllInvoice() {
        try {
            List<Rate> rates = rateDAO.getAllRates();
            List<Beacon> beaconList = new ArrayList<>();
            beaconList = beaconTransmitter.getAllBeaconPerPeriode();
            Map<String, List<Beacon>> map = new HashMap<String, List<Beacon>>();

            Calendar c = Calendar.getInstance();
            String month = new SimpleDateFormat("MMMM").format(c.getTime());
            int year = c.get(Calendar.YEAR);

            for (Beacon b : beaconList) {
                String key = b.getiCan();
                if (map.containsKey(key)) {
                    List<Beacon> beaconTemp = map.get(key);
                    beaconTemp.add(b);
                } else {
                    List<Beacon> beaconTemp = new ArrayList<>();
                    beaconTemp.add(b);
                    map.put(key, beaconTemp);
                }
            }
            for (String s : map.keySet()) {
                beaconList.clear();
                beaconList = map.get(s);
                if (s.contains("NL")) {
                    Driver driver = vehicleDAO.getDriverByICan(s);
                    List<Vehicle> vehicle = vehicleDAO.getVehicleByIcan(s);

                    if (vehicle.get(0) != null && driver != null) {

                        InvoiceRow invoiceRow = new InvoiceRow();
                        Invoice invoice = new Invoice();

                        invoice.setDriver(driver);
                        invoice.setMonth(String.valueOf(month + " " + year));
                        if (!invoiceDAO.checkInvoice(invoice)) {
                            invoice = invoiceDAO.createNewInvoice(invoice);
                        } else {
                            invoice = invoiceDAO.getInvoiceByDriverAndMonth(invoice);
                        }
                        List<Movement> movement = createTempMovement(beaconList, invoice.getMonth(),s, rates);
                        double price =  movementService.getMonthprice(movement);
                        
                        invoiceRow.setVehicle(vehicle.get(0));
                        invoiceRow.setPrice(price);
                        invoiceRow.setInvoice(invoice);
                        invoiceRow = invoiceRowDAO.createNewInvoiceRow(invoiceRow);
                        invoiceRow.getVehicle().setHistory(new ArrayList<>());
                        invoiceRow.getVehicle().setOwner(null);

                        invoice.getDriver().setAllVehicle(new ArrayList<>());
                        invoiceRow.setInvoice(invoice);
                        JMSSender.sendInvoiceInternal(gson.toJson(invoiceRow), nlUrl, subject);
                    }

                } else {
                    List<Movement> movement = createTempMovement(beaconList,month,s, rates);
                    double price = movementService.getMonthprice(movement);
                    InvoiceJMS invoiceJMS = new InvoiceJMS("NL", new Timestamp(System.currentTimeMillis()).getTime(), price, s);
                    invoiceJMSDAO.createNewJMS(invoiceJMSDAO);
                    String message = gson.toJson(invoiceJMS);
                    if(s.contains("DE")){
                        JMSSender.sendInvoiceInternal(message, deUrl, subjectForeign);
                    }
                    if(s.contains("BG")){
                        JMSSender.sendInvoiceInternal(message, bgUrl, subjectForeign);
                    }
                    if(s.contains("CH")){
                        JMSSender.sendInvoiceInternal(message, chUrl, subjectForeign);
                    }
                }
            }
        } catch (JSONException ex) {
            Logger.getLogger(InvoiceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Movement> createTempMovement(List<Beacon> beacon, String month, String iCan, List<Rate> rates) {
        List<Movement> result = new ArrayList<>();
        for (int i = 0; beacon.size() > i; i++) {
            if (i != 0) {
                Beacon b1 = beacon.get(i - 1);
                Beacon b2 = beacon.get(i);
                Movement movement = new Movement(month, iCan, b1, b2);
                movement = movementService.createNewMovement(movement, rates);
                if(movement != null){
                    result.add(movement);
                }
            }
        }
        return result;
    }

    public List<Invoice> getInvoiceByDriver(int id) {
        return invoiceDAO.getInvoicesByDriver(id);
    }

    public List<Invoice> getInvoiceByDriverName(String name) {
        return invoiceDAO.getInvoicesByDriverName(name);
    }

    public boolean updateInvoiceStatus(Invoice invoice) {
        return invoiceDAO.updatePaymentStatus(invoice);
    }

}
