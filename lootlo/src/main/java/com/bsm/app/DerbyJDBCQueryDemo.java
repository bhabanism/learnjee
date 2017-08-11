package com.bsm.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mishra on 11/8/17.
 */


public class DerbyJDBCQueryDemo {


    public static final String DERBY_JDBC_CLIENT_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private static String dbURL = "jdbc:derby://localhost:1527/lootlodb";

    public static void main(String[] args) {
        try {
            getDerbyData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static List<String> getDerbyData() throws Exception {

        Class.forName(DERBY_JDBC_CLIENT_DRIVER).newInstance();
        Connection con = DriverManager.getConnection(dbURL);


        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from junk");

        List<String> junkList = new ArrayList<String>();
        while(rs.next()) {
            junkList.add(rs.getString("data"));
            System.out.println("Junk Data: " + rs.getString("data"));
        }

        con.close();

        return junkList;


    }
}
