package com.kraft.tests.jdbc_tests.day2;

import com.kraft.utilities.DBUtils;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Jdbc5_DbUtilsPractice {


    @Test
    public void listOfMap() {
        //create connection
        DBUtils.createConnection();

        // get all employees information and put them into

        List<Map<String,Object>> list = DBUtils.getQueryResultMap("select * from employees");

        //print all information that nelongs the employees table
        System.out.println("list = " + list);

        //close connection
                        DBUtils.destroy();


    }
    @Test
    public void oneSingleRow(){
        DBUtils.createConnection();

        //get one row employee information and put them into map
        Map<String, Object> rowMap = DBUtils.getRowMap("select * from employees where firstname = 'Elif'");
        System.out.println("rowMap = " + rowMap);
        //close connection
        DBUtils.destroy();


    }


}
