/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.RequestAddVehicleToDriver;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author lino_
 */
@Stateless
public class RequestDAO {
     @PersistenceContext
     EntityManager em;

    public RequestDAO() {
    }
     
     public RequestAddVehicleToDriver createNewRequest(RequestAddVehicleToDriver request){
         request.setStatus(true);
         em.persist(request);
         em.flush();
         RequestAddVehicleToDriver result = em.find(RequestAddVehicleToDriver.class, request.getId());
         return result;
     }
     
     public boolean checkIfRequestExit(RequestAddVehicleToDriver request){
         Query query = em.createNamedQuery("Request.checkRequestExit")
                         .setParameter("driverId", request.getDriverId())
                         .setParameter("licensePlate", request.getLicensePlate());
         List<RequestAddVehicleToDriver> result = query.getResultList();
         if(result.isEmpty()){
             return true;
         }
         return false;
         
     }
    public List<RequestAddVehicleToDriver> getAllRequestInProgress() {
        Query query = em.createNamedQuery("Request.getRequestInProgress");
        return query.getResultList();
    }

    public boolean updateRequestStatus(int id) {
        try{
            RequestAddVehicleToDriver result = em.find(RequestAddVehicleToDriver.class, id);
            result.setStatus(false);
            em.merge(result);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public List<RequestAddVehicleToDriver> getAllRequestWithId(int id) {
        Query query = em.createNamedQuery("Request.getAllRequestWithId").setParameter("id", id);
        return query.getResultList();
    }
}
