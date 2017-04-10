/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fhict
 */
@Entity
@NamedQueries({
    @NamedQuery(name="invoicerow.getInvoiceRowByInvoce", query="select ir from InvoiceRow ir where ir.invoice.id = :id")
})
@XmlRootElement
public class InvoiceRow implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long price;
    private String description;
    
    @ManyToOne
    private Invoice invoice;
    
    @ManyToOne
    private Vehicle vehicle;
    
    
    public InvoiceRow(){
        
    }
    
    public InvoiceRow(long price, String description, Invoice invoice, Vehicle vehicle)
    {
        this.description = description;
        this.price = price;
        this.invoice = invoice;
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    
    
    
    
    
    
}
