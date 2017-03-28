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

/**
 *
 * @author lino_
 */
@Entity
public class invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private double totalPrice;
    private int totalDistant;
    private long timeCreated;

    public invoice() {
    }

    public invoice(double totalPrice, int totalDistant, long timeCreated) {
        this.totalPrice = totalPrice;
        this.totalDistant = totalDistant;
        this.timeCreated = timeCreated;
    }
    
    
    
}
