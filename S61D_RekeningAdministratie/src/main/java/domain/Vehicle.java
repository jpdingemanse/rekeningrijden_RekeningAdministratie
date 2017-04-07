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
import javax.persistence.ManyToOne;

/**
 *
 * @author lino_
 */
@Entity
public class Vehicle implements Serializable{
    @Id
    private String licensePlate;
    private List<Movement> movements;
    
    @ManyToOne
    private Driver owner;

    public Vehicle() {
    }

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
        this.movements = new ArrayList<>();
    }

    public List<Movement> getMovements() {
        return movements;
    }

    public void setMovements(List<Movement> movements) {
        this.movements = movements;
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
    
    
}
