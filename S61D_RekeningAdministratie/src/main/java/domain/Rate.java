/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author ruthgervandeneikhof
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
    @ManyToMany
    private ArrayList<Position> border;
    
    public Rate(){}

    public Rate(double rate, String region,String currency) {
        this.rate = rate;
        this.region = region;
        this.currency = currency;
        this.border = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList getBorder() {
        return border;
    }

    public void setBorder(ArrayList border) {
        this.border = border;
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
    
    public void addPosition(ArrayList pos){
        this.border.addAll(pos);
    }
}
