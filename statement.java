package org.yourcompany.yourproject;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.sql.ResultSet;

public class statement extends JFrame{
    statement(String card){

        setLocation(100,50);
        setLayout(null);
        setTitle("Bank Statement");
        setSize(500,500);

        JLabel bank=new JLabel("Bank of Rakshit");
        bank.setBounds(170,30,125,30);
        bank.setFont(new Font("Raleway",Font.BOLD,16));
        bank.setBackground(Color.WHITE);
        bank.setForeground(Color.BLACK);
        add(bank);

        JLabel mini=new JLabel("CARD NUMBER:   "+card.substring(0,4)+"XXXXXXXX"+card.substring(12));
        mini.setBounds(35,90,300,20);
        mini.setFont(new Font("Raleway",Font.BOLD,14));
        add(mini);

        JLabel car=new JLabel("CARD NUMBER:   "+card.substring(0,4)+"XXXXXXXX"+card.substring(12));
        car.setBounds(35,135,300,20);
        car.setFont(new Font("Raleway",Font.BOLD,14));
        add(car);

        try {
            Conn c=new Conn();
            String query="select * from history where CardNumber='"+card+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                mini.setText(mini.getText()+"<html>" +rs.getString("TDate")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Transfertype")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount_change")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Transfertype")+"<br><br><html>");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        
        setVisible(true);
    }

    public static void main(String[] args) {
        new statement("9577364636636336");
    }
}
