
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author studente
 */
public class FlightLstnr implements MessageListener{
    
    
    
    
    /**
     * @param args the command line arguments
     */
   
       
       

    @Override
 
        public void onMessage(Message mex) {
        try {
            String landed = mex.getStringProperty("Landed");
            String flightName = mex.getStringProperty("Name");
            System.out.println("Flight name is " + flightName + " status is " + landed);
             Class.forName("org.sqlite.JDBC");
             java.sql.Connection connection =  DriverManager.getConnection("jdbc:sqlite:/home/studente/database");

            Statement st = connection.createStatement();
             
            PreparedStatement z = connection.prepareStatement("INSERT INTO FLIGHTS VALUES (?,?);");
            z.setString(1, flightName);
            z.setString(2, landed);
              z.execute();
            ResultSet rs = st.executeQuery("select * from FLIGHTS;");
            while (rs.next()) {
                System.out.println("Flight name is " + rs.getString("flight") + " status is " + rs.getString("status"));
                
                
            }
            rs.close();
  
        } catch (JMSException err) {
            err.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FlightLstnr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FlightLstnr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    

