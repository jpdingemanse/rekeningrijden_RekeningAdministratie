/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;


import com.google.gson.Gson;
import domain.Vehicle;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author lino_
 */
@Stateless
public class VehicleTransmitter {
    
    public boolean SendVehicleToRekeningRijder(Vehicle vehicle) {
        Gson gson = new Gson();
        String jsonToString = gson.toJson(vehicle);
        System.out.println(jsonToString);
        try {
            String url = "http://192.168.24.43:8080/S61D_Rekeneningrijden/api/Vehicle/CreateVehicle";
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost(url);

            StringEntity input = new StringEntity(jsonToString);
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);
            int httpCode = response.getStatusLine().getStatusCode();

            if (httpCode != 200) {
                return false;
            }
            return true;
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(VehicleTransmitter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(VehicleTransmitter.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }
    public boolean SendAddVehicleToDriverRekeningRijder(Vehicle vehicle){
        Gson gson = new Gson();
        String jsonToString = gson.toJson(vehicle);
        System.out.println(jsonToString);
        try {
            String url = "http://192.168.24.43:8080/S61D_Rekeneningrijden/api/Vehicle/AddVehicleToDriver";
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost(url);

            StringEntity input = new StringEntity(jsonToString);
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);
            int httpCode = response.getStatusLine().getStatusCode();

            if (httpCode != 200) {
                return false;
            }
            return true;
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(VehicleTransmitter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(VehicleTransmitter.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }
    public boolean SendUpdateICanToRekeningrijder(Vehicle vehicle){
        Gson gson = new Gson();
        String jsonToString = gson.toJson(vehicle);
        try {
            String url = "http://192.168.24.43:8080/S61D_Rekeneningrijden/api/Vehicle/UpdateICan";
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost(url);

            StringEntity input = new StringEntity(jsonToString);
            input.setContentType("application/json");
            postRequest.setEntity(input);

            HttpResponse response = httpClient.execute(postRequest);
            int httpCode = response.getStatusLine().getStatusCode();

            if (httpCode != 200) {
                return false;
            }
            return true;
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(VehicleTransmitter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(VehicleTransmitter.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }
}