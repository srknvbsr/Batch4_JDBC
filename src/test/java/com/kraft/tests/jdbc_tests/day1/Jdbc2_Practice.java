package com.kraft.tests.jdbc_tests.day1;

import java.sql.*;

public class Jdbc2_Practice {

    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        String dbUsername = "postgres";
        String dbPassword = "154847";

        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from locations");
        //get the locationsId, streetaddress and postcode of first

        resultSet.next();
        String locationsId = resultSet.getString("locationid");
        String streetaddress = resultSet.getString("streetaddress");
        String postcode = resultSet.getString("postcode");
        System.out.println("locationsId = " + locationsId);
        System.out.println("streetaddress = " + streetaddress);
        System.out.println("postcode = " + postcode);
        System.out.println("-----------------------------------------------------");


        //get the locatons , street address, city and region

        resultSet.next();
        String locationIdOfSecondRow = resultSet.getString(1);
        String streetAddressOfSecondRow = resultSet.getString(2);
        String cityOfRow = resultSet.getString(4);
        String regionOfRow = resultSet.getString(5);

        System.out.println("locationIdOfSecondRow = " + locationIdOfSecondRow);
        System.out.println("streetAddressOfSecondRow = " + streetAddressOfSecondRow);
        System.out.println("cityOfRow = " + cityOfRow);
        System.out.println("regionOfRow = " + regionOfRow);

        System.out.println("----------------------------------------------------------------------");
        // get all information of 5th row
        resultSet.next();
        resultSet.next();
        resultSet.next();
        for (int i = 1; i <=6 ; i++) {
            System.out.println(i + " . " + resultSet.getString(i));

        }


        //get the region of last row

        resultSet.next();
        resultSet.next();
        resultSet.next();
        System.out.println("--------------------------------------------------" +
                "");
        String regionLastRow = resultSet.getString("region");
        System.out.println("regionLastRow = " + regionLastRow);


        resultSet.close();
        statement.close();
        connection.close();


    }


}
