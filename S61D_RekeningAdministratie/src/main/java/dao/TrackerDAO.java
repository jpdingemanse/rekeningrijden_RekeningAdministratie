/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Tracker;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author victo
 */
@Stateless
public class TrackerDAO {
    @PersistenceContext
    EntityManager em;
    
    public Tracker createNewTracker(Tracker tracker){
        em.persist(tracker);
        em.flush();
        return em.find(Tracker.class, tracker.getId());
    } 
}
