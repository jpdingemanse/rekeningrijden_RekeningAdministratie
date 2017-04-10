/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;


import domain.Invoice;
import domain.InvoiceRow;
import domain.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import service.InvoiceRowService;
import service.VehicleService;

/**
 *
 * @author fhict
 */
@Stateless
@Path("InvoiceRow")
public class InvoiceRowResource {
    @Inject
    InvoiceRowService invoiceRowService;
    
    @POST
    @Path("CreateInvoiceRow")
    @Consumes("application/json")
    public InvoiceRow createInvoiceRow(InvoiceRow invoiceRow){
        return invoiceRowService.createInvoiceRow(invoiceRow);
    }
    
     @GET
    @Path("GetInvoiceRows/{id}")
    public List<InvoiceRow> getInvoiceRowsByInvoice(@PathParam("id")int id){
        return invoiceRowService.getInvoiceRowsByInvoice(id);
    }
   
}
