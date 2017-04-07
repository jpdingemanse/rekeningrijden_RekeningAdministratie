/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ruthgervandeneikhof
 */
public class Movement implements Serializable{
    private List<Beacon> beacons;
    private String date; // maand/jaar
    
    public Movement(List<Beacon> beacons, String date){
        this.beacons = beacons;
        this.date = date;
    }

    public List<Beacon> getBeacons() {
        return beacons;
    }

    public void setBeacons(List<Beacon> beacons) {
        this.beacons = beacons;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }   
}
