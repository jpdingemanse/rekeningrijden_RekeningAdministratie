/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.InvoiceDAO;
import dao.InvoiceRowDAO;
import domain.InvoiceRow;
import domain.Vehicle;
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
    @Inject
    InvoiceDAO invoiceDAO;
    @Inject
    MovementService movementService;

    public InvoiceRow createInvoiceRow(InvoiceRow invoiceRow) {
        return invoiceRowDAO.createNewInvoiceRow(invoiceRow);
    }

    public List<InvoiceRow> getInvoiceRowsByInvoice(int id) {
        List<InvoiceRow> invoicerows = invoiceRowDAO.getInvoiceRowsByInvoice(id);
        return invoicerows;
    }

}
