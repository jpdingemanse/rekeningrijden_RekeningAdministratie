/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Movement;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author victo
 */
@Stateless
public class MovementDAO {
    @PersistenceContext
    EntityManager em;
    
    public Movement createNewMovement(Movement movement) {
        em.persist(movement);
        em.flush();
        return em.find(Movement.class, movement.getIcan());
    }
    
    
}
