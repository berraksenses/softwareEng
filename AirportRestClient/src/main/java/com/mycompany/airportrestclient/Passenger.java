package com.mycompany.airportrestclient;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author studente
 */

@XmlRootElement(name = "passengers")
public class Passenger {
    
 private int id;
    private String name;

    public static void main(String[] args) {
        // TODO code application logic here
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

}
    

