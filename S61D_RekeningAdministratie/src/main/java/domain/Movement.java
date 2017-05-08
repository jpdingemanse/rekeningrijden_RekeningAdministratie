/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author ruthgervandeneikhof
 */
@Entity
public class Movement implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String datum; // maand/jaar
    private String ican;
    @OneToMany
    private List <Position> positions;
    @OneToOne
    private Rate rate;

    public Movement() {
    }
    
    public Movement(String date, String ican, Rate rate){
        this.datum = date;
        this.ican = ican;
        this.rate = rate;
        this.positions = new ArrayList<Position>();
    }

    public String getIcan() {
        return ican;
    }

    public void setIcan(String ican) {
        this.ican = ican;
    }
    
    public String getDate() {
        return datum;
    }

    public void setDate(String date) {
        this.datum = date;
    }   

    public List<Position> getPositions() {
        return positions;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }
    
}
