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

/**
 *
 * @author Jean Paul
 */
@Entity
public class InvoiceJMS implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String FromCountry;
    private Long Timestamp;
    private Double TotalPrice;
    private String ICan;

    public InvoiceJMS() {
    }

    public InvoiceJMS(String FromCountry, Long Timestamp, Double TotalPrice, String ICan) {
        this.FromCountry = FromCountry;
        this.Timestamp = Timestamp;
        this.TotalPrice = TotalPrice;
        this.ICan = ICan;
    }

    public String getFromCountry() {
        return FromCountry;
    }

    public void setFromCountry(String FromCountry) {
        this.FromCountry = FromCountry;
    }

    public Long getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(Long Timestamp) {
        this.Timestamp = Timestamp;
    }

    public Double getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(Double TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public String getICan() {
        return ICan;
    }

    public void setICan(String ICan) {
        this.ICan = ICan;
    }
    
    
    
}
