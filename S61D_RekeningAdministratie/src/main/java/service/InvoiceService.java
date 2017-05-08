/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.InvoiceDAO;
import domain.Driver;
import domain.Invoice;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author fhict
 */
@Stateless
public class InvoiceService {
    @Inject
    InvoiceDAO invoiceDAO;
    
    
    public Invoice createInvoice(Invoice invoice)
    {
       return invoiceDAO.createNewInvoice(invoice);
    }
    
    public List<Invoice> getInvoiceByDriver(int id)
    {
        return invoiceDAO.getInvoicesByDriver(id);
    }

    public boolean updateInvoiceStatus(Invoice invoice) {
        return invoiceDAO.updatePaymentStatus(invoice);
    }
    
    
}
