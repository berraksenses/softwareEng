package com.mycompany.soapforexam;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author studente
 */

@XmlType(name = "MoviesList")

public class MoviesList {

    private List<Movies>movieList = new ArrayList();
    
     @XmlElement(name = "entry")
    public List<Movies> getTeachers() {
        return this.movieList;
    }
    public static void main(String[] args) {
        
    }
    
}
