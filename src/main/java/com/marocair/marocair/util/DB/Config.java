package com.marocair.marocair.util.DB;
import io.github.cdimascio.dotenv.Dotenv;

public class Config {

        public static Dotenv dotenv = Dotenv.load();
        private final static String URL = dotenv.get("URL") ;
        private final static String USER = dotenv.get("USER");
        //setup env variable for later use
        private final static String PASSWORD = dotenv.get("PASSW");



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
