/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;

import domain.Vehicle;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import service.VehicleService;

/**
 *
 * @author lino_
 */
@Stateless
@Path("Vehicle")
public class VehicleResource {
    @Inject
    VehicleService vehicleService;
    
    @POST
    @Path("CreateVehicle")
    @Consumes("application/json")
    public Vehicle createVehicle(Vehicle vehicle){
        return vehicleService.createNewVehicle(vehicle);
    }
}
