import java.sql.*;



public class DatabaseManager { // remember to run with arguments home/studente/database create for creating the db

    public static void main(String[] args) throws Exception {

        Class.forName("org.sqlite.JDBC");
        Connection conn
                = DriverManager.getConnection("jdbc:sqlite:"+args[0]);
        Statement stat = conn.createStatement();

        if (args[1].equals("create")) {
            stat.executeUpdate("drop table if exists movies;"); // clear the db
            stat.executeUpdate("create table movies (id, name,year);"); // create table flight
            PreparedStatement prep = conn.prepareStatement(
                    "insert into movies values (?, ?,?);"); // sintax for putting record in database
            prep.setInt(1, 1); // first id of first flight
            prep.setString(2, "Here is a movie for sure"); // flight name
            prep.setInt(3, 1999);
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setInt(1, 2); // first id of first flight
            prep.setString(2, "Here is the second movie for sure"); // flight name
            prep.setInt(3, 2000);
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setInt(1, 3); // first id of first flight
            prep.setString(2, "Here is the third movie for sure"); // flight name
            prep.setInt(3, 2003);
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setInt(1, 4); // first id of first flight
            prep.setString(2, "Here is the fourth movie for sure"); // flight name
            prep.setInt(3, 2009);
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
        } else { // here for query
            ResultSet rs = stat.executeQuery("select * from movies;");
            while (rs.next()) {
                System.out.print("Movie = " + rs.getInt("id") + " is : ");
                System.out.println(rs.getString("name"));
                System.out.println("Year of the movie = " + rs.getInt("year"));
            }
            rs.close();
        }
        conn.close();
    }
}
