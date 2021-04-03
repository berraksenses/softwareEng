

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author studente
 */

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "airport")
public class Airport {

    private int id;
    private String name;
    private List<Flights> flights = new ArrayList<>();
   
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    @GET
    @Path("{flightId}")
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
    public Response createFlight(Flights flight) {
        for (Flights element : flights) {
            if (element.getId() == flight.getId()) {
                return Response.status(Response.Status.CONFLICT).build();
            }
        }
        flights.add(flight);
        return Response.ok(flight).build();
    }

    @DELETE
    @Path("{flightId}")
    public Response deleteFlight(@PathParam("flightId") int flightId) {
        Flights flight = findById(flightId);
        if (flight == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        flights.remove(flight);
        return Response.ok().build();
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

    public List<Flights> getFlights() {
        return this.flights;
    }

    public void setFlights(List<Flights> students) {
        this.flights = students;
    }
}



