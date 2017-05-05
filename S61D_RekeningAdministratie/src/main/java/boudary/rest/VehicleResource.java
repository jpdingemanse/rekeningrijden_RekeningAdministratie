/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;


import domain.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
    
    @POST
    @Path("AddTrackerToVehicle")
    @Consumes("application/json")
    public Vehicle addTrackerToVehicle(Vehicle vehicle){
        return vehicleService.addTrackerToVehicle(vehicle);
    }
    
    @POST
    @Path("AddVehicleToDriver")
    @Consumes("application/json")
    public Vehicle addVehicleToDriver(Vehicle vehicle){
        return vehicleService.addVehicleToDriver(vehicle);
    }
    
    @POST
    @Path("UpdateAuthorisatieCode")
    @Consumes("application/json")
    public Vehicle updateAuthorisatieCode(Vehicle vehicle){
        return vehicleService.updateAutorisatieCode(vehicle);
    }
    
    @POST
    @Path("UpdateTracker")
    @Consumes("application/json")
    public Vehicle updateTracker(Vehicle vehicle){
        return vehicleService.updateTracker(vehicle);
    }
    
    @GET
    @Path("GetAllVehicle/{id}")
    public List<Vehicle> getVehicleById(@PathParam("id")int id){
        return vehicleService.getVehicleByOwner(id);
    }
    
    @GET
    @Path("GetAllVehicles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vehicle> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }
    
    @GET
    @Path("GetVehicleByLicensePlate/{licensePlate}")
    public Vehicle getVehicleByLicensePlate(@PathParam("licensePlate")String licensePlate){
        return vehicleService.getVehicleByLicensePlate(licensePlate);
    }

    @GET
    @Path("GetAllVehicle")
    public List<Vehicle> getAllVehicle(){
        return vehicleService.getAllVehicles();
    }
    
    
}
