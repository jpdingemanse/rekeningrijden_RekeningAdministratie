/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Position;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author victo
 */
public class PositionDAO {
    @PersistenceContext
    EntityManager em;
    
    public List<Position> getAllPositions() {
        return em.createNamedQuery("Position.getAllPositions").getResultList();
    }
    
}
