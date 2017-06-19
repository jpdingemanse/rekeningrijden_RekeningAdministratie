/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Jean Paul
 */
public class Movement implements Serializable {

    
    private int id;
    private String datum; // maand jaar
    private String ican;
    private Beacon startPoint;
    private Beacon endPoint;
    private Rate rate;

    public Movement() {
    }

    public Movement(String date, String ican, Rate rate, Beacon startPoint, Beacon endPoint) {
        this.datum = date;
        this.ican = ican;
        this.rate = rate;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Movement(String date, String ican, Vehicle vehicle) {
        this.datum = date;
        this.ican = ican;
    }

    public Movement(String datum, String ican, Beacon startPoint, Beacon endPoint) {
        this.datum = datum;
        this.ican = ican;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
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
