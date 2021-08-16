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

import java.sql.*;
import java.util.ArrayList;

public class DemoJDBC {
    String jdbcURL = "jdbc:mysql://localhost:3307/payroll_service?useSSL=false";
    String userName ="root";
    String password = "Ganesh@7779";
    ArrayList<tableModel> salaryList =new ArrayList<>();
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

    public int getSalaryFromDb (String query){
        connectToDb(jdbcURL,userName,password);
        try {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (!(resultSet.next() != true)){
                tableModel employee = new tableModel(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4));
                salaryList.add(employee);
            }
            System.out.println(salaryList);
            return salaryList.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
