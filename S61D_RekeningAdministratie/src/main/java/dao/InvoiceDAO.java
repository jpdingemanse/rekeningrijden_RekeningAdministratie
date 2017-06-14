/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Invoice;
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

    public InvoiceDAO() {

    }

    public Invoice createNewInvoice(Invoice invoice) {
        try{
        em.persist(invoice);
        em.flush();
        
        } catch(Exception ex){
            
        }
        Invoice i = em.find(Invoice.class, invoice.getId());
        return i;
    }
    public boolean checkInvoice(Invoice invoice){
        Query query = em.createNamedQuery("invoice.checkInvoice").setParameter("month", invoice.getMonth()).setParameter("driverId", invoice.getDriver().getId());
        List<Invoice> result = query.getResultList();
        if(!result.isEmpty()){
            return true;
        }
        return false;
    }
    public List<Invoice> getInvoicesByDriver(int id) {
        Query qeury = em.createNamedQuery("invoice.getInvoiceByDriver").setParameter("id", id);
        return qeury.getResultList();
    }

    public List<Invoice> getInvoicesByDriverName(String name) {
        Query qeury = em.createNamedQuery("invoice.getInvoiceByDriverName").setParameter("name", name);
        return qeury.getResultList();
    }

    public boolean updatePaymentStatus(Invoice invoice) {
        Invoice selectedResult = em.find(Invoice.class, invoice.getId());
        if (selectedResult != null) {
            selectedResult.setPaid(true);
            em.merge(selectedResult);
            return true;
        }
        return false;
    }

    public Invoice getInvoiceById(int id) {
        return em.find(Invoice.class, id);
    }
}
