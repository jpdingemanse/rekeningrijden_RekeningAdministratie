/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import com.google.gson.Gson;
import domain.Beacon;
import domain.Vehicle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import static javax.ws.rs.core.HttpHeaders.USER_AGENT;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author lino_
 */
@Stateless
public class BeaconTransmitter {

    public List<Beacon> GetAllMovementsPerVehicle(String ican) throws JSONException {
        StringBuilder result = new StringBuilder();
        Beacon tempBeacon = null;
        List<Beacon> beacons = new ArrayList<>();

        try {
            String url = "http://192.168.24.42:8080/S61D_VerplaatsingSysteem/api/Beacon/getMovementPerMonth/" + ican;
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(url);

            // add request header
            request.addHeader("User-Agent", USER_AGENT);

            HttpResponse response = client.execute(request);
            int responceCode = response.getStatusLine().getStatusCode();
            if (responceCode == 200) {
                BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

                Gson gson = new Gson();
                String line = "";
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }
                System.out.println(result + "  test");
                if (!result.toString().isEmpty()) {
                    JSONArray json = new JSONArray(result.toString());
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject temp = json.getJSONObject(i);
                        String tempican = temp.getString("ICAN");
                        Double templat = temp.getDouble("latitude");
                        Double templon = temp.getDouble("longitude");
                        Long tempdatetime = temp.getLong("dateTime");
                        tempBeacon = new Beacon(tempican, templat, templon, tempdatetime);
                        beacons.add(tempBeacon);
                    }
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Vehicle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(VehicleTransmitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return beacons;
    }
}
