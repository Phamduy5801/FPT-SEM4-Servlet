package com.example.Servlet.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    private static Connection connection = null;

    public static Connection getConnection() {
        if(connection==null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/servlet","root","");
                System.out.println("ket noi database thanh cong!");
            }catch (Exception exception){
                exception.printStackTrace();
            };
        }
        return connection;
    }

//    public static void main(String[] args) {
//        DBConnect.getConnection();
//    }
}
