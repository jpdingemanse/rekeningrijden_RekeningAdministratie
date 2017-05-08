/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.InvoiceDAO;
import domain.Driver;
import domain.Invoice;
import factory.InvoiceTransmittier;
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
    
    @Inject
    InvoiceTransmittier invoiceTransmitter;
    
    
    public Invoice createInvoice(Invoice invoice)
    {
       Invoice tmpResult = invoiceDAO.createNewInvoice(invoice);
       invoiceTransmitter.SendInvoiceToRekeningrijden(invoice);
       return tmpResult;
    }
    
    public List<Invoice> getInvoiceByDriver(int id)
    {
        return invoiceDAO.getInvoicesByDriver(id);
    }

    public boolean updateInvoiceStatus(Invoice invoice) {
        return invoiceDAO.updatePaymentStatus(invoice);
    }
    
    
}
