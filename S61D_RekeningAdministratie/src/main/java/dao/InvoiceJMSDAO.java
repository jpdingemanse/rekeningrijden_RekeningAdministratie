/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author lino_
 */
@Stateless
public class InvoiceJMSDAO {
    @Inject
    EntityManager em;
    
    public void createNewJMS(InvoiceJMSDAO invoiceJMS){
        try{
            em.persist(invoiceJMS);
            em.flush();
        }catch(Exception e){
            
        }
        
    }
}
