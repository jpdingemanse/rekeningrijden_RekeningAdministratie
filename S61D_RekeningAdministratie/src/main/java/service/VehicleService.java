/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.HistoryDao;
import dao.VehicleDAO;
import domain.History;
import domain.Vehicle;
import factory.VehicleTransmitter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author lino_
 */
@Stateless
public class VehicleService {
    @Inject
    VehicleDAO vehicleDAO;
    @Inject
    HistoryDao historyDao;
    @Inject
    VehicleTransmitter vehicleTransmitter;
    
    public Vehicle createNewVehicle(Vehicle vehicle){
        Vehicle result = vehicleDAO.createNewVehicle(vehicle);
       // vehicleTransmitter.SendVehicleToRekeningRijder(result);

        return result;
    }

    public Vehicle addVehicleToDriver(Vehicle vehicle) {
        Vehicle result = vehicleDAO.addVehicleToDriver(vehicle);
        History history = new History(vehicle.getOwner(),Date.from(Instant.now()));
        List<History> historyList = new ArrayList();
        historyList.add(historyDao.createNewHistory(history));
        vehicle.setHistory(historyList);
        //vehicleTransmitter.SendAddVehicleToDriverRekeningRijder(result);
        return result;
    }
    
    public List<Vehicle> getVehicleByOwner(int id){
        return vehicleDAO.getVehicleByOwner(id);
    }
    
    public List<Vehicle> getAllVehicles(){
        return vehicleDAO.getAllVehicles();
    }
    
    public Vehicle addTrackerToVehicle(Vehicle vehicle){
        return vehicleDAO.addTrackerToVehicle(vehicle);
    }

    public Vehicle getVehicleByLicensePlate(String licensePlate) {
        return vehicleDAO.getVehicleByLicensePlate(licensePlate);
    }

    public Vehicle updateAutorisatieCode(Vehicle vehicle) {
        return vehicleDAO.updateAuthorisatieCode(vehicle);
    }

    public Vehicle updateIcan(Vehicle vehicle) {
        return vehicleDAO.updateIcan(vehicle);
    }
    
    

    
}

