/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author ruthgervandeneikhof
 */
@Entity
public class History implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    Driver bestuurder;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date overschrijfDatum;
    
    public History(){}
    
    public History(Driver bestuurder, Date overschrijfDatum){
        this.bestuurder = bestuurder;
        this.overschrijfDatum = overschrijfDatum;
    }

    public int getId() {
        return id;
    }
    
    public Driver getBestuurder() {
        return bestuurder;
    }

    public void setBestuurder(Driver bestuurder) {
        this.bestuurder = bestuurder;
    }

    public Date getOverschrijfDatum() {
        return overschrijfDatum;
    }

    public void setOverschrijfDatum(Date overschrijfDatum) {
        this.overschrijfDatum = overschrijfDatum;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
}
