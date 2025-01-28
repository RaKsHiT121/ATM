package org.yourcompany.yourproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class transactions extends JFrame implements ActionListener{
    
    JButton deposit,fastCash,pinChange,cashWithdraw,miniStatement,balanceEnquiry,exit;
    String pin;
    String card;
    transactions(String a,String b){
        pin=a;
        card =b;
    setSize(700,700);
    setLocation(300,0);
    String imagePath = "C:/Users/useer/Desktop/atmphoto.png";
    ImageIcon imageIcon = new ImageIcon(imagePath);
    Image i2=imageIcon.getImage().getScaledInstance(700,700, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel label = new JLabel(i3);
    label.setBounds(0,0,700,700);
    add(label);

    JLabel text=new JLabel("Please Select Your Transaction");
    text.setBounds(145,250,700,25);
    text.setFont(new Font("Raleway",Font.BOLD,15));
    text.setBackground(Color.BLACK);
    text.setForeground(Color.WHITE);
    label.add(text);

    deposit=new JButton("Deposit");
    deposit.setBounds(130,370,125,25);
    deposit.setFont(new Font("Raleway",Font.BOLD,13));
    label.add(deposit);
    deposit.addActionListener(this);
    fastCash=new JButton("fast Cash");
    fastCash.setBounds(130,405,125,25);
    fastCash.setFont(new Font("Raleway",Font.BOLD,13));
    fastCash.addActionListener(this);

    label.add(fastCash);

    pinChange=new JButton("Pin Change");
    pinChange.setBounds(130,437,125,25);
    pinChange.setFont(new Font("Raleway",Font.BOLD,13));
    pinChange.addActionListener(this);
    label.add(pinChange);
    
    cashWithdraw=new JButton("Cash Withdraw");
   cashWithdraw.setBounds(275,335,135,25);
    cashWithdraw.setFont(new Font("Raleway",Font.BOLD,13));
    cashWithdraw.addActionListener(this);
    label.add(cashWithdraw);

    miniStatement=new JButton("miniStatement");
    miniStatement.setBounds(275,370,135,25);
    miniStatement.setFont(new Font("Raleway",Font.BOLD,13));
    miniStatement.addActionListener(this);
    label.add(miniStatement);

    balanceEnquiry=new JButton("BalanceEnquiry");
    balanceEnquiry.setBounds(275,405,135,25);
    balanceEnquiry.setFont(new Font("Raleway",Font.BOLD,13));
    balanceEnquiry.addActionListener(this); 
    label.add(balanceEnquiry);

    exit=new JButton("Exit");
    exit.setBounds(275,437,135,25);
    exit.setFont(new Font("Raleway",Font.BOLD,13));
    label.add(exit);
    exit.addActionListener(this);

    setLayout(null);
   // setUndecorated(true);
    setVisible(true);


    setLayout(null);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
           // System.exit(0);
            new Login().setVisible(true);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new deposit(card,pin).setVisible(true);;
        }
        else if(ae.getSource()==cashWithdraw){
            setVisible(false);
            new withdraw(card,pin).setVisible(true);
         }
         else if(ae.getSource()==balanceEnquiry){
            setVisible(false);
            new balance(pin,card);
         }
         else if(ae.getSource()==pinChange){
            setVisible(false);
            new pinchange(pin, card);
         }
    }
    public static void main(String[] args) {
        new transactions("","");
    }
}
