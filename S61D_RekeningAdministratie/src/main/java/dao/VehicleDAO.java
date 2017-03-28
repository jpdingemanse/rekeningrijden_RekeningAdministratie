/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Vehicle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



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
}
