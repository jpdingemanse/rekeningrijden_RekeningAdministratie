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

/**
 *
 * @author lino_
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Request.getRequestInProgress", query="Select r from RequestAddVehicleToDriver r where r.status = true"),
    @NamedQuery(name = "Request.getAllRequestWithId", query="Select r from RequestAddVehicleToDriver r where r.driverId = :id"),
    @NamedQuery(name = "Request.checkRequestExit", query="Select r from RequestAddVehicleToDriver r where r.status = true and r.driverId = :driverId and r.licensePlate = :licensePlate")
})
public class RequestAddVehicleToDriver implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int driverId;
    private String licensePlate;
    private boolean status;

    public RequestAddVehicleToDriver() {
    }

    public RequestAddVehicleToDriver(int driverId, String licensePlate, boolean status) {
        this.driverId = driverId;
        this.licensePlate = licensePlate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
}
