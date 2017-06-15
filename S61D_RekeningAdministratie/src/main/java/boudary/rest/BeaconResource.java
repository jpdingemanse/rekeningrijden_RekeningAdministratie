/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;

import domain.Beacon;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import service.BeaconService;

/**
 *
 * @author Jean Paul
 */
@Stateless
@Path("Beacon")
public class BeaconResource {

    @Inject
    BeaconService beaconService;

    @GET
    @Path("GetBeacons")
    public String getAllBeacons() {
        return beaconService.getAllBeacons("NL12345");
    }

    @GET
    @Path("test")
    public String test() {
        return "dit is een test";
    }

    @POST
    @Consumes("application/json")
    @Path("CreateBeacons")
    public boolean createBeacon(List<Beacon> beacons) {
        return beaconService.createNewBeacon(beacons);
    }
}
