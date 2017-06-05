/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.DriverDAO;
import dao.InvoiceDAO;
import dao.InvoiceRowDAO;
import dao.VehicleDAO;
import domain.Driver;
import domain.Invoice;
import domain.InvoiceRow;
import domain.Vehicle;
import factory.InvoiceTransmittier;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Calendar;
import java.text.SimpleDateFormat;

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
    InvoiceTransmittier invoiceTransmitter;

    @Inject
    DriverDAO driverDAO;
    @Inject
    VehicleDAO vehicleDAO;
    @Inject
    MovementService movementService;

    public boolean createInvoice(Driver driver) {
        Calendar c = Calendar.getInstance();
        String month = new SimpleDateFormat("MMMM").format(c.getTime());
        int year = c.get(Calendar.YEAR);
        Invoice invoice = new Invoice();
        InvoiceRow invoiceRow = new InvoiceRow();
        invoice.setDriver(driver);
        invoice.setMaand(String.valueOf(month + " " + year));
        invoiceDAO.createNewInvoice(invoice);

        List<Vehicle> vehicles = vehicleDAO.getVehicleByOwner(driver.getId());
        for (Vehicle v : vehicles) {
            invoiceRow.setVehicle(v);
            long price = (long) movementService.getMonthprice(v, invoice.getMaand());
            invoiceRow.setPrice(price);
            invoiceRow.setInvoice(invoice);
            invoiceRowDAO.createNewInvoiceRow(invoiceRow);
        }
        return invoiceTransmitter.SendInvoiceToRekeningrijden(invoice);
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
