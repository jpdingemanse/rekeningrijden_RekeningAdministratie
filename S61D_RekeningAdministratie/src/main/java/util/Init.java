/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.DriverDAO;
import dao.InvoiceDAO;
import dao.InvoiceRowDAO;
import dao.RateDAO;
import dao.TrackerDAO;
import dao.UserDAO;
import dao.VehicleDAO;
import domain.Driver;
import domain.Invoice;
import domain.InvoiceRow;
import domain.Position;
import domain.Rate;
import domain.Tracker;
import domain.User;
import domain.Vehicle;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author lino_
 */
@Startup
@Singleton
public class Init {

    @Inject
    DriverDAO driverDAO;

    @Inject
    VehicleDAO vehicleDAO;

    @Inject
    TrackerDAO trackerDao;

    @Inject
    RateDAO rateDao;
    
     @Inject 
    InvoiceRowDAO invoiceRowDAO;
    
    @Inject 
    InvoiceDAO invoiceDAO;
    
    @Inject
    UserDAO userDAO;

    private ArrayList pos;

    @PostConstruct
    public void Init() {
        userDAO.createUser(new User("Administrator", "password"));
        Driver driver = driverDAO.createNewDriver(new Driver("Lino", "NL12345", "Thaencharun", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "lino1", "p@33word", "10c", "0614387088"));
        pos = new ArrayList<>();
        pos.add(new Position("linksb", 51.5, 5.25));
        pos.add(new Position("rechtsb", 51.5, 5.56));
        pos.add(new Position("linkso", 51.4, 5.25));
        pos.add(new Position("rechtso", 51.4, 5.56));
        Rate rate = rateDao.createNewRate(new Rate(1.50, "Eindhoven", "€"));
        rate.addPosition(pos);
        rateDao.mergePosition(rate);
        rate = rateDao.createNewRate(new Rate(8.99, "Limburg", "€"));
        rate.addPosition(pos);
        rateDao.mergePosition(rate);
        Tracker tracker = trackerDao.createNewTracker(new Tracker("1", 12, 13));
        Tracker tracker1 = trackerDao.createNewTracker(new Tracker("2", 15, 15));
        Tracker tracker2 = trackerDao.createNewTracker(new Tracker("3", 20, 20));
        Vehicle vehicle = vehicleDAO.createNewVehicle(new Vehicle("12-kb-345", new Tracker("1", 12, 13)));
        Vehicle vehicle1 = vehicleDAO.createNewVehicle(new Vehicle("11-kb-345", new Tracker("2", 15, 15)));
        Vehicle vehicle2 = vehicleDAO.createNewVehicle(new Vehicle("10-kb-345", new Tracker("3", 20, 20)));
        vehicle.setOwner(driver);
        vehicleDAO.addVehicleToDriver(vehicle);
        
        
        Invoice invoice = new Invoice(250 ,22 ,221012 , driver,false);
        invoice = invoiceDAO.createNewInvoice(invoice);
        InvoiceRow invoiceRow = new InvoiceRow(20 ,"Test Test", invoice, vehicle);
        
       
       invoiceRowDAO.createNewInvoiceRow(invoiceRow);
    }
}
