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
import javax.persistence.OneToOne;

/**
 *
 * @author Jean Paul
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "movement.getMovementsPerMonth", query = "select m from Movement m where m.vehicle = :vehicle and m.datum = :datum")
})
public class Movement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String datum; // maand jaar
    private String ican;
    @OneToOne
    private Beacon startPoint;
    @OneToOne
    private Beacon endPoint;
    @OneToOne
    private Rate rate;
    @ManyToOne
    private Vehicle vehicle;

    public Movement() {
    }

    public Movement(String date, String ican, Rate rate, Vehicle vehicle, Beacon startPoint, Beacon endPoint) {
        this.datum = date;
        this.ican = ican;
        this.rate = rate;
        this.vehicle = vehicle;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Movement(String date, String ican, Vehicle vehicle) {
        this.datum = date;
        this.ican = ican;
        this.vehicle = vehicle;
    }

    public Movement(String datum, String ican, Beacon startPoint, Beacon endPoint, Vehicle vehicle) {
        this.datum = datum;
        this.ican = ican;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.vehicle = vehicle;
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

    public int getId() {
        return id;
    }

    public Beacon getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Beacon startPoint) {
        this.startPoint = startPoint;
    }

    public Beacon getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Beacon endPoint) {
        this.endPoint = endPoint;
    }

}
