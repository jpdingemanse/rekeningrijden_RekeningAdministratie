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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

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

    public void createInvoice() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        List<Driver> drivers = driverDAO.getAllDrivers();
        Invoice invoice = new Invoice();
        InvoiceRow invoiceRow = new InvoiceRow();
        for(Driver d : drivers){
            invoice.setDriver(d);
            invoice.setMaand(String.valueOf(month + year));
            invoiceDAO.createNewInvoice(invoice);
            
            List<Vehicle> vehicles = vehicleDAO.getVehicleByOwner(d.getId());
            for(Vehicle v : vehicles){
                invoiceRow.setVehicle(v);
                invoiceRow.setPrice((long) movementService.getMonthprice(v, invoice.getMaand()));
                invoiceRowDAO.createNewInvoiceRow(invoiceRow);
            }
            invoiceTransmitter.SendInvoiceToRekeningrijden(invoice);
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
