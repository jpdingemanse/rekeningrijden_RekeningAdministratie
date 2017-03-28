/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.TrackerDAO;
import domain.Tracker;
import javax.inject.Inject;

/**
 *
 * @author victo
 */
public class TrackerService {
    @Inject
    TrackerDAO trackerDAO;
    
    public Tracker createNewTracker(Tracker tracker){
        return trackerDAO.createNewTracker(tracker);
    }
}
