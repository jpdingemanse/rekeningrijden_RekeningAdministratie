/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.DriverDAO;
import domain.Driver;
import factory.DriverTransmitter;
import factory.VehicleTransmitter;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author lino_
 */
@Stateless
public class DriverService {
    @Inject
    DriverDAO driverDao;
    DriverTransmitter ds = new DriverTransmitter();
    
    public Driver createNewDriver(Driver driver){
        Driver d = null;
        try{
            d = driverDao.createNewDriver(driver);
            
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        if(driver != null){
//            ds.SendDriverToRekeningRijder(d);
        }
         return d;
    }

    public Driver getDriver(int id) {
        return driverDao.getDriver(id);
    }

    public List<Driver> getDriverByName(String name, String lastName) {
       return driverDao.getDriverByName(name, lastName);
    }
    
}
