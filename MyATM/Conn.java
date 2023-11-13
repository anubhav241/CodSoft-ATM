package com.MyATM;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
        String url = "jdbc:mysql://localhost:3306/atmsystem";
        String uname = "root";
        String pass = "root";
//        String query = "select * from signup";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url,uname,pass);
            s = c.createStatement();

            System.out.println("Connection Successfully");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Not Connected");
        }
    }

    public static void main(String[] args) {
        new Conn();
    }
}
