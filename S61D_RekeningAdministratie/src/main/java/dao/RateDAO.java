/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Driver;
import domain.Rate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
public class RateDAO {
    @PersistenceContext
    EntityManager em;
    
    public Rate createNewRate(Rate rate){
        em.persist(rate);
        em.flush();
        return em.find(Rate.class, rate.getId());
    }
}
