package com.marocair.marocair.util.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    protected static Connection conn = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
    }

    protected void establishConnection () {
        try {
            if(conn == null) conn = DriverManager.getConnection(Config.getUrl(), Config.getUser(), Config.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
