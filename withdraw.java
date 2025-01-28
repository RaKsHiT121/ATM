package org.yourcompany.yourproject;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;

public class withdraw extends JFrame implements ActionListener{
    JTextField text;
    JButton withdraw,cancel;
    String card,pin;
    withdraw(String a,String b){
        pin=a;
        card=b;
    setSize(700,700);
    setLocation(300,0);
    setLayout(null);
    String imagePath = "C:/Users/useer/Desktop/atmphoto.png";
    ImageIcon imageIcon = new ImageIcon(imagePath);
    Image i2=imageIcon.getImage().getScaledInstance(700,700, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel label = new JLabel(i3);
    label.setBounds(0,0,700,700);
    add(label);

    JLabel depo=new JLabel("Enter Amount to be withdrawed");
    depo.setBounds(145,265,700,25);
    depo.setFont(new Font("Raleway",Font.BOLD,15));
    depo.setBackground(Color.BLACK);
    depo.setForeground(Color.WHITE);
    label.add(depo);
    
    text=new JTextField();
    text.setBounds(145,300,250,25);
    text.setFont(new Font("Raleway",Font.BOLD,15));
    text.setBackground(Color.WHITE);
    label.add(text);

    withdraw=new JButton("withdraw");
    withdraw.setBounds(275,380,130,25);
    withdraw.setFont(new Font("Raleway",Font.BOLD,13));
    withdraw.addActionListener(this); 
    label.add(withdraw);

    cancel=new JButton("Cancel");
    cancel.setBounds(275,420,130,25);
    cancel.setFont(new Font("Raleway",Font.BOLD,13));
    label.add(cancel);
    cancel.addActionListener(this);

    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdraw){
            String amount=text.getText();
            Date date=new Date();
            String dat=date.toString();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null, "Amount can;t be empty");
            }
            else{
                try {
                    Conn c=new Conn();
                    String am="select amount from balance where CardNumber='"+card+"'";
                    ResultSet rs=c.s.executeQuery(am);
                    if(rs.next()){
                    Long amoun=Long.parseLong(rs.getString("amount"));
                    Long dp=Long.parseLong(amount);
                    Long ans=Long.parseLong(amount);
                    if(amoun>=dp){
                    amoun-=dp;
                    System.out.println(amoun);
                    amount=""+amoun;
                    System.out.println(amount);
                    String query="update balance set amount='"+amount+"' where CardNumber='"+card+"' ";
                    String query1 = "insert into history values('" + card + "','" + amount + "','Withdraw','" + dat + "','"+ans+"')";

                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);
                    System.out.println("Sccessfully withdrawed amount i.e "+ amount);
                    JOptionPane.showMessageDialog(null, "Sccessfully withdrawed amount i.e  '"+ans+"'");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Account doesnt have sufficient balance");
                    }
                }
                
            }
             catch (Exception e) {
                System.out.println(e);
            }
        }
        
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new transactions(pin,card).setVisible(true);
        }
        
    }

    public static void main(String[] args) {
        new withdraw("52","9319769945992814");
    }

}
