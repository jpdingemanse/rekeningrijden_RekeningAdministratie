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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author Jean Paul
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Rate.getAllRates", query="Select d from Rate d"),
    @NamedQuery(name = "Rate.getRateById", query="Select d from Rate d where d.id = :rateId")     
}
)
public class Rate implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double rate;
    private String region;
    private String currency;
    private double latLB;
    private double lonLB;
    private double latLO;
    private double lonLO;
    private double latRB;
    private double lonRB;
    private double latRO;
    private double lonRO;

    
    public Rate(){}

    public Rate(double rate, String region, String currency, double latLB, double lonLB, double latLO, double lonLO, double latRB, double lonRB, double latRO, double lonRO) {
        this.rate = rate;
        this.region = region;
        this.currency = currency;
        this.latLB = latLB;
        this.lonLB = lonLB;
        this.latLO = latLO;
        this.lonLO = lonLO;
        this.latRB = latRB;
        this.lonRB = lonRB;
        this.latRO = latRO;
        this.lonRO = lonRO;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getLatLB() {
        return latLB;
    }

    public void setLatLB(double latLB) {
        this.latLB = latLB;
    }

    public double getLonLB() {
        return lonLB;
    }

    public void setLonLB(double lonLB) {
        this.lonLB = lonLB;
    }

    public double getLatLO() {
        return latLO;
    }

    public void setLatLO(double latLO) {
        this.latLO = latLO;
    }

    public double getLonLO() {
        return lonLO;
    }

    public void setLonLO(double lonLO) {
        this.lonLO = lonLO;
    }

    public double getLatRB() {
        return latRB;
    }

    public void setLatRB(double latRB) {
        this.latRB = latRB;
    }

    public double getLonRB() {
        return lonRB;
    }

    public void setLonRB(double lonRB) {
        this.lonRB = lonRB;
    }

    public double getLatRO() {
        return latRO;
    }

    public void setLatRO(double latRO) {
        this.latRO = latRO;
    }

    public double getLonRO() {
        return lonRO;
    }

    public void setLonRO(double lonRO) {
        this.lonRO = lonRO;
    }
    
    
}
