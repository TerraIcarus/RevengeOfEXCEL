package com.example.demo1;
import java.sql.*;

    public class Connect {
        static String username = "PKS";
        static String password = "PKS";

        public static Connection Connect ( )
        {
            try {
                Connection connection = DriverManager.getConnection("jdbc:postgresql://46.229.214.241:5432/MazuninaT", username, password) ;
                System.out.println("Connected!");
                return connection;
            } catch (SQLException e) {
                System.out.println("Connection error");
                e.printStackTrace();
                return null;
            }
        }
    }
