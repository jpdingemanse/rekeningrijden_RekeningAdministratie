/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.BeaconDAO;
import dao.MovementDAO;
import dao.VehicleDAO;
import domain.Beacon;
import domain.Movement;
import domain.Vehicle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import static javax.ws.rs.core.HttpHeaders.USER_AGENT;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author Jean Paul
 */
@Stateless
public class BeaconService {

    @Inject
    BeaconDAO beaconDAO;
    @Inject
    MovementDAO movementDAO;
    @Inject
    VehicleDAO vehicleDAO;

    public String getAllBeacons(String ican) {
        StringBuilder result = new StringBuilder();
        try {
            String url = "http://192.168.24.42:8080/S61D_VerplaatsingSysteem/api/Beacon/GetMovementPerIcan/" + ican;
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(url);

            // add request header
            request.addHeader("User-Agent", USER_AGENT);

            HttpResponse response = client.execute(request);

            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            System.out.println(result.toString());
        } catch (IOException ex) {
            Logger.getLogger(BeaconService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result.toString();
    }

    public boolean createNewBeacon(List<Beacon> beacons) {
        int size = beacons.size()- 1;
        Movement movement;
        Vehicle vehicle = vehicleDAO.getVehicleByIcan(beacons.get(0).getiCan()).get(0);
        Beacon bs = new Beacon();
        Calendar c = Calendar.getInstance();
        String month = new SimpleDateFormat("MMMM").format(c.getTime());
        int year = c.get(Calendar.YEAR);
        for (Beacon b : beacons) {
            beaconDAO.createNewBeacon(b);
            if(b.getId() == beacons.get(0).getId() || b.getId() == beacons.get(size).getId()){
                movement = new Movement(String.valueOf(month + " " + year), b.getiCan(), bs, b, vehicle);
            }
            bs = b;
            }
        return true;
    }
    public Beacon createBeacon(Beacon beacon){
        return beaconDAO.createNewBeacon(beacon);
    }
    public List<Beacon> getBeaconsById(int id) {
        return beaconDAO.getBeaconsById(id);
    }
}
