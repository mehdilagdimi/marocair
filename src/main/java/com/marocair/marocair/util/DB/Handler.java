package com.marocair.marocair.util.DB;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Handler {


    public class DBConnection {

        private Connection conn = null;
        private PreparedStatement preparedStatement = null;
        private ResultSet resultSet = null;

        public DBConnection() {
            try {
                Class.forName("org.postgresql.Driver");
            }
            catch(ClassNotFoundException ex) {
                System.out.println("Error: unable to load driver class!");
                System.exit(1);
            }
        }

        public Connection establishConnection () {

            try {
                conn = DriverManager.getConnection(Config.getUrl(), Config.getUser(), Config.getPassword());
//            System.out.println("Connected to the PostgreSQL server successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
            return conn;
        }

        /**
         * Set statement after setting parameters and cast them to the referred type
         * @param index int
         * @param data generic type T it can be (Boolean, Int, Long...)
         * @param <T> generic type T
         */
        public <T>void setParam(int index, T data) {
            try{
//                switch (((Object) data).getClass().getSimpleName()) {
//                    case "Boolean" -> this.preparedStatement.setBoolean(index, (Boolean) data);
//                    case "Integer" -> this.preparedStatement.setInt(index, (int) data);
//                    case "Long" -> this.preparedStatement.setLong(index, (long) data);
//                    case "String" -> this.preparedStatement.setString(index, (String) data);
//                    case "Float" -> this.preparedStatement.setDouble(index, (Float) data);
//                    case "Double" -> this.preparedStatement.setDouble(index, (Double) data);
//                    case "LocalDate" -> this.preparedStatement.setObject(index, data);
//                }
                switch (((Object) data).getClass().getSimpleName()) {
                    case "Boolean" :
                        this.preparedStatement.setBoolean(index, (Boolean) data);
                        break;
                    case "Integer" :
                        this.preparedStatement.setInt(index, (int) data);
                        break;
                    case "Long" :
                        this.preparedStatement.setLong(index, (long) data);
                        break;
                    case "String" :
                        this.preparedStatement.setString(index, (String) data);
                        break;
                    case "Float" :
                        this.preparedStatement.setDouble(index, (Float) data);
                        break;
                    case "Double" :
                        this.preparedStatement.setDouble(index, (Double) data);
                        break;
                    case "LocalDate" :
                        this.preparedStatement.setObject(index, data);
                        break;
                }

            } catch (SQLException e){
                e.printStackTrace();
                System.out.println("Error with  statement parameter placeholder");
                this.preparedStatement = null;
            }
        }

        /**
         * Set the prepare statement and return true if statement is set
         * @param query Querry String
         * @return boolean (true,false)
         */
        public boolean prepare (String query) {
            try{
                this.preparedStatement = conn.prepareStatement(query);
                return true;
            } catch (SQLException e){
                e.printStackTrace();
                System.out.println("Failed preparing statement");
                return false;
            }
        }


        /**
         * Execute query and return a result set
         * @return ResultSet
         */
        public ResultSet execute () {
            try{
                if(this.preparedStatement != null){
                    resultSet = this.preparedStatement.executeQuery();
                    return resultSet;
                } else {
                    System.out.println("Prepared query is null!");
                    return null;
                }
            } catch (SQLException e){
                e.printStackTrace();
                System.out.println(e.getMessage());
                return null;
            }
        }
        public int executeUpdate () {
            int count = 0;
            try{
                if(this.preparedStatement != null){
                    count = this.preparedStatement.executeUpdate();
                } else {
                    System.out.println("Prepared query is null!");
                }
            } catch (SQLException e){
                e.printStackTrace();
                System.out.println(e.getMessage());
                ;
            }
            return count;
        }



        public boolean isEmpty() {
            Boolean isEmpty = true;
            if (this.resultSet != null) {
                try {
                    if (!this.resultSet.isBeforeFirst()) {
                        isEmpty = true;
                    } else {
                        isEmpty = false;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return isEmpty;
        }

        public void closeConnection () {
            if (this.conn != null) try {
                this.conn.close();
                System.out.println("Closing DB connection..");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error closing DB connection");
            }
        }

        public void closeQueryOperations () {
            if (this.resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
            if (this.preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
        }

    }

}
