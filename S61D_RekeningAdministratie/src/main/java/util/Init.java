/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.DriverDAO;
import dao.RateDAO;
import dao.VehicleDAO;
import domain.Driver;
import domain.Position;
import domain.Rate;
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
    RateDAO rateDao;
    
    @PostConstruct
    public void Init() {
        Driver driver = driverDAO.createNewDriver(new Driver("Lino", "Thaencharun", "5611SH", "Eindhoven", "Lino_thaencharun@hotmail.com", "lino1", "p@33word", "10c", "0614387088"));
//        List<Position> pos = new ArrayList<>();
//        pos.add(new Position("linksb", 51.5, 5.25));
//        pos.add(new Position("rechtsb", 51.5, 5.56));
//        pos.add(new Position("linkso"   , 51.4, 5.25));
//        pos.add(new Position("rechtso", 51.4, 5.56));
//        Rate rate = rateDao.createNewRate(new Rate(1.50, "Eindhoven", "€", pos));
//        rate = rateDao.createNewRate(new Rate(8.99, "", "€", pos));
        Vehicle vehicle = vehicleDAO.createNewVehicle(new Vehicle("12-kb-345"));
        Vehicle vehicle1 = vehicleDAO.createNewVehicle(new Vehicle("11-kb-345"));
        Vehicle vehicle2 = vehicleDAO.createNewVehicle(new Vehicle("10-kb-345"));
        vehicle.setOwner(driver);
        vehicleDAO.addVehicleToDriver(vehicle);
    }
}
