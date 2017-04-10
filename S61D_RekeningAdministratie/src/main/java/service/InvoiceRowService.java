/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.InvoiceRowDAO;
import domain.Invoice;
import domain.InvoiceRow;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author fhict
 */
@Stateless
public class InvoiceRowService {
    @Inject
    InvoiceRowDAO invoiceRowDAO;
    
    public InvoiceRow createInvoiceRow(InvoiceRow invoiceRow)
    {
       return invoiceRowDAO.createNewInvoiceRow(invoiceRow);
    }
    
    
   public List<InvoiceRow> getInvoiceRowsByInvoice(int id)
   {
       return invoiceRowDAO.getInvoiceRowsByInvoice(id);
   }
    
}
