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

        Vehicle vehicle = vehicleDAO.createNewVehicle(new Vehicle("12-kb-345", "NL1234"));
        Vehicle vehicle1 = vehicleDAO.createNewVehicle(new Vehicle("11-kb-345", "NL2345"));
        Vehicle vehicle2 = vehicleDAO.createNewVehicle(new Vehicle("10-kb-345", "NL3456"));
        Rate rate1 = rateDao.createNewRate(new Rate(1.50, "Eindhoven", "€", 51.5, 5.56, 50.5, 5.25, 51.4, 5.56, 51.4, 5.25));
        Rate rate2 = rateDao.createNewRate(new Rate(8.99, "Limburg", "€", 51.3, 5.55, 50.0, 5.50, 51.39, 5.24, 51.0, 5.10));

        vehicle.setOwner(driver);

        History history = new History(vehicle.getOwner(), new Date());
        history.setId(1);
        List<History> histories = new ArrayList<>();
        histories.add(history);
        vehicle.setHistory(histories);
        vehicleDAO.addVehicleToDriver(vehicle);
        
        Beacon beacon = new Beacon("NL1234", 50.5, 5.26, Long.valueOf(12345));
        Beacon beacon1 = new Beacon("NL1234", 50.6, 5.30, Long.valueOf(12345));
        beaconDAO.createNewBeacon(beacon);
        beaconDAO.createNewBeacon(beacon1);
        Movement movement = new Movement("Mei 2017", "NL1234", rate1, vehicle, beacon, beacon1);
        movementDAO.createNewMovement(movement);
        Invoice invoice = new Invoice("Mei 2017", false, driver);
        invoiceDAO.createNewInvoice(invoice);
        InvoiceRow invoiceRow = new InvoiceRow(20, "Test Test", invoice, vehicle);

        invoiceRowDAO.createNewInvoiceRow(invoiceRow);

        requestDAO.createNewRequest(new RequestAddVehicleToDriver(1, "test-1", true));
        requestDAO.createNewRequest(new RequestAddVehicleToDriver(1, "test-2", true));
    }
}
