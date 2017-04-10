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
public class InvoiceRowDAO {
    @PersistenceContext
    EntityManager em;
    
   
    
    public InvoiceRowDAO()
    {
        
    }
    
    public InvoiceRow createNewInvoiceRow(InvoiceRow invoiceRow){
        em.persist(invoiceRow);
        em.flush();
        return em.find(InvoiceRow.class, invoiceRow.getId());
     
    } 
    
    public List<InvoiceRow> getInvoiceRowsByInvoice(int id)
    {
        Query qeury = em.createNamedQuery("invoicerow.getInvoiceRowByInvoce").setParameter("id", id);
        return qeury.getResultList();
    }
    
     
    
    
}
