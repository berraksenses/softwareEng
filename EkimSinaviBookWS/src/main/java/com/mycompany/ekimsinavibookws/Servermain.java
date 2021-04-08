package com.mycompany.ekimsinavibookws;


import com.mycompany.ekimsinavibookws.WareHouseWS;
import javax.xml.ws.Endpoint;

public class Servermain {
    public static void main(String[] args) {
        WareHouseWS implementor = new WareHouseWS();
        String address = "http://localhost:8081/SoapInterface";
        Endpoint.publish(address, implementor);
        while (true) { }
    }
}