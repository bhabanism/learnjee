package com.bsm.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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


    public static void getDerbyData() throws Exception {

        Class.forName(DERBY_JDBC_CLIENT_DRIVER).newInstance();
        Connection con = DriverManager.getConnection(dbURL);


        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from junk");
        while(rs.next()) {
            System.out.println("Junk Data: " + rs.getString(1));
        }

        con.close();


    }
}
