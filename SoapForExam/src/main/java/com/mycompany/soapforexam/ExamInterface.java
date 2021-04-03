package com.mycompany.soapforexam;


import java.util.List;
import javax.jws.WebService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author studente
 */
@WebService
public interface ExamInterface {
    
    String getMovieData(int movieId);

    List<Movies> getMovies();
          
    
    
}
