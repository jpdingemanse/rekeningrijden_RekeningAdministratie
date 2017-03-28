/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;

import domain.Tracker;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import service.TrackerService;

/**
 *
 * @author victo
 */
@Stateless
@Path("Tracker")
public class TrackerResource {
    @Inject
    TrackerService trackerService;
    
    @POST
    @Path("CreateTracker")
    @Consumes("application/json")
    public Tracker createTracker(Tracker tracker){
        return trackerService.createNewTracker(tracker);
    }
}
