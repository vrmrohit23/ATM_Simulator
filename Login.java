
 

package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    JButton signInButton,clearButton,signupButton,close;
    JTextField cardNo_textfield;
    JPasswordField pinNo_textfield;
    Login(){
        //set window title
        setTitle("AUTOMATED TELLER MACHINE");
        //set layout helps in placing the contents on frame by your choice
        //set layout helps in placing the contents on frame by your choice
        
        
        setLayout(null);
        //ImageIcon is required for image reference

        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("required files/logo.jpg"));
        //getscaledinstance is for adjusting the image size

        Image im = ic.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ics = new ImageIcon(im);
        JLabel atmlogo = new JLabel(ics);
        
        //setbounds is needed for setting logo location on the frame 
        atmlogo.setBounds(150, 10, 100, 100);
        add(atmlogo);

        //setting the frame backgroung color
        getContentPane().setBackground(Color.lightGray);

        //adding the first text
        JLabel firsttext = new JLabel("Welcome to ATM");
        firsttext.setBounds(280, 40, 400, 40);
        firsttext.setFont(new Font("Osward", Font.BOLD, 38));
        add(firsttext);
        
        JLabel cardno_text = new JLabel("Card No.");
        cardno_text.setBounds(200, 150, 120, 30);
        cardno_text.setFont(new Font("Raleway", Font.BOLD, 28));
        add(cardno_text);

        //adding the field where user can enter the text 
        cardNo_textfield = new JTextField();
        cardNo_textfield.setBounds(350,152 , 210,30 );
        cardNo_textfield.setBackground(Color.white);
    
        cardNo_textfield.setFont(new Font("Aerial", Font.CENTER_BASELINE, 15));
        add( cardNo_textfield);
        
        JLabel pinNo_text = new JLabel("PIN:");
        pinNo_text.setBounds(200, 220, 60, 30);
        pinNo_text.setFont(new Font("Raleway", Font.BOLD, 28));
        add(pinNo_text);
        
        pinNo_textfield = new JPasswordField();
        pinNo_textfield.setBounds(350,222 , 80,30 );
        pinNo_textfield.setBackground(Color.white);
        pinNo_textfield.setFont(new Font("Aerial", Font.CENTER_BASELINE, 15));
        add( pinNo_textfield);

        signInButton = new JButton("SIGN IN");
        signInButton.setBounds(350, 300, 100, 30);
        signInButton.setBackground(Color.red);
        signInButton.setForeground(Color.WHITE);
        signInButton.addActionListener(this);
        add(signInButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(460, 300, 100, 30);
        clearButton.setBackground(Color.red);
        clearButton.setForeground(Color.WHITE);
        clearButton.addActionListener(this);
        add(clearButton);

        signupButton = new JButton("SIGN UP");
        signupButton.setBounds(350, 340, 210, 30);
        signupButton.setBackground(Color.red);
        signupButton.setForeground(Color.WHITE);
        signupButton.addActionListener(this);
        add(signupButton);
 
        close = new JButton("Close");
        close.setBounds(400,390 , 100, 30);
        close.setBackground(Color.red);
        close.setForeground(Color.WHITE);
        close.addActionListener(this);
        add(close);
 
        setSize(800, 480);
        setVisible(true);
        setLocation(400, 200);
    }
    
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == signInButton){
                String cardnumber = cardNo_textfield.getText();
                String pin = pinNo_textfield.getText();
                String query = "Select * from carddetails where cardno = '"+cardnumber+"' and Pin = '"+pin+"'";
                Connectionclass con = new Connectionclass(query);
                try{
                ResultSet set = con.s.executeQuery(query);
                    if(set.next()){
                    new Transactions(pin);
                    setVisible(false);
                    }
                    else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                    }
                }    
                catch(Exception e){
                        System.out.println(e);
                        }
                
                }
            
            else if(ae.getSource() == clearButton){
                cardNo_textfield.setText("");
                pinNo_textfield.setText("");
            }
            else if(ae.getSource() == signupButton){
                    signupone buttonresponse = new signupone("");
                    setVisible(false);
            }
            else{
                setVisible(false);
            }
    }

    public static void main(String[] args) {
        new Login();
    }

}
