/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Rate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jean Paul
 */
@Stateless
public class RateDAO {

    @PersistenceContext
    EntityManager em;

    public Rate createNewRate(Rate rate) {
        em.persist(rate);
        em.flush();
        return em.find(Rate.class, rate.getId());
    }

    public void mergePosition(Rate rate) {
        em.merge(rate);
        em.flush();
    }

    public Rate editRate(Rate rate) {
        Rate r = (Rate)em.createNamedQuery("Rate.getRateById").setParameter("rateId", rate.getId()).getSingleResult();
        r.setRate(rate.getRate());
        em.merge(r);
        em.flush();
        return em.find(Rate.class, rate.getId());
    }
    
    public List<Rate> getAllRates() {
        return em.createNamedQuery("Rate.getAllRates").getResultList();
    }
}
