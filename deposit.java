package org.yourcompany.yourproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class deposit extends JFrame implements  ActionListener{
    JTextField text;
    JButton deposit,cancel;
    String card,pin;
    deposit(String a,String b){
        card =a;
        pin=b;
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

    JLabel depo=new JLabel("Enter Amount to be deposited");
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

    deposit=new JButton("Deposit");
    deposit.setBounds(275,380,130,25);
    deposit.setFont(new Font("Raleway",Font.BOLD,13));
    deposit.addActionListener(this); 
    label.add(deposit);

    cancel=new JButton("Cancel");
    cancel.setBounds(275,420,130,25);
    cancel.setFont(new Font("Raleway",Font.BOLD,13));
    label.add(cancel);
    cancel.addActionListener(this);

    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
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
                    dp+=amoun;
                    System.out.println(dp);
                    amount=""+dp;
                    System.out.println(amount);
                    String query="update balance set amount='"+amount+"' where CardNumber='"+card+"' ";
                    String query1 = "insert into history values('" + card + "','" + amount + "','deposit','" + dat + "','"+ans+"')";

                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);
                    System.out.println("Sccessfully deposited amount i.e "+ amount);
                    JOptionPane.showMessageDialog(null, "Sccessfully deposited amount i.e  '"+ans+"'");
                    }
            }
             catch (Exception e) {
                System.out.println(e);
            }
        }
        
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new transactions(card,pin).setVisible(true);
        }
        
    }

    public static void main(String[] args) {
        new deposit("9319769945992814","52");
    }
}
