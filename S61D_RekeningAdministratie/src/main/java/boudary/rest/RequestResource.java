/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;

import domain.RequestAddVehicleToDriver;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import service.RequestService;

/**
 *
 * @author lino_
 */
@Stateless
@Path("Request")
public class RequestResource {
    @Inject
    RequestService requestService;
    
    @POST
    @Path("RequestAddVehicleToDriver")
    @Consumes("application/json")
    public RequestAddVehicleToDriver createRequestAddVehicleToDriver(RequestAddVehicleToDriver request){
        return requestService.createNewRequest(request);
    }
    
    @GET
    @Path("GetRequestInProgress")
    public List<RequestAddVehicleToDriver> getRequestInProgress(){
        return requestService.getAllRequestInProgress();
    }
    
    @GET
    @Path("GetAllRequestWithId/{id}")
    public List<RequestAddVehicleToDriver> getAllRequestWithId(@PathParam("id")int id){
        return requestService.getAllRequestWithId(id);
    }
    
    @POST
    @Path("UpdateRequestStatus")
    @Consumes("application/json")
    public boolean updateRequestStatus(RequestAddVehicleToDriver request){
        return requestService.updateRequestStatus(request.getId());
    }
    
}
