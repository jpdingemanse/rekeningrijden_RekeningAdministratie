/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MovementDAO;
import dao.PositionDAO;
import domain.Movement;
import domain.Position;
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
    PositionDAO positionDAO;

    public Movement createNewMovement(Movement movement) {
        List<Position> positions = positionDAO.getAllPositions();
        for (Position p : positions) {
            switch (p.getPosition()) {
                case 1:
                    //Linksboven
                    for (Position position : movement.getPositions()) {
                        
                    }
                    break;
                case 2:
                    //Linksonder

                    break;
                case 3:
                    //Rechtsboven

                    break;
                case 4:
                    //Rechtsonder

                    break;
                default:

                    break;
            }
        }
        return movementDAO.createNewMovement(movement);
    }
}
