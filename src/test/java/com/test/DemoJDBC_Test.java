/********************************************************************
 *Purpose : Test Cases for Java Database connectivity Program using 7 steps
 *        1.Import java.sql*   2.Load and Register driver
 *        3. Create connection 4. Create Statement
 *        5. Execute Query     6. Process The Results
 *        7. close connection.
 * @Auther : Ganesh Gavhad
 * @since  : 15-08-2021
 * @version : 1.0
 **********************************************************************/
package com.test;

import com.bridgelabz.DemoJDBC;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class DemoJDBC_Test {
    String jdbcURL = "jdbc:mysql://localhost:3307/payroll_service?useSSL=false";
    String userName ="root";
    String password = "Ganesh@7779";

    @Test
    public void givenCorrect_connectToDb_whenSuccessful_ShouldReturnTrue() {
        try {
            DemoJDBC jdbc=new DemoJDBC();
            boolean connection = jdbc.connectToDb(jdbcURL, userName, password);
            Assert.assertTrue(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenPassword_whenIncorrect_ShouldReturnFalse() {
        try {
            String wrongPassword="Ganesh@77";
            DemoJDBC jdbc=new DemoJDBC();
            boolean connection = jdbc.connectToDb(jdbcURL, userName, wrongPassword);
            Assert.assertEquals(false,connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void givenUserName_whenIncorrect_ShouldReturnFalse() {
        try {
            String wrongUserName = "boot";
            DemoJDBC jdbc = new DemoJDBC();
            boolean connection = jdbc.connectToDb(jdbcURL, wrongUserName, password);
            Assert.assertEquals(false, connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //UC2
    @Test
    public void given_ListOfSalaryDetailsOfEmployess_ShouldReturnNumberOfEmployees() {
        try {
            DemoJDBC jdbc = new DemoJDBC();
            int result = jdbc.getSalaryFromDb("SELECT id,name,gender,salary FROM employee_payroll");
            Assert.assertEquals(3, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void given_ListOfSalaryDetailsOfEmployess_WhenGivenWrongQuery_ShouldReturnZero() {
        try {
            DemoJDBC jdbc = new DemoJDBC();
            int result = jdbc.getSalaryFromDb("SELECT * FROM employee");//Wrong Query, throws exception
            Assert.assertEquals(0, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
