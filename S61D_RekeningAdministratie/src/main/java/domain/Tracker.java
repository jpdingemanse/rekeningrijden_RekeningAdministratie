/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author victo
 */
@Entity
public class Tracker implements Serializable {
    @Id
    String id;
    double Latitude;
    double longitude;
    @OneToOne
    private Driver driver;

    public Tracker(String id, double Latitude, double longitude) {
        this.id = id;
        this.Latitude = Latitude;
        this.longitude = longitude;
    }

    public Tracker() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double Latitude) {
        this.Latitude = Latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    
    
}
