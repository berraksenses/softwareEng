package com.mycompany.soapforexam;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author studente
 */
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.List;

public class MovieListAdapter extends XmlAdapter<MoviesList, List<Movies>> {


    public MoviesList marshal(List<Movies> movies) throws Exception {
        MoviesList listMovie = new MoviesList();
        for(Movies movie : movies){
            listMovie.getTeachers().add(movie);
        }
        return listMovie;
    }

    public List<Movies> unmarshal(MoviesList moviesList) throws Exception {
        return moviesList.getTeachers();
    }
}
    

