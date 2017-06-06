/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.BeaconDAO;
import dao.DriverDAO;
import dao.InvoiceDAO;
import dao.InvoiceRowDAO;
import dao.MovementDAO;
import dao.RateDAO;
import dao.RequestDAO;
import dao.UserDAO;
import dao.VehicleDAO;
import domain.Beacon;
import domain.Driver;
import domain.History;
import domain.Invoice;
import domain.InvoiceRow;
import domain.Movement;
import domain.Rate;
import domain.RequestAddVehicleToDriver;
import domain.User;
import domain.Vehicle;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import service.MovementService;

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
    RateDAO rateDao;

    @Inject
    InvoiceRowDAO invoiceRowDAO;

    @Inject
    InvoiceDAO invoiceDAO;

    @Inject
    UserDAO userDAO;

    @Inject
    RequestDAO requestDAO;

    @Inject
    MovementDAO movementDAO;

    @Inject
    MovementService movementService;
    
    @Inject
    BeaconDAO beaconDAO;

    private ArrayList pos;

    @PostConstruct
    public void Init() {
        userDAO.createUser(new User("Administrator", "password"));
        Driver driver = driverDAO.createNewDriver(new Driver("Lino", "Thaencharun", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "lino1", "p@33word", "10c", "0614387088"));

        Vehicle vehicle = vehicleDAO.createNewVehicle(new Vehicle("12-kb-345", "NL123"));
        Vehicle vehicle1 = vehicleDAO.createNewVehicle(new Vehicle("11-kb-345", "NL2345"));
        Vehicle vehicle2 = vehicleDAO.createNewVehicle(new Vehicle("10-kb-345", "NL1234"));
        
        Double zone1LbLat = 53.34316126;
        Double zone1LbLn = 4.56616834;
        
        Double zone1rbLat = 53.34316126;
        Double zone1rbLn = 7.04358534;
        
        Double zone1LoLat = 52.14611856;
        Double zone1L0Ln = 5.47943115;
        
        Double zone1roLat = 52.14611856;
        Double zone1rbLon = 7.10401014;
        
        Double zone2LbLat = 52.23367519;
        Double zone2LbLn = 3.40161756;
        
        Double zone2rbLat = 52.23367519;
        Double zone2rbLn = 6.89526991;
        
        Double zone2LoLat = 51.23353516;
        Double zone2L0Ln = 3.40161756;
        
        Double zone2roLat = 51.23353516;
        Double zone2rbLon = 6.89526991;
        
        Rate rate1 = rateDao.createNewRate(new Rate(1.50, "Zone 1", "€", zone1LbLat, zone1LbLn, zone1LoLat, zone1L0Ln, zone1rbLat, zone1rbLn, zone1roLat, zone1rbLon));
        Rate rate2 = rateDao.createNewRate(new Rate(8.99, "Zone 2", "€", zone2LbLat, zone2LbLn, zone2LoLat, zone2L0Ln, zone2rbLat, zone2rbLn, zone2roLat, zone2rbLon));

        vehicle.setOwner(driver);

        History history = new History(vehicle.getOwner(), new Date());
        history.setId(1);
        List<History> histories = new ArrayList<>();
        histories.add(history);
        vehicle.setHistory(histories);
        vehicleDAO.addVehicleToDriver(vehicle);
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        Invoice invoice = new Invoice("Mei 2017", false, driver, timeStamp.getTime());
        invoiceDAO.createNewInvoice(invoice);
        InvoiceRow invoiceRow = new InvoiceRow(20, "Test Test", invoice, vehicle);

        invoiceRowDAO.createNewInvoiceRow(invoiceRow);

        requestDAO.createNewRequest(new RequestAddVehicleToDriver(1, "test-1", true));
        requestDAO.createNewRequest(new RequestAddVehicleToDriver(1, "test-2", true));
    }
}
