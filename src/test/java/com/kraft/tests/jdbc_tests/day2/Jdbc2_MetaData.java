package com.kraft.tests.jdbc_tests.day2;

import org.testng.annotations.Test;

import java.sql.*;

public class Jdbc2_MetaData {
    String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    String dbUsername = "postgres";
    String dbPassword = "154847";

    @Test
    public void Test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees");

        //get the database related data inside the dbMetada object
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        //System.out.println("databaseMetaData.getUserName() = " + databaseMetaData.getUserName());


        // get the result set object metadata
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        int columnCount = resultSetMetaData.getColumnCount();
        System.out.println("columnCount = " + columnCount);

        System.out.println("---------------------------------------------------------------------");

        String nameOfFirstColumn = resultSetMetaData.getColumnName(1);
        String nameOfSecondColumn = resultSetMetaData.getColumnName(2);
        System.out.println("nameOfSecondColumn = " + nameOfSecondColumn);
        System.out.println("nameOfFirstColumn = " + nameOfFirstColumn);

        //print all the column names dynamically
        for (int i = 1; i <= columnCount; i++) {
            System.out.println(i+ " . " + resultSetMetaData.getColumnName(i));
        }




        resultSet.close();
        statement.close();
        connection.close();

    }
}




