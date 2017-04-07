/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;

import domain.Position;
import domain.Rate;
import static domain.Rate_.border;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
    public Rate createNewRate(){
        List<Position> pos = new ArrayList<>();
        Position position = new Position("links", 5.22222, 6.2122121);
        pos.add(position);
        Rate rate1 = new Rate(2.33, "brabant", pos);
        return rateService.createNewRate(rate1);
    }
}
