package com.kraft.tests.jdbc_tests.day2;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jdbc3_ListOfMap {
    String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    String dbUsername = "postgres";
    String dbPassword = "154847";

    @Test
    public void Test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select firstname , lastname,salary,jobid from employees");

        //create a result set metadata object o get column related information
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        //List for keeping all rows in a list
        List<Map<String,Object>> queryData = new ArrayList<>();


        //get the column number dynamically
        int columnCount = resultSetMetaData.getColumnCount();
        while (resultSet.next()){
            Map<String,Object> map = new HashMap<>();

            for (int i = 1; i <=columnCount ; i++) {

                map.put(resultSetMetaData.getColumnName(i),resultSet.getString(i));

            }
            queryData.add(map);

        }
        System.out.println("queryData = " + queryData);

        //get the jobid of last row
        queryData.get(queryData.size()-1).get("jobid");


        resultSet.close();
        statement.close();
        connection.close();

    }
}


