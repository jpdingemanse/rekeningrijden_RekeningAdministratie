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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author lino_
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Driver.getDriverByName", query="Select d from Driver d where d.name = :name and d.lastname = :lastname"),
    @NamedQuery(name = "Driver.getDrivers", query="Select d from Driver d")
})
public class Driver implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String lastname;
    private String postalCode;
    private String city;
    private String email;
    private String username;
    private String password;
    private String houseNumber;
    private String phoneNumber;
    
    @OneToMany(mappedBy = "owner")
    private List<Vehicle> allVehicle;
    
    @OneToMany(mappedBy = "driver")
    private List<Invoice> invoice;

    public Driver() {
    }

    public Driver(String name,String lastname, String postalCode, String city, String email, String username, String password, String houseNumber, String phoneNumber) {
        this.name = name;
        this.lastname = lastname;
        this.postalCode = postalCode;
        this.city = city;
        this.email = email;
        this.username = username;
        this.password = password;
        this.houseNumber = houseNumber;
        this.phoneNumber = phoneNumber;
        this.invoice = new ArrayList<>();
        this.allVehicle = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Vehicle> getAllVehicle() {
        return allVehicle;
    }

    public void setAllVehicle(List<Vehicle> allVehicle) {
        this.allVehicle = allVehicle;
    }

    public List<Invoice> getInvoice() {
        return invoice;
    }

    public void setInvoice(List<Invoice> invoice) {
        this.invoice = invoice;
    }
    
    
    
    
}
