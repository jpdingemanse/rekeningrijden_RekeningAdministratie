/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;

import domain.Rate;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import service.RateService;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
@Path("Rate")
public class RateResource {
    @Inject
    RateService rateService;
    
    @POST
    @Path("CreateRate")
    @Consumes("application/json")
    public Rate createNewRate(Rate rate){
        return rateService.createNewRate(rate);
    }
    
    @POST
    @Path("editRate")
    @Consumes("application/json")
    public Rate editRate(Rate rate){
        return rateService.editRate(rate);
    }
    
    @GET
    @Path("getAllRates")
    public List<Rate> getAllRates(){
        return rateService.getAllRates();
    }
}
