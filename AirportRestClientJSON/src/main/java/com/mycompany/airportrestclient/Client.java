package com.mycompany.airportrestclient;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import javax.ws.rs.core.Response;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

public class Client {
    private static final String BASE_URL = "http://localhost:8085/airports/";
    private static CloseableHttpClient client;

    public static void main(String[] args) throws IOException {
        
        
       
  client = HttpClients.createDefault();

        // Example GET
        
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL(BASE_URL + "2");
        
        InputStream input = url.openStream();
        
        Airport fl = (Airport)mapper.readValue(input, Airport.class);        
        System.out.println(fl);
        

        // Example POST/PUT
        
        
        ObjectMapper objectMapper = new ObjectMapper();
        Airport newFl = new Airport();
        
        newFl.setId(4);
        newFl.setName("XX000");
        
        String json = objectMapper.writeValueAsString(newFl); 
        
        HttpPut httpPut = new HttpPut(BASE_URL + "2/");
        
        StringEntity entity = new StringEntity(json);
        httpPut.setEntity(entity);
        httpPut.setHeader("Accept", "application/json");
        httpPut.setHeader("Content-type", "application/json");
        HttpResponse response = client.execute(httpPut);
        System.out.println(response);
        
        InputStream input2 = url.openStream();
        fl = (Airport) mapper.readValue(input2, Airport.class);
        System.out.println(fl);
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
    

    private static HttpResponse updateAirport(int airportId,Airport p) throws IOException {
        System.out.println(String.format("POST student for course %d...", airportId));
        HttpPost httpPost = new HttpPost(BASE_URL + "/" +  airportId );
        
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(p);

        HttpPut httpPut = new HttpPut(BASE_URL+ "/" + p.getId());
        StringEntity entity = new StringEntity(json);
        httpPut.setEntity(entity);
        httpPut.setHeader("Accept", "application/json");
        httpPut.setHeader("Content-type", "application/json");
       
        
       
     
       
        final HttpResponse response = client.execute(httpPut);
      
        return response;
    }

}