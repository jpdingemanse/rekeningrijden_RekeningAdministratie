/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDAO;
import domain.User;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author lino_
 */
@Stateless
public class UserService {
    @Inject
    UserDAO userDAO;
    
    public User createNewUser(User user){
        return userDAO.createUser(user);
    }
    
    public User getUserByUsernameAndPassword(String username, String password){
        return userDAO.getUserByUsernameAndPassword(username, password);
    }
}
