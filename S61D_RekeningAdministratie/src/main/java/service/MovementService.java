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
            if(r.getLatLB() > movement.getPositions().get(0).getLat() && r.getLonLB() > movement.getPositions().get(0).getLon()){
                linksboven = true;
            } else{
                linksboven = false;
                continue;
            }
            if(r.getLatLO() > movement.getPositions().get(0).getLat() && r.getLonLO() < movement.getPositions().get(0).getLon()){
                linksonder = true;
            } else{
                linksonder = false;
                continue;
            }
            if(r.getLatRB() < movement.getPositions().get(0).getLat() && r.getLonRB() > movement.getPositions().get(0).getLon()){
                rechtsboven = true;
            } else{
                rechtsboven = false;
                continue;
            }
            if(r.getLatRO() > movement.getPositions().get(0).getLat() && r.getLonRO() < movement.getPositions().get(0).getLon()){
                rechtsonder = true;
            } else{
                rechtsonder = false;
                continue;
            }
            if(linksboven == true && linksonder == true && rechtsboven == true && rechtsonder == true){
                movement.setRate(r);
            }
        }
        return movementDAO.createNewMovement(movement);
    }
}
