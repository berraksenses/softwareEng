
import java.util.ArrayList;
import java.util.List;
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


@XmlRootElement(name = "flights")
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
    public Response createPassenger(Passenger ps) {
        for (Passenger element : passengers) {
            if (element.getId() == ps.getId()) {
                return Response.status(Response.Status.CONFLICT).build();
            }
        }
        passengers.add(ps);
        return Response.ok(ps).build();
    }

    @DELETE
    @Path("{passengerId}")
    public Response deletePassenger(@PathParam("passengerId") int passengerId) {
        Passenger ps = findById(passengerId);
        if (ps == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        passengers.remove(passengerId);
        return Response.ok().build();
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
    
