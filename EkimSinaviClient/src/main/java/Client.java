
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.bind.JAXB;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author studente
 */
public class Client {

     private static final String BASE_URL = "http://localhost:8080/books";
    private static CloseableHttpClient client;

    public static void main(String[] args) throws IOException {
       client = HttpClients.createDefault();
        for (int i = 1; i <11; i++)
            System.out.println(getBook(i).getTitle());
        
        try { // Call Web Service Operation
            com.mycompany.ekimsinavibookws.WareHouseWSService service = new com.mycompany.ekimsinavibookws.WareHouseWSService();
            com.mycompany.ekimsinavibookws.WarehouseInterface port = service.getWareHouseWSPort();
            // TODO initialize WS operation arguments here
            int arg0 = 0;
            int arg1 = 0;
            // TODO process result here
            java.lang.String result = port.deliveryTime(1, 1);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

    }
    
    
     private static Book getBook(int bookID) throws MalformedURLException, IOException{
        System.out.println(String.format("GET course with id %d...", bookID));
        URL url = new URL(BASE_URL+ "/"+bookID);
        System.out.println(url);
        InputStream input = url.openStream();
        return JAXB.unmarshal(new InputStreamReader(input), Book.class);
    }
    
}
