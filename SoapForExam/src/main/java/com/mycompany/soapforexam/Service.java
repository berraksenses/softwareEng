package com.mycompany.soapforexam;


import javax.xml.ws.Endpoint;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author studente
 */
public class Service {

    /**
     * @param args the command line arguments
     */
       public static void main(String[] args) {
        ExamImp implementor = new ExamImp();
        String address = "http://localhost:8080/MovieDatabase";
        Endpoint.publish(address, implementor);
        System.out.println("Server ready...");
    }
    
}
