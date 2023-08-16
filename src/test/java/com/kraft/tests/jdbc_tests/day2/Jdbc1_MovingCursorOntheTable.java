package com.kraft.tests.jdbc_tests.day2;

import org.testng.annotations.Test;

import java.sql.*;

public class Jdbc1_MovingCursorOntheTable {
    String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    String dbUsername = "postgres";
    String dbPassword = "154847";

    @Test
    public void Test1() throws SQLException {
        /**
         * resultSet Methods
         * next() --> bir sonraki satıra gider
         * preious()-->bir önceki satıra gider
         * beforeFirst()--> ilk satırda önceki default duruma döndürür.
         * afterLast()--> pointerı son satırdan sonraki (bir çeşişt ) boş satıra götürür.
         * last()--> pointerı son satıra götürür
         * absolute(integer)--> poınteri istediğimiz satıra götürür
         * first--> pointerı ilk data satırına götürür.
         *
         */


        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees");

        //how to find how many rows we have
        resultSet.last();
        int rowCount = resultSet.getRow();
        System.out.println("rowCount = " + rowCount);

        System.out.println("------------------------------------------------------------------------------------------");

        //
        resultSet.first();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());


        //how to get "ahmet" firstname
        resultSet.absolute(7);
        String firstnameOf7thRow = resultSet.getString("firstname");
        System.out.println("firstnameOf7thRow = " + firstnameOf7thRow);
        System.out.println("------------------------------------------------------------------------------------------");
        //how to go 6th

        resultSet.previous();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());


        resultSet.close();
        statement.close();
        connection.close();

    }
}
