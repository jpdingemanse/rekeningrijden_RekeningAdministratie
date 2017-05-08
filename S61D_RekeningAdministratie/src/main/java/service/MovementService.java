/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MovementDAO;
import dao.PositionDAO;
import dao.RateDAO;
import domain.Movement;
import domain.Position;
import domain.Rate;
import domain.Vehicle;
import java.util.ArrayList;
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
    RateDAO rateDAO;

    public Movement createNewMovement(Movement movement) {
        List<Rate> rates = rateDAO.getAllRates();
        boolean linksboven = false;
        boolean linksonder = false;
        boolean rechtsboven = false;
        boolean rechtsonder = false;
        for (Rate r : rates) {
            if (r.getLatLB() > movement.getPositions().get(0).getLat() && r.getLonLB() > movement.getPositions().get(0).getLon()) {
                linksboven = true;
            } else {
                linksboven = false;
                continue;
            }
            if (r.getLatLO() > movement.getPositions().get(0).getLat() && r.getLonLO() < movement.getPositions().get(0).getLon()) {
                linksonder = true;
            } else {
                linksonder = false;
                continue;
            }
            if (r.getLatRB() < movement.getPositions().get(0).getLat() && r.getLonRB() > movement.getPositions().get(0).getLon()) {
                rechtsboven = true;
            } else {
                rechtsboven = false;
                continue;
            }
            if (r.getLatRO() > movement.getPositions().get(0).getLat() && r.getLonRO() < movement.getPositions().get(0).getLon()) {
                rechtsonder = true;
            } else {
                rechtsonder = false;
                continue;
            }
            if (linksboven == true && linksonder == true && rechtsboven == true && rechtsonder == true) {
                movement.setRate(r);
            }
        }
        return movementDAO.createNewMovement(movement);
    }

    public double getMonthprice(Vehicle vehicle, String maand) {
        double totalPrice = 0;
        double distance = 0;
        double rate;
        List<Movement> movements = movementDAO.getAllMovements(vehicle, maand);
        List<Rate> rates = rateDAO.getAllRates();
        for (Movement m : movements) {
            rate = m.getRate().getRate();
            distance = distance(m.getPositions().get(0).getLat(), m.getPositions().get(1).getLat(), m.getPositions().get(0).getLon(), m.getPositions().get(1).getLon());
            totalPrice = distance * rate;
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
        double distance = R * c * 1000; // convert to meters

        return Math.sqrt(distance);
    }
}
