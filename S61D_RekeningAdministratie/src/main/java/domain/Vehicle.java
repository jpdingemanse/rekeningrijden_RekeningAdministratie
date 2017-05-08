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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author lino_
 */
@Entity
@NamedQueries({
    @NamedQuery(name="vehicle.getByOwnerId", query="select v from Vehicle v where v.owner.id = :id"),
    @NamedQuery(name="vehicle.getAllVehicles", query="select v from Vehicle v")
})
public class Vehicle implements Serializable{
    @Id
    private String licensePlate;
    private String autorisatieCode;
    @ManyToOne
    private Driver owner;
    @OneToOne
    @JoinColumn(name = "TrackerId")
    private Tracker tracker;

    public Vehicle() {
    }

    public Vehicle(String licensePlate, Tracker tracker) {
        this.licensePlate = licensePlate;
        this.tracker = tracker;
    }

    public String getAutorisatieCode() {
        return autorisatieCode;
    }

    public void setAutorisatieCode(String autorisatieCode) {
        this.autorisatieCode = autorisatieCode;
    }
    
    
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Driver getOwner() {
        return owner;
    }

    public void setOwner(Driver owner) {
        this.owner = owner;
    }
    
    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }
}
