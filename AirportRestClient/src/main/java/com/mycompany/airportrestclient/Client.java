package com.mycompany.airportrestclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.xml.bind.JAXB;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Client {
    private static final String BASE_URL = "http://localhost:8080/airports";
    private static CloseableHttpClient client;

    public static void main(String[] args) throws IOException {
        client = HttpClients.createDefault();

        //GET requests
        System.out.println("GET course with id 1...");
        Airport a1 = getAirport(1);
       
       
        for (int i = 0; i < a1.getFlights().size(); i++)
            System.out.println(a1.getFlights().get(i));

        //POST request
        System.out.println("GET course with id 2...");
        Airport a2 = getAirport(2);
       
        createValidPassenger(1,1);

        if (a2.getFlights() != null) {
            for (int i = 0; i < a2.getFlights().size(); i++)
                System.out.println(a2.getFlights().get(i));
        }

        client.close();
    }

    private static Airport getAirport(int airportID) throws IOException {
        System.out.println(String.format("GET course with id %d...", airportID));
        URL url = new URL(String.format("%s/%d", BASE_URL, airportID));
        InputStream input = url.openStream();
        return JAXB.unmarshal(new InputStreamReader(input), Airport.class);
    }

    private static Flights getFlight(int airportID, int flightID) throws IOException {
        System.out.println(String.format("GET student %d for course %d...", flightID, airportID));
        URL url = new URL(BASE_URL+ airportID + "/flights/" + flightID);
        InputStream input = url.openStream();
        return JAXB.unmarshal(new InputStreamReader(input), Flights.class);
    }
    
     private static Passenger getPassenger(int airportID, int flightID, int passengerId) throws IOException {
        final URL url = new URL(BASE_URL+ airportID + "/flights/" + flightID  + "/passengers/" + passengerId);
        final InputStream input = url.openStream();
        return JAXB.unmarshal(new InputStreamReader(input), Passenger.class);
    }
    

    private static void createValidPassenger(int airportId,int flightId) throws IOException {
        System.out.println(String.format("POST student for course %d...", flightId));
        HttpPost httpPost = new HttpPost(BASE_URL + "/" + airportId + "/flights/"+ flightId + "/passengers");
        final InputStream resourceStream = Client.class.getClassLoader().getResourceAsStream("./NewPassenger.xml");
        
       
        httpPost.setEntity(new InputStreamEntity(resourceStream));
        httpPost.setHeader("Content-Type", "text/xml");

        final HttpResponse response = client.execute(httpPost);
        System.out.println(BASE_URL + "/"  + airportId + "/flights/"+ flightId + "/passengers");
        System.out.println(response);
    }

}