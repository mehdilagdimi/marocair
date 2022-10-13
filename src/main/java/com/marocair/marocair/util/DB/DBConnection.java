package com.marocair.marocair.util.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection conn = null;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
    }

    public static void establishConnection () {
        try {
//            System.out.println(Config.getUrl());
//            System.out.println(Config.getUser());
            if(conn == null) conn = DriverManager.getConnection(Config.getUrl(), Config.getUser(), Config.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
