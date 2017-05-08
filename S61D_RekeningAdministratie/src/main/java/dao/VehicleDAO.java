/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



/**
 *
 * @author lino_
 */
@Stateless
public class VehicleDAO {
    
    @PersistenceContext
    EntityManager em;

    public VehicleDAO() {
    }
    
    public Vehicle createNewVehicle(Vehicle vehicle){
        em.persist(vehicle);
        em.flush();
        return em.find(Vehicle.class, vehicle.getLicensePlate());
    }   
         
    public Vehicle addTrackerToVehicle(Vehicle vehicle){
        em.merge(vehicle);
        return em.find(Vehicle.class, vehicle.getLicensePlate());
    }
    
    
    public Vehicle addVehicleToDriver(Vehicle vehicle){
        Vehicle tempResult = em.find(Vehicle.class, vehicle.getLicensePlate());
        tempResult = vehicle;
        em.merge(tempResult);
        return em.find(Vehicle.class, vehicle.getLicensePlate());
    }
    public List<Vehicle> getVehicleByOwner(int id){
        Query qeury = em.createNamedQuery("vehicle.getByOwnerId").setParameter("id", id);
        return qeury.getResultList();
    }
    
    public List<Vehicle> getAllVehicles(){
        Query qeury = em.createNamedQuery("vehicle.getAllVehicles");
        return qeury.getResultList();
    }

    public Vehicle getVehicleByLicensePlate(String licensePlate) {
        Vehicle result = em.find(Vehicle.class, licensePlate);
        return result;
    }

    public Vehicle updateAuthorisatieCode(Vehicle vehicle) {
        Vehicle tempResult = em.find(Vehicle.class, vehicle.getLicensePlate());
        tempResult.setAutorisatieCode(vehicle.getAutorisatieCode());
        em.merge(tempResult);
        return em.find(Vehicle.class, vehicle.getLicensePlate());
    }
    

//    public Vehicle updateTracker(Vehicle vehicle){
//        Vehicle tempResult = em.find(Vehicle.class, vehicle.getLicensePlate());
//        tempResult.setTracker(vehicle.getTracker());
//        em.merge(tempResult);
//        return em.find(Vehicle.class, vehicle.getLicensePlate());
//    }
}
