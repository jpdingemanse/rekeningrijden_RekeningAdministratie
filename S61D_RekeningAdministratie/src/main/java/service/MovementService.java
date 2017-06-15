/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.BeaconDAO;
import dao.InvoiceRowDAO;
import dao.MovementDAO;
import dao.RateDAO;
import domain.Beacon;
import domain.Movement;
import domain.Rate;
import domain.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author victo
 */
@Stateless
public class MovementService {

    @Inject
    MovementDAO movementDAO;
    
    @Inject
    BeaconDAO beaconDAO;

    public Movement createNewMovement(Movement movement, List<Rate> rates) {
        boolean linksboven = false;
        boolean linksonder = false;
        boolean rechtsboven = false;
        boolean rechtsonder = false;
        
        
        double mStartLat = movement.getStartPoint().getLatitude();
        double mStartLon = movement.getStartPoint().getLongitude();
        
        for (Rate r : rates) {
            double rlatLB = r.getLatLB();
            double rlonLB = r.getLonLB();
            double rlatLO = r.getLatLO();
            double rlonLO = r.getLonLO();
            double rlatRB = r.getLatRB();
            double rlonRB = r.getLonRB();
            double rlatRO = r.getLatRO();
            double rlonRO = r.getLonRO();
            if(rlatLB > mStartLat &&  rlonLB < mStartLon){
                linksboven = true;
            }
            if(rlatLO < mStartLat && rlonLO < mStartLon){
                linksonder = true;
            }
            if(rlatRB > mStartLat && rlonRB > mStartLon){
                rechtsboven = true;
            }
            if(rlatRO < mStartLat && rlonRO > mStartLon){
                rechtsonder = true;
            }
            if (linksboven == true && linksonder == true && rechtsboven == true && rechtsonder == true) {
                movement.setRate(r);
                break;
            }
        }
        Beacon startBeacon = beaconDAO.createNewBeacon(movement.getStartPoint());
        Beacon endBeacon = beaconDAO.createNewBeacon(movement.getEndPoint());
        movement.setStartPoint(startBeacon);
        movement.setEndPoint(endBeacon);
        return movementDAO.createNewMovement(movement);
    }

    public double getMonthprice(List<Movement> movements) {
        double totalPrice = 0;
        double distance;
        double rate;
        for (Movement m : movements) {
            rate = m.getRate().getRate();
            distance = distance(m.getStartPoint().getLatitude(), m.getEndPoint().getLatitude(), m.getStartPoint().getLongitude(), m.getEndPoint().getLongitude());
            totalPrice += distance * rate;
        }
        return totalPrice;
    }
    
    private double distance(double lat1, double lat2, double lon1,
            double lon2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c; // convert to meters

        return Math.sqrt(distance);
    }
}
