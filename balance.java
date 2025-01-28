package org.yourcompany.yourproject;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JTextField;

public class balance extends JFrame implements ActionListener{
    String pin;
    String car;
    JButton back;
    balance(String a,String b){
        pin=a;
        car =b;
        setSize(700,700);
        setLocation(300,0);
        String imagePath = "C:/Users/useer/Desktop/atmphoto.png";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image i2=imageIcon.getImage().getScaledInstance(700,700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,700,700);
        add(label);

        JLabel card=new JLabel("Card Number");
        card.setBounds(140,250,125,30);
        card.setFont(new Font("Raleway",Font.BOLD,16));
        card.setBackground(Color.WHITE);
        card.setForeground(Color.WHITE);
        label.add(card);

        JLabel text=new JLabel(car);
        text.setBounds(260,250,130,30);
        text.setFont(new Font("Raleway",Font.BOLD,14));
        text.setBackground(Color.WHITE);
        text.setForeground(Color.WHITE);
        label.add(text);

        Conn c=new Conn();
        String am="";
        try {
            String query="select amount from balance where CardNumber='"+car+"'";
            ResultSet rs=c.s.executeQuery(query);
            if(rs.next()){
                am=rs.getString("amount");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        JLabel bal=new JLabel("RS. "+am);
        bal.setBounds(260,300,130,30);
        bal.setFont(new Font("Raleway",Font.BOLD,14));
        bal.setBackground(Color.WHITE);
        bal.setForeground(Color.WHITE);
        label.add(bal);

        JLabel cardno=new JLabel("Balance");
        cardno.setBounds(140,300,125,30);
        cardno.setFont(new Font("Raleway",Font.BOLD,16));
        cardno.setBackground(Color.WHITE);
        cardno.setForeground(Color.WHITE);
        label.add(cardno);
        back=new JButton("BACK");
        back.setBounds(270,400,100,30);
        back.setFont(new Font("Raleway",Font.BOLD,13));
        label.add(back);
        back.addActionListener(this);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new transactions(pin,car).setVisible(true);
        }
    }

   
    public static void main(String[] args) {
        new balance("abcdetdgd","9319769945992814");
    }
}
