package com.mycompany.airportrestwithdatabase;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


@JacksonXmlRootElement(localName = "flights")
public class Flights {

    private int id;
    private String name;
    private List<Passenger> passengers = new ArrayList<>();
    
   
   
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
    @GET
    @Path("{passengerId}")
    public Passenger getPassenger(@PathParam("passengerId") int passengerId) {
        return findById(passengerId);
    }
    
 

    @POST
    @Path("")
    public void createPassenger(Passenger ps,int flightId) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/studente/database");
            PreparedStatement prep3 = conn.prepareStatement("insert into flights values (?,?,?);");
            
            prep3.setInt(1, flightId);
            prep3.setInt(2, ps.getId());
            prep3.setString(3,ps.getName());
            prep3.addBatch();
            conn.setAutoCommit(false);
            prep3.executeBatch();
            conn.setAutoCommit(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Flights.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Flights.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{passengerId}")
    public void deletePassenger(@PathParam("passengerId") int passengerId) {
        
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/studente/database");
            PreparedStatement prep3 = conn.prepareStatement("delete from passengers where id = ?;");
            prep3.setInt(1,passengerId);
            prep3.executeUpdate();
            
            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Flights.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Flights.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Passenger findById(int id) {
        for (Passenger student : passengers) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
 
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
    
    
    public List<Passenger> getPassengers() {
        
        return this.passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

}
    
