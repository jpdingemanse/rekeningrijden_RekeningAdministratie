/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import dao.DriverDAO;
import dao.InvoiceDAO;
import dao.InvoiceRowDAO;
import dao.RateDAO;
import dao.VehicleDAO;
import domain.Beacon;
import domain.Driver;
import domain.Invoice;
import domain.InvoiceRow;
import domain.Movement;
import domain.Rate;
import domain.Vehicle;
import factory.BeaconTransmitter;
import factory.InvoiceTransmitter;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
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

    // URL of the JMS server. DEFAULT_BROKER_URL will just mean
    // that JMS server is on localhost
    private static final String url = "tcp://192.168.24.41:61616";
    // default broker URL is : tcp://localhost:61616"

    private static final String subject = "Admin"; //Queue Name
    // You can create any/many queue names as per your requirement.

    public Invoice createInvoice(Driver driver) {
        Invoice invoice = new Invoice();
        
        try {
            Gson gson = new Gson();
            Calendar c = Calendar.getInstance();
            String month = new SimpleDateFormat("MMMM").format(c.getTime());
            int year = c.get(Calendar.YEAR);
            InvoiceRow invoiceRow = new InvoiceRow();
            invoice.setDriver(driver);
            invoice.setMonth(String.valueOf(month + " " + year));
            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
            invoice.setTimestamp(timeStamp.getTime());
            invoiceDAO.createNewInvoice(invoice);

            List<Rate> rates = rateDAO.getAllRates();

            List<Vehicle> vehicles = vehicleDAO.getVehicleByOwner(driver.getId());

            for (Vehicle v : vehicles) {
                List<Beacon> beaconList = new ArrayList<>();
                beaconList = beaconTransmitter.GetAllMovementsPerVehicle(v.getiCan());
                if (!beaconList.isEmpty()) {
                    createMovement(beaconList, invoice.getMonth(), v, rates);
                    invoiceRow.setVehicle(v);
                    long price = (long) movementService.getMonthprice(v, invoice.getMonth());
                    invoiceRow.setPrice(price);
                    invoiceRow.setInvoice(invoice);
                    invoiceRow = invoiceRowDAO.createNewInvoiceRow(invoiceRow);
                    sendInvoice(gson.toJson(invoiceRow));
                }
            }
            
            return invoice;
        } catch (JSONException ex) {
            return invoice;
        }

        
    }

    public void createMovement(List<Beacon> beacon, String month, Vehicle vehicle, List<Rate> rates) {
        for (int i = 0; beacon.size() > i; i++) {
            if(i != 0){
                if((i % 2) == 0){
                    Beacon b1 = beacon.get(i - 1);
                    Beacon b2 = beacon.get(i);
                    Movement movement = new Movement(month, vehicle.getiCan(), b1, b2, vehicle);
                    movementService.createNewMovement(movement, rates);
                }
            }
        }
    }

    public void sendInvoice(String bericht) {
        try {
            // Getting JMS connection from the server and starting it
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            Connection connection = connectionFactory.createConnection();
            connection.start();
            // JMS messages are sent and received using a Session. We will
            // create here a non-transactional session object. If you want
            // to use transactions you should set the first parameter to 'true'
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // Destination represents here our queue 'VALLYSOFTQ' on the
            // JMS server. You don't have to do anything special on the
            // server to create it, it will be created automatically.
            Destination destination = session.createQueue(subject);
            // MessageProducer is used for sending messages (as opposed
            // to MessageConsumer which is used for receiving them)
            MessageProducer producer = session.createProducer(destination);
            // We will send a small text message saying 'Hello' in Japanese
            TextMessage message = session.createTextMessage(bericht);
            // Here we are sending the message!
            producer.send(message);
            System.out.println("Sending '" + message.getText() + "'");

            connection.close();
        } catch (JMSException ex) {

        }
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
