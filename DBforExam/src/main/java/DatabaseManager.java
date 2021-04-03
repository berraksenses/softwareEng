/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author studente
 */




import java.sql.*;


public class DatabaseManager {

    private static Connection connection;
    private static int id = 0;

    public static void main(String[] args) throws Exception {

        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:" + args[0]);
        Statement stat = connection.createStatement();

        

    
            


            
            ResultSet rs = stat.executeQuery("select * from FLIGHTS;");
            while (rs.next()) {
                System.out.println("Flight name is " + rs.getString("flight") + " status is " + rs.getString("status"));
                
                
            }
            rs.close();
            

        
        connection.close();
    }

}
    

