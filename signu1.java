package org.yourcompany.yourproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class signu1 extends JFrame implements ActionListener{
    long ran;
    JTextField nameText,fnameText,enameText,addText,stateText,cityText,pinText;
    JDateChooser dobDateChooser;
    JRadioButton male,female,m,notm;
    JButton next;

    signu1(){
        setTitle("APPLICATION FORM");
        setVisible(true);
        setLocation(350,10);
        setSize(850,700);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        Random r=new Random();
        ran=(r.nextLong()%9000L)+1000L;
        if(ran<0){
            ran*=-1;
        }
        JLabel form=new JLabel("APPLICATION FORM NO: "+ran);
        form.setFont(new Font("Raleway",Font.BOLD,38));
        form.setBounds(140,20,600,40);
        add(form);
        JLabel personal=new JLabel("PAGE:1 Personal Details ");
        personal.setFont(new Font("Raleway",Font.BOLD,22));
        personal.setBounds(290,80,400,30);
        add(personal);

        JLabel name=new JLabel("Name:  ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        nameText=new JTextField();
        nameText.setFont(new Font("Raleway",Font.BOLD,20));
        nameText.setBounds(350,140,250,30);
        add(nameText);
        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,170,30);
        add(fname);
         fnameText=new JTextField();
        fnameText.setFont(new Font("Raleway",Font.BOLD,20));
        fnameText.setBounds(350,190,250,30);
        add(fnameText);
        JLabel DOB=new JLabel("Date Of Birth ");
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        DOB.setBounds(100,240,150,30);
        add(DOB);
        dobDateChooser=new JDateChooser();
        dobDateChooser.setFont(new Font("Raleway",Font.BOLD,20));
        dobDateChooser.setBounds(350,240,250,30);
        add(dobDateChooser);
        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,100,30);
        add(gender);
        male=new JRadioButton("MALE");
        male.setFont(new Font("Raleway",Font.BOLD,15));
        male.setBounds(350,290,80,30);
        male.setBackground(Color.white);
        add(male);
        female=new JRadioButton("FEMALE");
        female.setFont(new Font("Raleway",Font.BOLD,15));
       female.setBounds(450,290,100,30);
       female.setBackground(Color.white);
        add(female);

        ButtonGroup gen=new ButtonGroup();
        gen.add(male);
        gen.add(female);
        JLabel email=new JLabel("EMAIL");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,100,30);
        add(email);
         enameText=new JTextField();
        enameText.setFont(new Font("Raleway",Font.BOLD,20));
        enameText.setBounds(350,340,250,30);
        add(enameText);
        JLabel married=new JLabel("Martial Status");
        married.setFont(new Font("Raleway",Font.BOLD,20));
        married.setBounds(100,390,170,30);
        add(married);
        m=new JRadioButton("MARRIED");
        m.setFont(new Font("Raleway",Font.BOLD,15));
        m.setBounds(350,390,100,30);
        m.setBackground(Color.white);
        add(m);
        notm=new JRadioButton("NOT MARRIED");
        notm.setFont(new Font("Raleway",Font.BOLD,15));
        notm.setBounds(470,390,120,30);
        notm.setBackground(Color.white);
        add(notm);
        ButtonGroup marr=new ButtonGroup();
        marr.add(notm);
        marr.add(m);
        JLabel address=new JLabel("Address");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,100,30);
        add(address);
         addText=new JTextField();
        addText.setFont(new Font("Raleway",Font.BOLD,20));
        addText.setBounds(350,440,250,30);
        add(addText);
        JLabel City=new JLabel("CITY:  ");
        City.setFont(new Font("Raleway",Font.BOLD,20));
        City.setBounds(100,490,100,30);
        add(City);
        cityText=new JTextField();
        cityText.setFont(new Font("Raleway",Font.BOLD,20));
        cityText.setBounds(350,490,250,30);
        add(cityText);
        JLabel Pincode=new JLabel("PINCODE");
        Pincode.setFont(new Font("Raleway",Font.BOLD,20));
        Pincode.setBounds(100,540,100,30);
        add(Pincode);
         pinText=new JTextField();
        pinText.setFont(new Font("Raleway",Font.BOLD,20));
        pinText.setBounds(350,540,250,30);
        add(pinText);
        JLabel STATE=new JLabel("STATE");
        STATE.setFont(new Font("Raleway",Font.BOLD,20));
        STATE.setBounds(100,590,100,30);
        add(STATE);
        stateText=new JTextField();
        stateText.setFont(new Font("Raleway",Font.BOLD,20));
        stateText.setBounds(350,590,250,30);
        add(stateText);
        next=new JButton("NEXT");
        next.setBounds(650,620,80,30);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.addActionListener(this);
        add(next);
        revalidate();
        repaint();
    }
    public void actionPerformed(ActionEvent ae){
        String form=""+ran; 
        String name=nameText.getText();
        String fname=fnameText.getText();
        String email=enameText.getText();
        String address=addText.getText();
        String state=stateText.getText();
        String city=cityText.getText();
        String pin=pinText.getText();
        String date=((JTextField) dobDateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="male";
        }
        else{
            gender="female";
        }
        String marry=null;
        if(m.isSelected()){
            marry="married";
        }
        else{
            marry="not married";
        }
        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else{
                Conn c=new Conn();
                String query = "INSERT INTO signup VALUES('"+form+"','" + name + "','" + fname + "','" + date + "','" + gender + "','" 
                + email + "','" + marry + "','" + address + "','" + city + "','" + pin + "','" + state + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new signu2(form).setVisible(true);
                System.out.println("Query successfully executed data stored");
               
            }
        } catch (Exception e) {
            System.out.print(e);
        }



    }
    public static void main(String[] args) {
        new signu1();
    }
}

