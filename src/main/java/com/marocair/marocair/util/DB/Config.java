package com.marocair.marocair.util.DB;
//import io.github.cdimascio.dotenv.Dotenv;

public class Config {
//        public static Dotenv dotenv = Dotenv.load();
//        private final static String URL = dotenv.get("URL") ;
        private final static String URL = "jdbc:postgresql://localhost:5432/youflight" ;
//        private final static String USER = dotenv.get("USER");
        private final static String USER = "postgres";
        //setup env variable for later use
//        private final static String PASSWORD = dotenv.get("PASSW");
        private final static String PASSWORD = "nopass";


        public static String getUrl() {
            return URL;
        }

        public static String getUser() {
            return USER;
        }

        public static String getPassword() {
            return PASSWORD;
        }

}
