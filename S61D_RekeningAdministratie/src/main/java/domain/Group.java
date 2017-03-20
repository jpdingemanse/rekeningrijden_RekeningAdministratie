/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author lino_
 */
@Entity
public class Group implements Serializable {
    @Id
    private String group;

    public Group() {
    }
    
    
}
