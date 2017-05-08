/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.History;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
public class HistoryDao {
    @PersistenceContext
    EntityManager em;
    
    public History createNewHistory(History history){
        em.persist(history);
        return em.find(History.class, history.getId());
    }
    
}
