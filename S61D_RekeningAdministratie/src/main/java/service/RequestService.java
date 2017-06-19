/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.RequestDAO;
import domain.RequestAddVehicleToDriver;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author lino_
 */
@Stateless
public class RequestService {
    @Inject
    RequestDAO requestDAO;
            
    public RequestAddVehicleToDriver createNewRequest(RequestAddVehicleToDriver request) {
        if(requestDAO.checkIfRequestExit(request)){
            return requestDAO.createNewRequest(request);
        }
        return null;
    }
    
    public List<RequestAddVehicleToDriver> getAllRequestInProgress(){
        return requestDAO.getAllRequestInProgress();
    }
    
    public boolean updateRequestStatus(int id){
        return requestDAO.updateRequestStatus(id);
                
    }

    public List<RequestAddVehicleToDriver> getAllRequestWithId(int id) {
        return requestDAO.getAllRequestWithId(id);
    }
}
