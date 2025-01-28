package org.yourcompany.yourproject;

import java.sql.*;
import java.util.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///bankmanage","root","Rakshit@123");
            s=c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    } 
}
