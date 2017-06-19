/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.InvoiceJMS;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lino_
 */
@Stateless
public class InvoiceJMSDAO {
    @PersistenceContext
    EntityManager em;
    
    public void createNewJMS(InvoiceJMS invoiceJMS){
        try{
            em.persist(invoiceJMS);
            em.flush();
            em.find(InvoiceJMS.class, invoiceJMS.getId());
        }catch(Exception e){
            
        }
        
    }
}
