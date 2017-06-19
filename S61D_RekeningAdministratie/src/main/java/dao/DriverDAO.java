/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Driver;
import java.util.List;
import javax.ejb.ApplicationException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author lino_
 */
@Stateless
public class DriverDAO {
   
    
    @PersistenceContext
    EntityManager em;

    public DriverDAO() {

    }
   
    public Driver createNewDriver(Driver driver) {
        Driver d = null;
        try {
            em.persist(driver);
            em.flush();

            //d = em.find(Driver.class, driver.getId());
        
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        //System.out.println(d);
        return driver;
    }

    public Driver getDriver(int id) {
        Driver result = em.find(Driver.class, id);
        return result;
    }

    public List<Driver> getDriverByName(String name, String lastName) {
        Query query = em.createNamedQuery("Driver.getDriverByName").setParameter("name", name).setParameter("lastname", lastName);
        return query.getResultList();
    }

    public List<Driver> getAllDrivers() {
        Query query = em.createNamedQuery("Driver.getDrivers");
        return query.getResultList();
    }
}
