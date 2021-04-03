
import com.mycompany.soapforexam.ExamImpService;
import com.mycompany.soapforexam.ExamInterface;
import com.mycompany.soapforexam.Movies;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
     private static Connection connection;
 private static Statement stat;
    
    public static void main(String[] args) throws SQLException {
           
                List<Movies>  movies = new ArrayList<>();
                
              
                
                try {
                    ExamImpService service = new ExamImpService();
                    ExamInterface port = service.getExamImpPort();
                    
                    String movie = port.getMovieData(1);
                    
                    System.out.println(movie);
                    movies=port.getMovies();
                    System.out.println(movies.get(3).getDirectorName());
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } 
        }
    

