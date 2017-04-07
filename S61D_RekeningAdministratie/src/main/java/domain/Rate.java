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

/**
 *
 * @author ruthgervandeneikhof
 */
@Entity
public class Rate implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double rate;
    private String region;
    private String currency;
    private List<Position> border;
    
    public Rate(){}

    public Rate(double rate, String region,String currency  ,List<Position> border) {
        this.rate = rate;
        this.region = region;
        this.border = border;
        this.currency = currency;
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

    public List<Position> getBorder() {
        return border;
    }

    public void setBorder(List<Position> border) {
        this.border = border;
    }
}
