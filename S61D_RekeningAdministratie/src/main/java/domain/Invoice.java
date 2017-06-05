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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fhict
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "invoice.getInvoiceByDriver", query = "select i from Invoice i where i.driver.id = :id")
    ,
    @NamedQuery(name = "invoice.getInvoiceByDriverName", query = "select i from Invoice i where i.driver.name = :name")
})
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String maand;
    private boolean paid;
   
    
    @OneToMany(mappedBy = "invoice")
    private List<InvoiceRow> invoiceRows;
    @ManyToOne
    private Driver driver;

    public Invoice() {
    }

    public Invoice(String maand, boolean paid, Driver driver) {
        this.maand = maand;
        this.paid = paid;
        this.driver = driver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaand() {
        return maand;
    }

    public void setMaand(String maand) {
        this.maand = maand;
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
