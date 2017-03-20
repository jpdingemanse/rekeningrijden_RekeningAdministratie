/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Driver;
import domain.Vehicle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lino_
 */
@Stateless
public class DriverDAO {
    @PersistenceContext
    EntityManager em;
    
    public DriverDAO(){
        
    }
    
    public Driver createNewDriver(Driver driver){
        em.persist(driver);
        em.flush();
        return em.find(Driver.class, driver.getId());
    }
    
    public Driver addVehicleToDriver(Driver driver){
        em.merge(driver);
        return em.find(Driver.class, driver.getId());
    }
}
