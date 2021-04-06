package com.mycompany.airportrestwithdatabase;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author studente
 */

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@JacksonXmlRootElement(localName = "airport")
public class Airport {

    private int id;
    private String name;
    private List<Flights> flights = new ArrayList<>();
    Connection conn = null;
   
    
    public Airport(int id,String name){
        this.id=id;
        this.name=name;
       
        
    }
    Airport() {
        
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/studente/database");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AirportsRepo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AirportsRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    @GET
    @Path("{flightId}")
     @Produces("application/json")
    public Flights getFlight(@PathParam("flightId") int flightId) {
        return findById(flightId);
    }
        private Flights findById(int id) {
        for (Flights flight : flights) {
            if (flight.getId() == id) {
                return flight;
            }
        }
        return null;
    }
             
    @Path("{flightId}/passengers")
     public Flights pathToPassengers(@PathParam("flightId") int flightId) {
        return findById(flightId);
    }
        
  
    @POST
    @Path("")
    public void createFlight(Flights flight, int airportId) {
        try {
            PreparedStatement prep3 = conn.prepareStatement("insert into flights values (?,?,?);");
            
            prep3.setInt(1, airportId);
            prep3.setInt(2, flight.getId());
            prep3.setString(3,flight.getName());
            prep3.addBatch();
            conn.setAutoCommit(false);
            prep3.executeBatch();
            conn.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(Airport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{flightId}")
    public void deleteFlight(@PathParam("flightId") int flightId) {
       
        try {
            PreparedStatement prep3 = conn.prepareStatement("delete from flights where id = ?;");
            prep3.setInt(1,flightId);
            prep3.executeUpdate();
              
        
    }   catch (SQLException ex) {
            Logger.getLogger(Airport.class.getName()).log(Level.SEVERE, null, ex);
        }}

    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flights> getFlights() {
        return this.flights;
    }

    public void setFlights(List<Flights> flights) {
        this.flights = flights;
    }
}



