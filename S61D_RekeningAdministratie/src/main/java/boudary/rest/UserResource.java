/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boudary.rest;

import domain.User;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import service.UserService;

/**
 *
 * @author lino_
 */
@Stateless
@Path("User")
public class UserResource {

    @Inject
    UserService userService;

    @POST
    @Path("CreateUser")
    @Consumes("application/json")
    public User createUser(User user) {
        return userService.createNewUser(user);
    }
    
    @GET
    @Path("GetUserByUsernameAndPassword/{username}/{password}")
    public User getUserByUsernameAndPassword(@PathParam("username")String username, @PathParam("password")String password)
    {
        return userService.getUserByUsernameAndPassword(username, password);
    }

}
