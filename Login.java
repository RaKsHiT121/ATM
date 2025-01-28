package org.yourcompany.yourproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Login extends JFrame implements  ActionListener{

    JButton clear,signIn,signUp;
    JTextField card;
    JPasswordField pinenter;
    Login() {
        setSize(800, 480);
        setLocationRelativeTo(null);
        setTitle("Automated Teller Machine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String imagePath = "C:/Users/useer/Desktop/atmlogo.png";
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image i2=imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        setLayout(null);
        label.setBounds(70, 10, 100,80);

        JLabel text=new JLabel("WELCOME TO THE ATM");
        text.setFont(new Font("Osward",Font.BOLD,30));
        text.setBounds(190,40,400,40);
        add(text);

        JLabel cardno=new JLabel("CARD No: ");
        cardno.setBounds(120,150,150,40);
        cardno.setFont(new Font("Osward",Font.BOLD,29));
        add(cardno);
        card=new JTextField();
        card.setBounds(300,150,200,30);
        add(card);
        JLabel pin=new JLabel("PIN: ");
        pin.setFont(new Font("Osward",Font.BOLD,29));
        pin.setBounds(120,220,150,40);
        pinenter=new JPasswordField();
        pinenter.setBounds(300, 220, 200, 30);
        add(pinenter);
        add(pin);

        clear=new JButton("CLEAR");
        clear.setBounds(300,300,90,35);
        clear.setFont(new Font("Osward",Font.BOLD,15));
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        signIn=new JButton("SIGN IN");
        signIn.setBounds(410,300,90,35);
        signIn.setFont(new Font("Osward",Font.BOLD,15));
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.addActionListener(this);
        add(signIn);
        signUp=new JButton("SIGN UP");
        signUp.setBounds(300,350,200,35);
        signUp.setFont(new Font("Osward",Font.BOLD,15));
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);


        getContentPane().setBackground(Color.WHITE);
        add(label);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            card.setText("");
            pinenter.setText("");
        }
        else if (ae.getSource()==signIn){
            Conn c=new Conn();
            String cardnumber=card.getText();
            String pinnumber=pinenter.getText();
            String query="select * from login where cardNumber='"+cardnumber+"' and pin='"+pinnumber+"'";
            try {
                ResultSet ans=c.s.executeQuery(query);
                if(ans.next()){
                    setVisible(false);
                    new transactions(pinnumber,cardnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Inccorect pin or card number.Enter Valid Card and Pin");
                    card.setText("");
                    pinenter.setText("");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
            new signu1().setVisible(true);
        }
    }
    public static void main(String[] args){
        new Login();
    }
}
