/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;

import domain.Driver;
import domain.Invoice;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import service.InvoiceService;

/**
 *
 * @author fhict
 */
@Stateless
@Path("Invoice")
public class InvoiceResource {
    @Inject
    InvoiceService invoiceService;
    
    @POST
    @Path("CreateInvoice")
    @Consumes("application/json")
    public Invoice createInvoice(Invoice invoice){
        return invoiceService.createInvoice(invoice);
    }
    
     @GET
    @Path("GetInvoices/{id}")
    public List<Invoice> getInvoiceByDriver(@PathParam("id")String name){
        return invoiceService.getInvoiceByDriverName(name);
    }
    
    @POST
    @Path("UpdatePayment")
    @Consumes("application/json")
    public boolean updateInvoiceStatus(Invoice invoice){
        return invoiceService.updateInvoiceStatus(invoice);
    }
   
}
