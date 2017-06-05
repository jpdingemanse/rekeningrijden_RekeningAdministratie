/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.InvoiceRowDAO;
import dao.MovementDAO;
import dao.RateDAO;
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
    RateDAO rateDAO;
    @Inject
    InvoiceRowDAO invoiceRowDAO;

    public Movement createNewMovement(Movement movement) {
        List<Rate> rates = rateDAO.getAllRates();
        boolean linksboven = false;
        boolean linksonder = false;
        boolean rechtsboven = false;
        boolean rechtsonder = false;
        for (Rate r : rates) {
            if (r.getLatLB() > movement.getStartPoint().getLatitude() && r.getLonLB() > movement.getStartPoint().getLongitude()) {
                linksboven = true;
            } else {
                linksboven = false;
                continue;
            }
            if (r.getLatLO() > movement.getStartPoint().getLatitude() && r.getLonLO() < movement.getStartPoint().getLongitude()) {
                linksonder = true;
            } else {
                linksonder = false;
                continue;
            }
            if (r.getLatRB() < movement.getStartPoint().getLatitude() && r.getLonRB() > movement.getStartPoint().getLongitude()) {
                rechtsboven = true;
            } else {
                rechtsboven = false;
                continue;
            }
            if (r.getLatRO() < movement.getStartPoint().getLatitude() && r.getLonRO() < movement.getStartPoint().getLongitude()) {
                rechtsonder = true;
            } else {
                rechtsonder = false;
                continue;
            }
            if (linksboven == true && linksonder == true && rechtsboven == true && rechtsonder == true) {
                movement.setRate(r);
                break;
            }
        }
        return movementDAO.createNewMovement(movement);
    }

    public double getMonthprice(Vehicle vehicle, String maand) {
        double totalPrice = 0;
        double distance;
        double rate;
        List<Movement> movements = movementDAO.getAllMovements(vehicle, "Mei 2017");
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
        double distance = R * c * 1000; // convert to meters

        return Math.sqrt(distance);
    }
}
