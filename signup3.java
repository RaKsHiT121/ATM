package org.yourcompany.yourproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class signup3 extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox s1,s2,s3,s4,s5,s6,s7;
    JButton submit,cancel;
    String form;
    signup3(String a){
        form=a;
        setVisible(true);
        setLayout(null);
        setSize(600,700);
       setLocation(350,20);
        
       JLabel li=new JLabel("Page 3: Account details");
       li.setFont(new Font("Raleway",Font.BOLD, 22));
       li.setBounds(200,40,400,40);
       add(li); 

       JLabel account=new JLabel("Account Type");
       account.setBounds(80,120,200,25);
       account.setFont(new Font("Raleway",Font.BOLD,18));
       add(account);

       r1=new JRadioButton("Savings Account");
       r1.setFont(new Font("Raleway",Font.PLAIN,14));
       r1.setBounds(80,150,160,22);
       add(r1);

       r2=new JRadioButton("Current Account");
       r2.setFont(new Font("Raleway",Font.PLAIN,14));
       r2.setBounds(300,150,160,22);
       add(r2);

       r3=new JRadioButton("Fixed Deposit Account");
       r3.setFont(new Font("Raleway",Font.PLAIN,14));
       r3.setBounds(80,175,200,22);
       add(r3);

       r4=new JRadioButton("Reccuring deposit Account");
       r4.setFont(new Font("Raleway",Font.PLAIN,14));
       r4.setBounds(300,175,225,22);
       add(r4);

       ButtonGroup gr=new ButtonGroup();
       gr.add(r1);
       gr.add(r2);
       gr.add(r3);
       gr.add(r4);

       JLabel card=new JLabel("Card Number");
       card.setBounds(80,225,200,25);
       card.setFont(new Font("Raleway",Font.BOLD,18));
        add(card);
        
       JLabel cardd=new JLabel("Your 16 Digit Card Number");
       cardd.setBounds(80,247,200,15);
       cardd.setFont(new Font("Raleway",Font.BOLD,10));
        add(cardd);
        JLabel cardn=new JLabel("XXXX-XXXX-XXXX-4184");
        cardn.setBounds(300,225,220,25);
       cardn.setFont(new Font("Raleway",Font.BOLD,18));
        add(cardn);

        JLabel Pin=new JLabel("PIN");
        Pin.setBounds(80,280,200,25);
       Pin.setFont(new Font("Raleway",Font.BOLD,18));
        add(Pin);
        JLabel Pind=new JLabel("Your 4 Digit Pin Number");
       Pind.setBounds(80,305,200,15);
       Pind.setFont(new Font("Raleway",Font.BOLD,10));
        add(Pind);
        JLabel pinn=new JLabel("XXXX");
        pinn.setBounds(300,280,200,25);
       pinn.setFont(new Font("Raleway",Font.BOLD,18));
        add(pinn);

        JLabel services=new JLabel("Services Required: ");
        services.setBounds(80,350,200,25);
       services.setFont(new Font("Raleway",Font.BOLD,18));
        add(services);

        s1=new JCheckBox("ATM Card");
        s1.setFont(new Font("Raleway",Font.PLAIN,14));
        s1.setBounds(80,380,160,22);
        add(s1);
 
        s2=new JCheckBox("Internet Banking");
        s2.setFont(new Font("Raleway",Font.PLAIN,14));
        s2.setBounds(300,380,200,22);
        add(s2);
        s3=new JCheckBox("Email & SMS Alerts");
        s3.setFont(new Font("Raleway",Font.PLAIN,14));
        s3.setBounds(80,420,160,22);
        add(s3);
 
        s4=new JCheckBox("Mobile Banking");
        s4.setFont(new Font("Raleway",Font.PLAIN,14));
        s4.setBounds(300,420,200,22);
        add(s4);
        s5=new JCheckBox("Cheque Book");
        s5.setFont(new Font("Raleway",Font.PLAIN,14));
        s5.setBounds(80,460,160,22);
        add(s5);
 
        s6=new JCheckBox("E-Statement");
        s6.setFont(new Font("Raleway",Font.PLAIN,14));
        s6.setBounds(300,460,200,22);
        add(s6);

        s7=new JCheckBox("I hereby declare that above all entered details are correct");
        s7.setFont(new Font("Raleway",Font.PLAIN,13));
        s7.setBounds(80,550,400,17);
        add(s7);

        submit=new JButton("SUBMIT");
        submit.setBounds(130,575,100,30);
        submit.setFont(new Font("Raleway",Font.BOLD,15));
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        add(submit);
        submit.addActionListener(this);
        cancel=new JButton("CANCEL");
        cancel.setBounds(310,575,100,30);
        cancel.setFont(new Font("Raleway",Font.BOLD,15));
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        add(cancel);
        cancel.addActionListener(this);


        revalidate();
        repaint();

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType=null;
            if(r1.isSelected()){
                accountType="Savings";
            }
            else if(r2.isSelected()){
                accountType="Current";
            }
            else if(r3.isSelected()){
                accountType="Fixed Deposit";
            }
            else if(r4.isSelected()){
                accountType="Recurring Deposit";
            }

            Random ran=new Random();
            Long car =(ran.nextLong()%90000000L)+ 9319770000000000L;
            if(car<0){
                car*=-1;
            }
            String card=""+car;
            System.out.println(card);
            Long pi=(ran.nextLong()%9000L)+1000L;
            if(pi<0){
                pi*=-1;
            }
            String pin=""+pi;
            StringBuilder services=new StringBuilder("");
            if(s1.isSelected()){
                services.append("ATM CARD ");
            }
            else if(s2.isSelected()){
                services.append("Internet Banking ");
            }
            else if(s3.isSelected()){
                services.append("Email & Sms Alerts ");
            }
            else if(s4.isSelected()){
                services.append("Mobile Banking ");
            }
            else if(s5.isSelected()){
                services.append("Cheque Book ");
            }
            else if(s6.isSelected()){
                services.append("E-Statement");
            }
            try {
                if(!s7.isSelected()){
                    JOptionPane.showMessageDialog(null, "Check this");
                }
                else{
                Conn c=new Conn();
                String query = "insert into signup3 values('" + form + "','" + accountType + "','"+card+"','"+pin+"','" + services + "')";
                String query1="insert into login values('"+form+"','"+card+"','"+pin+"')";
                String query2="insert into balance values('"+card+"','0')";
                System.out.println("query execueted");
                c.s.executeUpdate(query);
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Card Number "+card+"\n Pin- "+pin);
                setVisible(false);
                new Login().setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }   
    } 
    public static void main(String[] args) {
        new signup3("");
    }
}
