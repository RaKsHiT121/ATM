package org.yourcompany.yourproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class signu2 extends JFrame implements ActionListener{
    JComboBox relig,categ,income,Education,Occupation;
    JTextField aadhar,pan;
    String formno;
    JRadioButton seniory,seniorn,accounty,accountn;
    JButton next;

    signu2(String form){
        formno=form;
        setTitle("APPLICATION FORM");
        setVisible(true);
        setLocation(350,10);
        setSize(850,700);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel additional=new JLabel("PAGE:2 ADDITIONAL DETAILS");
        additional.setFont(new Font("Raleway",Font.BOLD,22));
        additional.setBounds(290,80,400,30);
        add(additional);

        JLabel religion=new JLabel("Religion");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);
        String[] valre={"Select","Hindu","Sikh","Buddhism","Jainism","Muslim","Other"};
        relig=new JComboBox(valre);
        relig.setFont(new Font("Raleway",Font.PLAIN,12));
        relig.setBounds(350,140,250,30);
        add(relig);

        String[] valcat={"General","EWS","OBC","SC","ST"};
        JLabel category=new JLabel("Annual Income:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,170,30);
        add(category);
        categ=new JComboBox(valcat);
        categ.setFont(new Font("Raleway",Font.PLAIN,12));
        categ.setBounds(350,190,250,30);
        add(categ);

        JLabel Income=new JLabel("Annual Income");
        Income.setFont(new Font("Raleway",Font.BOLD,20));
        Income.setBounds(100,240,150,30);
        add(Income);
        String[] valinc={"Select","Null","<1lakh","1lakh-2lakh","2lakh-5lakh","5lakh-8lakh","8lakh-12lakh",">12lakh"};
        income=new JComboBox(valinc);
        income.setFont(new Font("Raleway",Font.PLAIN,12));
        income.setBounds(350,240,250,30);
        add(income);

        JLabel education=new JLabel("Education \nlevel");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,290,150,30);
        add(education);
        String[] valedu={"Select","School level(below or 10)","School level(11-12)","Currently studying(school)","In college","Graduate","Master","Doctorate","Diploma"};
        Education=new JComboBox(valedu);
        Education.setFont(new Font("Raleway",Font.PLAIN,12));
        Education.setBounds(350,290,250,30);
        Education.setBackground(Color.white);
        add(Education);
        String[] occ={"Select","Self owned(low scale)","Salaried Employeed","Business","Student","Retired"};
        JLabel occupation=new JLabel("Occupation");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,340,120,30);
        add(occupation);
        Occupation=new JComboBox(occ);
        Occupation.setFont(new Font("Raleway",Font.PLAIN,12));
        Occupation.setBounds(350,340,250,30);
        add(Occupation);

        JLabel PAN=new JLabel("PAN NO.");
        PAN.setFont(new Font("Raleway",Font.BOLD,20));
        PAN.setBounds(100,390,170,30);
        add(PAN);
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,15));
        pan.setBounds(350,390,250,30);
        pan.setBackground(Color.white);
        add(pan);
       
    
        JLabel Aadhar=new JLabel("Aadhar");
        Aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        Aadhar.setBounds(100,440,100,30);
        add(Aadhar);
         aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,15));
        aadhar.setBounds(350,440,250,30);
        add(aadhar);

        JLabel senior=new JLabel("Senior Citizen");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,490,170,30);
        add(senior);
        seniory=new JRadioButton("YES");
        seniory.setFont(new Font("Raleway",Font.PLAIN,14));
        seniory.setBounds(400,490,65,30);
        add(seniory);
        seniorn=new JRadioButton("NO");
        seniorn.setFont(new Font("Raleway",Font.PLAIN,14));
        seniorn.setBounds(520,490,65,30);
        add(seniorn);
        ButtonGroup seni=new ButtonGroup();
        seni.add(seniorn);
        seni.add(seniory);

        JLabel exist_Account=new JLabel("Account Exist");
        exist_Account.setFont(new Font("Raleway",Font.BOLD,20));
        exist_Account.setBounds(100,540,170,30);
        add(exist_Account);
        accounty=new JRadioButton("YES");
        accounty.setFont(new Font("Raleway",Font.PLAIN,14));
        accounty.setBounds(400,540,65,30);
        add(accounty);
        accountn=new JRadioButton("NO");
        accountn.setFont(new Font("Raleway",Font.PLAIN,14));
        accountn.setBounds(520,540,65,30);
        add(accountn);
        ButtonGroup acc=new ButtonGroup();
        acc.add(accountn);
        acc.add(accounty);

        next=new JButton("NEXT");
        next.setBounds(650,600,80,30);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        add(next);
        next.addActionListener(this);
        revalidate();
        repaint();
}
public void actionPerformed(ActionEvent ae){
    String religion=(String)relig.getSelectedItem();
    String category=(String)categ.getSelectedItem();
    String incom=(String)income.getSelectedItem();
    String education=(String)Education.getSelectedItem();
    String occupation=(String)Occupation.getSelectedItem();
    String Aadhar=aadhar.getText();
    String Pan=pan.getText();
    String senior=null;
    if(seniory.isSelected()){
        senior="yes";
    }
    else{
        senior="no";
    }
    String exist=null;
    if(accounty.isSelected()){
        exist="yes";
    }
    else{
        exist="no";
    }

    try {
        if(Aadhar.equals("")||Aadhar.length()<12){
            JOptionPane.showMessageDialog(null, "enter valid aadhar number");
        }
        else{
            Conn c=new Conn();
            String query="insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+incom+"','"+education+"','"+occupation+"','"+Aadhar+"','"+Pan+"','"+senior+"','"+exist+"')";
            c.s.executeUpdate(query);
            System.out.println("Query successfully executed data stored");
            setVisible(false);
            new signup3(formno).setVisible(true);
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}
}
