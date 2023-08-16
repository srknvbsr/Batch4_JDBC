package com.kraft.tests.jdbc_tests.day1;

import java.sql.*;

public class Jdbc1_Intro {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        String dbUsername = "postgres";
        String dbPassword = "154847";

        //create connection
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        //create a statement Object
        Statement statement = connection.createStatement();
        //Run query and get the result in result set object
        ResultSet resultSet = statement.executeQuery("select * from employees");

        //move pointer to the next row
        resultSet.next();
        //getting the information by column name
        System.out.println("resultSet.getString(\"employeeId\") = " + resultSet.getString("employeeId"));
        System.out.println("resultSet.getString(\"firstname\") = " + resultSet.getString("firstname"));
        System.out.println("resultSet.getString(\"lastname\") = " + resultSet.getString("lastname"));
        System.out.println("resultSet.getString(\"phonenumber\") = " + resultSet.getString("phonenumber"));

        //gettin the information by index number
        System.out.println("resultSet.getString(3) = " + resultSet.getString(3));
        System.out.println("resultSet.getString(4) = " + resultSet.getString(4));
        System.out.println("resultSet.getString(6) = " + resultSet.getString(6));
        System.out.println("---------------------------------------------------------------------------");
        //move pointer to the second row
        resultSet.next();

        //get the phonenumber by column name
        System.out.println("resultSet.getString(\"phonenumber\") = " + resultSet.getString("phonenumber"));
        System.out.println("resultSet.getString(5) = " + resultSet.getString(5));

        System.out.println("---------------------------------------------------------------------------");

        //get all employeeId , firstname and lastname in one shot

        //while
        while (resultSet.next()){
            String employeeId = resultSet.getString("employeeId");
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            System.out.println("employeeId = " + employeeId);
            System.out.println("firstname = " + firstname);
            System.out.println("lastname = " + lastname);
            System.out.println("-------------------------------------------------------------");
        }
       /* //for loop
        for (int i = 0; resultSet.next(); i++) {
            String employeeId = resultSet.getString("employeeId");
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            System.out.println("Employee ID: " + employeeId);
            System.out.println("First Name: " + firstname);
            System.out.println("Last Name: " + lastname);
            System.out.println("-----------------------------------------------");

        }

        */
        resultSet.close();
        statement.close();
        connection.close();
    }
}
