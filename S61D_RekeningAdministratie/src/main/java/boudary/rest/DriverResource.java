/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;

import dao.DriverDAO;
import domain.Driver;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import service.DriverService;

/**
 *
 * @author lino_
 */
@Stateless
@Path("Driver")
public class DriverResource {
    @Inject
    DriverService driverService;
    
    @POST
    @Path("CreateDriver")
    @Consumes("application/json")
    public Driver createNewDriver(Driver driver){
        return driverService.createNewDriver(driver);
    }
    
    @POST
    @Path("AddVehicleToDriver")
    @Consumes("application/json")
    public Driver addVehicleToDriver(Driver driver){
        return driverService.addVehicleToDriver(driver);
    }
    
    
    
    
}
