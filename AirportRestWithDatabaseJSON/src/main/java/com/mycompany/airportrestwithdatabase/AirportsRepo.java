package com.mycompany.airportrestwithdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("airports")
public class AirportsRepo {
    private Map<Integer, Airport> airports = new HashMap<>();
    Connection conn=null;

    AirportsRepo() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:/home/studente/database");
            Statement stat = conn.createStatement();
            
            
            
            
            ResultSet rs = stat.executeQuery("select * from airports;");
           
        
            while(rs.next()) {
               List<Flights> f=new ArrayList();
                Airport a = new Airport();
                a.setId(rs.getInt("id"));
                a.setName(rs.getString("name"));
                 PreparedStatement prep = conn.prepareStatement("select * from flights where airportId = ?;"); 
                
                
                prep.setInt(1, a.getId()); // flight name
                ResultSet rs2 = prep.executeQuery();
                while(rs2.next()) {
                    Flights n = new Flights();
                    n.setId((rs2.getInt("id")));
                    System.out.println(n.getId());
                     n.setName(rs2.getString("name"));
                     f.add(n);
                     
                     PreparedStatement prep2 = conn.prepareStatement("select * from passengers where flightId = ?;"); 
                List<Passenger> p =new ArrayList();
                
                prep2.setInt(1, n.getId()); // flight name
                ResultSet rs3 = prep2.executeQuery();
                while(rs3.next()) {
                    Passenger p1 = new Passenger();
                    p1.setName(rs3.getString("name"));
                    p1.setId((rs3.getInt("id")));
                    p.add(p1);
                    n.setPassengers(p);
                    System.out.println(p1.getName());
                }
                
                }
                
                a.setFlights(f);
                airports.put(a.getId(), a);
                
            }
            
            
    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AirportsRepo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AirportsRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{airportId}")
     @Produces("application/json")
    public Airport getAirport(@PathParam("airportId") int airportId) {
        return findById(airportId);
    }
  @Path("{airportId}/flights")
     public Airport pathToFlight(@PathParam("airportId") int airportId) {
        return findById(airportId);
    }
    @PUT
    @Path("{airportId}")
    @Consumes("application/json")
    public Response updateFligth(@PathParam("airportId") int airportId, Airport airport) {
        Airport existing = findById(airportId);
        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (existing.equals(airport)) {
            return Response.notModified().build();
        }
        // fligths.put(fligthId, fligth);
        update(airportId, airport);
        return Response.ok().build();
    }

    private void update(int fligthId, Airport fligth)
    {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement("update airports set name = ? where id = ?");
            stat.setString(1, fligth.getName());
            stat.setInt(2, (fligthId));
        
        int affectedRow = stat.executeUpdate();
        if (affectedRow == 1) {
            Logger.getLogger(AirportsRepo.class.getName()).log(Level.INFO, "Updated : " + fligth);
            return;
        }    
        else throw new RuntimeException();
        }
        catch (Exception ex) {
            Logger.getLogger(AirportsRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 

    private Airport findById(int id) {
        for (Map.Entry<Integer, Airport> course : airports.entrySet()) {
            if (course.getKey() == id) {
                return course.getValue();
            }
        }
        return null;
    }
}
