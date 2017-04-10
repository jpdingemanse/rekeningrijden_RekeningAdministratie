/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fhict
 */
@Entity
@NamedQueries({
    @NamedQuery(name="invoice.getInvoiceByDriver", query="select i from Invoice i where i.driver.id = :id")
})
@XmlRootElement
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private double totalPrice;
    private int totalDistant;
    private long timeCreated;
    private boolean paid;
    @OneToMany
    private List<InvoiceRow> invoiceRows;
    @ManyToOne
    private Driver driver;

    public Invoice() {
    }

    public Invoice(double totalPrice, int totalDistant, long timeCreated, Driver driver, boolean paid) {
        this.totalPrice = totalPrice;
        this.totalDistant = totalDistant;
        this.timeCreated = timeCreated;
        this.driver = driver;
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalDistant() {
        return totalDistant;
    }

    public void setTotalDistant(int totalDistant) {
        this.totalDistant = totalDistant;
    }

    public long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @XmlTransient
    public List<InvoiceRow> getInvoiceRows() {
        return invoiceRows;
    }

    public void setInvoiceRows(List<InvoiceRow> invoiceRows) {
        this.invoiceRows = invoiceRows;
    }
    
    
    
}
