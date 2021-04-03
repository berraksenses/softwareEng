import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("airports")
@Produces("text/xml")
public class AirportsRepo {
    private Map<Integer, Airport> airports = new HashMap<>();

    AirportsRepo() {
        Passenger p1 = new Passenger();
        Passenger  p2 = new Passenger();
        p1.setId(1);
        p1.setName("John");
        p2.setId(2);
        p2.setName("Paul");

        Passenger student3 = new Passenger();
        Passenger  student4 = new Passenger();
        p1.setId(1);
        p1.setName("John2");
        p2.setId(2);
        p2.setName("Paul3");

        
        List<Passenger> a1Passengers = new ArrayList<>();
        a1Passengers.add(p1);
        a1Passengers.add(p2);
        
         List<Passenger> a2Passengers = new ArrayList<>();
        a2Passengers.add(student3);
        a2Passengers.add(student4);

        Flights f1 = new Flights();
        Flights f2 = new Flights();
        f1.setId(1);
        f1.setName("AK19");
        f1.setPassengers(a1Passengers);
        f2.setId(2);
        f2.setName("AK10R4");
        f2.setPassengers(a2Passengers);

        
        List<Flights> flights = new ArrayList<>();
        flights.add(f1);
        flights.add(f2);;
        
        Airport a = new Airport();
        Airport a2 = new Airport();
        a.setName("Fiumicino");
        a.setId(1);
        a2.setName("Ciampino");
        a2.setId(2);
        
        
        a.setFlights(flights);
        a2.setFlights(flights);
        

        this.airports.put(1, a);
        this.airports.put(2, a2);
    }

    @GET
    @Path("{airportId}")
    public Airport getAirport(@PathParam("airportId") int airportId) {
        return findById(airportId);
    }
  @Path("{airportId}/flights")
     public Airport pathToFlight(@PathParam("airportId") int airportId) {
        return findById(airportId);
    }
    @PUT
    @Path("{airportId}")
    public Response updateAirport(@PathParam("airportId") int airportId, Airport course) {
        Airport existingCourse = findById(airportId);
        if (existingCourse == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (existingCourse.equals(course)) {
            return Response.notModified().build();
        }
        airports.put(airportId, course);
        return Response.ok().build();
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
