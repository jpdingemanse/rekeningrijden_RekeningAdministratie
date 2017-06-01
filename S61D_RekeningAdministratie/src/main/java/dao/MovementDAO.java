/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Movement;
import domain.Vehicle;
import java.util.List;
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
        return em.find(Movement.class, movement.getId());
    }

    public Movement addBeaconToMovement(Movement movement) {
        Movement tempResult = em.find(Movement.class, movement.getId());
        tempResult.setStartPoint(movement.getStartPoint());
        tempResult.setEndPoint(movement.getEndPoint());
        em.merge(tempResult);
        return em.find(Movement.class, movement.getId());
    }

    public List<Movement> getAllMovements(Vehicle vehicle, String maand) {
        return (List<Movement>) em.createNamedQuery("movement.getMovementsPerMonth");
    }
}
