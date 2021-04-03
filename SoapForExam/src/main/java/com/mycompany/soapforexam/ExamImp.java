package com.mycompany.soapforexam;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebService(endpointInterface = "com.mycompany.soapforexam.ExamInterface")
public class ExamImp implements ExamInterface {

 private static Connection connection;
 private static Statement stat;
    private static int id = 0;
    

    public static void main(String[] args) throws Exception {
        
        
 }
    @Override
    public String getMovieData(int movieId) {
        String value="";
     try {
         Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:/home/studente/database");
            
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM MOVIES WHERE ID = ?;");
            statement.setInt(1, movieId);

        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
             System.out.println("Movie id" + rs.getInt("ID") + " is " + "Movie title" + rs.getString("title") + " year is "  + rs.getString("year")  + "Director id" + rs.getInt("directorID"));
             value = "Movie id" + rs.getInt("ID") + " is " + "Movie title" + rs.getString("title") + " year is "  + rs.getString("year")  + "Director id" + rs.getInt("directorID");
             
         }
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(ExamImp.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
         Logger.getLogger(ExamImp.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    
     
     return value;
    }

    @Override
    public List<Movies> getMovies() {
       
      List<Movies> movies = new ArrayList<Movies>();
      int directorId = 0;
      Movies m;
      
       
        
     try {
         Class.forName("org.sqlite.JDBC");
         connection = DriverManager.getConnection("jdbc:sqlite:/home/studente/database");
            
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM MOVIES;");
 
        ResultSet rs = statement.executeQuery();
         while (rs.next()) {
             
             directorId = rs.getInt("directorID");
             System.out.println("Movie id" + rs.getInt("ID") + " is " + "Movie title" + rs.getString("title") + " year is "  + rs.getString("year")  + "Director id" + rs.getInt("directorID")  );
             
             int movieId=rs.getInt("ID");
             String title = rs.getString("title") ;
             
             PreparedStatement statement2 = connection.prepareStatement("SELECT * FROM DIRECTORS WHERE ID = ?;");
              statement2.setInt(1, directorId);
       
             ResultSet rs2 = statement2.executeQuery();
             while (rs2.next()) {
                 System.out.println("Director id" + rs2.getInt("ID") + " is " + "name" + rs2.getString("name") + " year is "  + rs2.getString("yearOfBirth"));
                 
                 m = new Movies(movieId,title, rs.getString("year"),rs2.getString("name"));
                 movies.add(m);
                 System.out.println(movies);

             }
         }
    
     } catch (SQLException ex) {
         Logger.getLogger(ExamImp.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(ExamImp.class.getName()).log(Level.SEVERE, null, ex);
     }
     return movies;
    }
    
}
