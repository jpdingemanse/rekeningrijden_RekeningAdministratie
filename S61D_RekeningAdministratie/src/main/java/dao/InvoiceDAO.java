/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Driver;
import domain.Invoice;
import domain.InvoiceRow;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author lino_
 */
@Stateless
public class InvoiceDAO {
    @PersistenceContext
    EntityManager em;
    
    
    public InvoiceDAO()
    {
        
    }
    
      public Invoice createNewInvoice(Invoice invoice){
        em.persist(invoice);
        em.flush();
        return em.find(Invoice.class, invoice.getId());
    }  
    public List<Invoice> getInvoicesByDriver(int id)
    {
        Query qeury = em.createNamedQuery("invoice.getInvoiceByDriver").setParameter("id", id);
        return qeury.getResultList();
    }

    public boolean updatePaymentStatus(Invoice invoice) {
        Invoice selectedResult = em.find(Invoice.class, invoice.getId());
        if(selectedResult != null){
            selectedResult.setPaid(true);
            em.merge(selectedResult);
            return true;
        }
        return false;
    }
    
    
}
