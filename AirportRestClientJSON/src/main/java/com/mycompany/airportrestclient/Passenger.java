package com.mycompany.airportrestclient;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@JacksonXmlRootElement(localName = "passengers")
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
    
 @Override
    public String toString() {
        return "fpassenger " + id + " " + name;
    }

}
    

