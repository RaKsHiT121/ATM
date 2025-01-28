package org.yourcompany.yourproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pinchange extends JFrame implements ActionListener{
    String card,pin;
    JButton back,confirm;
    JTextField pinn,pinnc;
    pinchange(String a,String b){
        card=b;
        pin=a;
        
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

        JLabel enter=new JLabel("Enter new Pin");
        enter.setBounds(140,260,125,30);
        enter.setFont(new Font("Raleway",Font.BOLD,16));
        enter.setBackground(Color.WHITE);
        enter.setForeground(Color.WHITE);
        label.add(enter);
        pinn=new JTextField();
        pinn.setBounds(280,260,100,30);
        pinn.setFont(new Font("Raleway",Font.BOLD,14));
        pinn.setBackground(Color.WHITE);
        pinn.setForeground(Color.BLACK);
        label.add(pinn);

        pinnc=new JTextField();
        pinnc.setBounds(280,310,100,30);
        pinnc.setFont(new Font("Raleway",Font.BOLD,14));
        pinnc.setBackground(Color.WHITE);
        pinnc.setForeground(Color.BLACK);
        label.add(pinnc);

        JLabel entern=new JLabel("Confirm Pin");
        entern.setBounds(140,310,125,30);
        entern.setFont(new Font("Raleway",Font.BOLD,16));
        entern.setBackground(Color.WHITE);
        entern.setForeground(Color.WHITE);
        label.add(entern);

        confirm=new JButton("CONFIRM");
        confirm.setBounds(150,400,100,30);
        confirm.setFont(new Font("Raleway",Font.BOLD,13));
        confirm.setBackground(Color.WHITE);
        confirm.setBackground(Color.WHITE);
        confirm.addActionListener(this);
        label.add(confirm);

        back=new JButton("BACK");
        back.setBounds(270,400,100,30);
        back.setFont(new Font("Raleway",Font.BOLD,13));
        back.setBackground(Color.WHITE);
        back.setBackground(Color.WHITE);
        label.add(back);
        back.addActionListener(this);
        setVisible(true);
    }   
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==confirm){
            String pinente=pinn.getText();
            String pincon=pinnc.getText();
            if(pinente.equals(pincon) && pinente.length()==4){
                String query1="update login set pin='"+pinente+"' where cardNumber='"+card+"'";
                String query2="update signup3 set Pin='"+pinente+"' where CardNumber='"+card+"'";
                try {
                    Conn c=new Conn();
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Pin changed Successfully");
                    System.out.println("Successfully pin changed");
                    pinn.setText("");
                    pinnc.setText("");
                    setVisible(false);
                    new transactions(pin,card).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "PIN doesnt match and pin length must be 4");
            }
        }
        else{
            setVisible(false);
            new transactions(pin,card).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new pinchange("1236","9319769945992814");
    }
}
