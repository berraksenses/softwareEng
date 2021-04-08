package com.mycompany.ekimsinavibookws;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
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
@WebService(endpointInterface = "com.mycompany.ekimsinavibookws.WarehouseInterface")
public class WareHouseWS implements WarehouseInterface {
     
    private Map<Integer, WareHouse> warehouse = new LinkedHashMap<Integer, WareHouse>();
       private static final String BASE_URL = "http://localhost:8080/books";
    private static CloseableHttpClient client;

    
    public WareHouseWS(){
         client = HttpClients.createDefault();

        
        Seller s1 = new Seller();
        s1.setName("Seller1");
        s1.setDeliveryDate("Date1");
        
         Seller s2 = new Seller();
        
        s2.setName("Seller2");
        s2.setDeliveryDate("Date2");
        
          Seller s3 = new Seller();
        
        s3.setName("Seller3");
        s3.setDeliveryDate("Date3");
        
          Seller s4 = new Seller();
        
        s4.setName("Seller4");
        s4.setDeliveryDate("Date4");
        
          Seller s5 = new Seller();
        
        s2.setName("Seller5");
        s2.setDeliveryDate("Date5");
        
          Seller s6 = new Seller();
        
        s2.setName("Seller6");
        s2.setDeliveryDate("Date6");
        
        List<Seller> seller = new ArrayList();
        seller.add(s1);
         seller.add(s2);
        
        WareHouse w1 = new WareHouse();
        w1.setBookId(1);
        w1.setPrice((float) 129.9);
        w1.setSellers(seller);
        
         List<Seller> seller2 = new ArrayList();
        seller2.add(s3);
         seller2.add(s4);
         
         
        WareHouse w2 = new WareHouse();
        w2.setBookId(2);
        w2.setPrice((float) 12.9);
        w2.setSellers(seller2);
        
        
        WareHouse w3 = new WareHouse();
        w3.setBookId(3);
        w3.setPrice((float) 99.9);
        w3.setSellers(seller);
        
        
        WareHouse w4 = new WareHouse();
        w4.setBookId(4);
        w4.setPrice((float) 17.9);
        w4.setSellers(seller2);
        
        WareHouse w5 = new WareHouse();
        w5.setBookId(5);
        w5.setPrice((float) 7.9);
        w5.setSellers(seller);
        
        WareHouse w6 = new WareHouse();
        w6.setBookId(6);
        w6.setPrice((float) 17.1);
        w6.setSellers(seller2);
        
        WareHouse w7 = new WareHouse();
        w7.setBookId(7);
        w7.setPrice((float) 1.9);
        w7.setSellers(seller);
        
        WareHouse w8 = new WareHouse();
        w8.setBookId(8);
        w8.setPrice((float) .9);
        w8.setSellers(seller2);
        
        WareHouse w9 = new WareHouse();
        w9.setBookId(9);
        w9.setPrice((float) 9);
        w9.setSellers(seller);
        
        WareHouse w10 = new WareHouse();
        w10.setBookId(10);
        w10.setPrice((float) 1.1);
        w10.setSellers(seller2);
        
        warehouse.put(1, w1);
        warehouse.put(2, w2);
        warehouse.put(3, w3);
        warehouse.put(4, w4);
        warehouse.put(5, w5);
        warehouse.put(6, w6);
        warehouse.put(7, w7);
        warehouse.put(8, w8);
        warehouse.put(9, w9);
        warehouse.put(10, w10);
        
        
        
    }
    

    @Override
    public String getInfoAboutBook(int i) {
        String stat = null;
        try {
            Book b = getBook(i);
            stat = stat + "GET author name " +b.getAuthor() + "GET author date " + b.getAuthorBirth() + "GET title " + b.getTitle() + "price is " + warehouse.get(i).getPrice();
                    } catch (IOException ex) {
            Logger.getLogger(WareHouseWS.class.getName()).log(Level.SEVERE, null, ex);
        }
            return stat;
    }
    
     private static Book getBook(int bookID) throws MalformedURLException, IOException{
        System.out.println(String.format("GET course with id %d...", bookID));
        URL url = new URL(String.format("%s/%d", BASE_URL, bookID));
        InputStream input = url.openStream();
        return JAXB.unmarshal(new InputStreamReader(input), Book.class);
    }


    @Override
    public String deliveryTime(int book,int s) {
        
       return ("The delivery time is: " + warehouse.get(book).getSellers().get(s).getDeliveryDate());
       
    }

 
}



