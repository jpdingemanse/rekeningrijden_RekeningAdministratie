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
import service.DriverService;
import service.MovementService;
import service.VehicleService;

/**
 *
 * @author lino_
 */
@Startup
@Singleton
public class Init {

    @Inject
    DriverService driverService;

    @Inject
    VehicleService vehicleService;
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
        Driver driver = driverService.createNewDriver(new Driver("Lino", "Thaencharun", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "lino1", "p@33word", "10c", "0614387088"));

        Driver driver2 = driverService.createNewDriver(new Driver("Jan", "Jansen", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Jan", "p@33word", "10c", "0614387088"));

        Driver driver3 = driverService.createNewDriver(new Driver("Ruther", "Eik", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Ruther", "p@33word", "10c", "0614387088"));
        Driver driver4 = driverService.createNewDriver(new Driver("Victor", " Kessel", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Victor", "p@33word", "10c", "0614387088"));
        Driver driver5 = driverService.createNewDriver(new Driver("Sergio", "Reist ver", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Sergio", "p@33word", "10c", "0614387088"));
        Driver driver6 = driverService.createNewDriver(new Driver("Jean", "Ding", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Jean", "p@33word", "10c", "0614387088"));
        Driver driver7 = driverService.createNewDriver(new Driver("Paul", "Manse", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Paul", "p@33word", "10c", "0614387088"));

        Driver driver8 = driverService.createNewDriver(new Driver("Klaas", "klant", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Klaas", "p@33word", "10c", "0614387088"));

        Driver driver9 = driverService.createNewDriver(new Driver("Piet", "aster", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Piet", "p@33word", "10c", "0614387088"));

        Driver driver10 = driverService.createNewDriver(new Driver("Peter", "Charun", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Peter", "p@33word", "10c", "0614387088"));

        Driver driver11 = driverService.createNewDriver(new Driver("Eric", "Theaters", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Eric", "p@33word", "10c", "0614387088"));

        Driver driver12 = driverService.createNewDriver(new Driver("Juul", "Bulgie", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Juul", "p@33word", "10c", "0614387088"));
        Driver driver13 = driverService.createNewDriver(new Driver("Kurkie", "Tanas", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Kurkie", "p@33word", "10c", "0614387088"));

        Driver driver14 = driverService.createNewDriver(new Driver("Kirity", "Thantecharun", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Kirity", "p@33word", "10c", "0614387088"));

        Driver driver15 = driverService.createNewDriver(new Driver("Don", "Doner", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Don", "p@33word", "10c", "0614387088"));

        Driver driver16 = driverService.createNewDriver(new Driver("Lam", "Lammers", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Lam", "p@33word", "10c", "0614387088"));

        Driver driver17 = driverService.createNewDriver(new Driver("Koe", "Koekenbakker", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Koe", "p@33word", "10c", "0614387088"));
        Driver driver18 = driverService.createNewDriver(new Driver("Paard", "Haar", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Paard", "p@33word", "10c", "0614387088"));

        Driver driver19 = driverService.createNewDriver(new Driver("Kip", "Spies", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Kip", "p@33word", "10c", "0614387088"));

        Driver driver20 = driverService.createNewDriver(new Driver("Ice", "The", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "Ice", "p@33word", "10c", "0614387088"));

        Vehicle vehicleBuitenland1 = vehicleService.createNewVehicle(new Vehicle("10-kb-311", "NL 200 000 000 000 001", driver));

        Vehicle vehicleBuitenland2 = vehicleService.createNewVehicle(new Vehicle("10-kb-346", "NL 200 000 000 000 002", driver2));

        Vehicle vehicleBuitenland3 = vehicleService.createNewVehicle(new Vehicle("10-kb-347", "NL 200 000 000 000 003",driver3));

        Vehicle vehicleBuitenland4 = vehicleService.createNewVehicle(new Vehicle("10-kb-348", "NL 200 000 000 000 004",driver4));

        Vehicle vehicleBuitenland5 = vehicleService.createNewVehicle(new Vehicle("10-kb-349", "NL 200 000 000 000 005", driver5));

        Vehicle vehicleBuitenland6 = vehicleService.createNewVehicle(new Vehicle("10-kb-310", "NL 200 000 000 000 006", driver6));

        Vehicle vehicleBuitenland7 = vehicleService.createNewVehicle(new Vehicle("10-kb-312", "NL 200 000 000 000 007", driver7));

        Vehicle vehicleBuitenland8 = vehicleService.createNewVehicle(new Vehicle("10-kb-313", "NL 200 000 000 000 008", driver8));

        Vehicle vehicleBuitenland9 = vehicleService.createNewVehicle(new Vehicle("10-kb-314", "NL 200 000 000 000 009", driver9));

        Vehicle vehicleBuitenland10 = vehicleService.createNewVehicle(new Vehicle("10-kb-315", "NL 200 000 000 000 010", driver10));

        Vehicle vehicleBuitenland11 = vehicleService.createNewVehicle(new Vehicle("10-kb-316", "NL 200 000 000 000 011", driver11));

        Vehicle vehicleBuitenland12 = vehicleService.createNewVehicle(new Vehicle("10-kb-317", "NL 200 000 000 000 012", driver12));

        Vehicle vehicleBuitenland13 = vehicleService.createNewVehicle(new Vehicle("10-kb-318", "NL 200 000 000 000 013", driver13));

        Vehicle vehicleBuitenland14 = vehicleService.createNewVehicle(new Vehicle("10-kb-319", "NL 200 000 000 000 014", driver14));

        Vehicle vehicleBuitenland15 = vehicleService.createNewVehicle(new Vehicle("10-kb-320", "NL 200 000 000 000 015", driver15));

        Vehicle vehicleBuitenland16 = vehicleService.createNewVehicle(new Vehicle("10-kb-321", "NL 200 000 000 000 016", driver16));

        Vehicle vehicleBuitenland17 = vehicleService.createNewVehicle(new Vehicle("10-kb-322", "NL 200 000 000 000 017", driver17));

        Vehicle vehicleBuitenland18 = vehicleService.createNewVehicle(new Vehicle("10-kb-323", "NL 200 000 000 000 018", driver18));

        Vehicle vehicleBuitenland19 = vehicleService.createNewVehicle(new Vehicle("10-kb-324", "NL 200 000 000 000 019", driver19));

        Vehicle vehicleBuitenland20 = vehicleService.createNewVehicle(new Vehicle("10-kb-325", "NL 200 000 000 000 020", driver20));

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

//       vehicleService.addVehicleToDriver(vehicleBuitenland1);
//        vehicleService.addVehicleToDriver(vehicleBuitenland2);
//        vehicleService.addVehicleToDriver(vehicleBuitenland3);
//        vehicleService.addVehicleToDriver(vehicleBuitenland4);
//        vehicleService.addVehicleToDriver(vehicleBuitenland5);
//        vehicleService.addVehicleToDriver(vehicleBuitenland6);
//        vehicleService.addVehicleToDriver(vehicleBuitenland7);
//        vehicleService.addVehicleToDriver(vehicleBuitenland8);
//        vehicleService.addVehicleToDriver(vehicleBuitenland9);
//        vehicleService.addVehicleToDriver(vehicleBuitenland10);
//        vehicleService.addVehicleToDriver(vehicleBuitenland11);
//        vehicleService.addVehicleToDriver(vehicleBuitenland12);
//        vehicleService.addVehicleToDriver(vehicleBuitenland13);
//        vehicleService.addVehicleToDriver(vehicleBuitenland14);
//        vehicleService.addVehicleToDriver(vehicleBuitenland15);
//        vehicleService.addVehicleToDriver(vehicleBuitenland16);
//        vehicleService.addVehicleToDriver(vehicleBuitenland17);
//        vehicleService.addVehicleToDriver(vehicleBuitenland18);
//        vehicleService.addVehicleToDriver(vehicleBuitenland19);
//        vehicleService.addVehicleToDriver(vehicleBuitenland20);

//        History history = new History(vehicleBuitenland1.getOwner(), new Date());
//        history.setId(1);
//        List<History> histories = new ArrayList<>();
//        histories.add(history);
//        vehicleBuitenland1.setHistory(histories);
        

//        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
//        Invoice invoice = new Invoice("Mei 2017", false, driver, timeStamp.getTime());
//        invoice = invoiceDAO.createNewInvoice(invoice);
//        InvoiceRow invoiceRow = new InvoiceRow(20, "Test Test", invoice, vehicleBuitenland1);
//
//        invoiceRow = invoiceRowDAO.createNewInvoiceRow(invoiceRow);

//        requestDAO.createNewRequest(new RequestAddVehicleToDriver(1, "test-1", true));
//        requestDAO.createNewRequest(new RequestAddVehicleToDriver(1, "test-2", true));
    }
}
