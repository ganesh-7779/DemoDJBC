/********************************************************************
 *Purpose : Java Database connectivity using 7 steps
 *        1.Import java.sql*   2.Load and Register driver
 *        3. Create connection 4. Create Statement
 *        5. Execute Query     6. Process The Results
 *        7. close connection.
 * @Auther : Ganesh Gavhad
 * @since  : 15-08-2021
 * @version : 1.0
 **********************************************************************/
package com.bridgelabz;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DemoJDBC {

    private static Connection con;

    public static boolean connectToDb(String jdbcURL, String userName, String password)   {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            System.out.println("Connecting to database: " + jdbcURL);
            con = DriverManager.getConnection(jdbcURL,userName,password);
            System.out.println("Connection is successful " +con);
            return true;

        } catch (NullPointerException e){
            System.out.println("invalid Input");
            return false;
        } catch (SQLException e) {
            System.out.println("Cannot found Database");
            return false;
        } catch (ClassNotFoundException e){
            System.out.println("Cannot found driver in class path");
            return false;
        }
    }

}
