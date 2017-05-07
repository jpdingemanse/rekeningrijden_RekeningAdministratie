/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;

import domain.Movement;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import service.MovementService;

/**
 *
 * @author victo
 */
@Stateless
@Path("Movement")
public class MovementResource {
    @Inject
    MovementService movementService;
    
    @POST
    @Path("CreateRate")
    @Consumes("application/json")
    public Movement createNewMovement(Movement movement){
        
        return movementService.createNewMovement(movement);
    }
}
