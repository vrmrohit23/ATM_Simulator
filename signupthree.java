package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.sql.*;
public class signupthree extends JFrame implements ActionListener {

    String query;
    JComboBox cardchoice;
    JCheckBox atm, internetbank, mobilebank, chequebook, declartion;
    String formno;
    JButton previous, cancel, submit;

    signupthree(String f) {
        formno = f;
        System.out.println(f);
        setTitle("NEW APPLICATION FORM");
        setSize(850, 800);
        setLocation(350, 10);
        setLayout(null);
        Color cool = new Color(189, 237, 253);

        Color cool1 = new Color(30, 112, 213);

        Font label = new Font("Raleway", Font.BOLD, 18);
        Font field = new Font("Raleway", Font.PLAIN, 16);

        getContentPane().setBackground(cool);
        String input = "<html>**Note: Card Number and PIN is for <br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;visual purposes only.** </html>";
        JLabel readingtop = new JLabel(input);
        readingtop.setFont(new Font("Raleway", Font.BOLD, 12));
        readingtop.setBounds(15, 20, 400, 40);
        add(readingtop);

        JLabel formno3 = new JLabel("Application No. " + f);
        formno3.setFont(new Font("Raleway", Font.PLAIN, 35));
        formno3.setForeground(cool1);
        formno3.setBounds(270, 20, 400, 40);
        add(formno3);

        JLabel additionaldetails = new JLabel("Page 3: Services Details");
        additionaldetails.setFont(new Font("Raleway", Font.ROMAN_BASELINE, 20));
        additionaldetails.setBounds(300, 120, 400, 25);
        add(additionaldetails);

        JLabel card = new JLabel("Card Number:");
        card.setFont(label);
        card.setBounds(150, 200, 200, 23);
        add(card);

        JLabel cardno = new JLabel("XXXX-XXXX-XXXX-5555");
        cardno.setFont(label);
        cardno.setBounds(440, 200, 300, 23);
        add(cardno);

        JLabel carddetails = new JLabel("(Your 16 digit Card No.)");
        carddetails.setBounds(150, 220, 300, 23);
        add(carddetails);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(label);
        pin.setBounds(150, 280, 300, 23);
        add(pin);

        JLabel pinno = new JLabel("XXXX");
        pinno.setFont(label);
        pinno.setBounds(440, 280, 300, 23);
        add(pinno);

        JLabel pindetail = new JLabel("(Your 4 digit Pin no.)");
        pindetail.setBounds(150, 300, 300, 23);
        add(pindetail);

        JLabel services = new JLabel("Services Required:");
        services.setFont(label);
        services.setBounds(150, 360, 300, 23);
        add(services);

        atm = new JCheckBox("ATM Card");
        atm.setFont(field);
        atm.setBackground(Color.WHITE);
        atm.setBounds(170, 400, 100, 23);
        add(atm);

        internetbank = new JCheckBox("Internet Banking");
        internetbank.setFont(field);
        internetbank.setBackground(Color.WHITE);
        internetbank.setBounds(170, 440, 150, 23);
        add(internetbank);

        mobilebank = new JCheckBox("Mobile Banking");
        mobilebank.setFont(field);
        mobilebank.setBackground(Color.WHITE);
        mobilebank.setBounds(440, 400, 150, 23);
        add(mobilebank);

        chequebook = new JCheckBox("Cheque Book");
        chequebook.setFont(field);
        chequebook.setBackground(Color.WHITE);
        chequebook.setBounds(440, 440, 150, 23);
        add(chequebook);

        JLabel Cardtype = new JLabel("Debit Card Type:");
        Cardtype.setFont(label);
        Cardtype.setBounds(150, 500, 300, 23);
        add(Cardtype);
        Cardtype.setVisible(true);

        String[] cards = {"", "Visa Platinium", "Visa Diamond", "Visa Gold", "Rupay Platinium", "Rupay Classic"};
        cardchoice = new JComboBox<>(cards);
        cardchoice.setBounds(440, 500, 200, 28);
        cardchoice.setFont(field);
        add(cardchoice);
        cardchoice.setVisible(true);

        declartion = new JCheckBox("I hereby declare that all the information entered is correct to the best of my knowledge.");
        declartion.setFont(new Font("Raleway", Font.BOLD, 14));
        declartion.setBackground(Color.WHITE);
        declartion.setBounds(100, 600, 635, 20);
        add(declartion);

        previous = new JButton("Previous");
        previous.setFont(new Font("Raleway", Font.BOLD, 22));
        previous.setBackground(cool1);
        previous.setForeground(Color.white);
        previous.setBounds(330, 700, 150, 30);
        previous.addActionListener(this);
        add(previous);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 22));
        cancel.setBackground(cool1);
        cancel.setForeground(Color.white);
        cancel.setBounds(490, 700, 150, 30);
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 22));
        submit.setBackground(cool1);
        submit.setForeground(Color.white);
        submit.setBounds(650, 700, 150, 30);
        submit.addActionListener(this);
        add(submit);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cancel) {
            try {
                query = "Delete from signupone where formno=?";
                Connectionclass con = new Connectionclass(query);
                con.p.setString(1, formno);
                con.p.executeUpdate();
                query = "Delete from signuptwo where formno=?";
                Connectionclass con1 = new Connectionclass(query);
                con1.p.setString(1, formno);
                con.p.executeUpdate();
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == previous) {
            setVisible(false);
            
            try {
                
                 signuptwo s = new signuptwo(formno);
                        query = "Select * from signuptwo where formno =?";
                       
                        Connectionclass con1 = new Connectionclass(query);
                        con1.p.setString(1,formno);
                        ResultSet set = con1.p.executeQuery();
                        if(set.next()){
                            String[] details = new String[15] ;
                       details [0] = set.getString(2);
                       details [1] = set.getString(3);
                       details [2] = set.getString(4);
                       details [3] = set.getString(5);
                       details [4] = set.getString(6);
                       details [5] = set.getString(7);
                       details [6] = set.getString(8);
                       details [7] = set.getString(9);
                       details [8] = set.getString(10);
                      details [9] = set.getString(11);
                       
                        
                       signuptwo.methodone(details);
                        }
                        else{
                            System.out.println("something went wrong");
                        }
                
                query = "Delete from signuptwo where formno=?";
                Connectionclass con = new Connectionclass(query);
                con.p.setString(1, formno);
                con.p.executeUpdate();
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == submit) {
            String form = formno;

            Random rand = new Random();
            String cardno = "" + Math.abs((rand.nextLong() % 90000000) + 5040936000000000L);
            long pinl = 0;
            while(pinl <1000){
               pinl = Math.abs((rand.nextLong() % 9000L) + 1000L);
            }
            String pin = ""+pinl;
            System.out.println(pin);
            String atmst = "NO";
            if (atm.isSelected()) {
                atmst = "Yes";
            } else {
            }

            String internetb = "No";
            if (internetbank.isSelected()) {
                internetb = "Yes";
            } else {
            }

            String mobileb = "No";
            if (mobilebank.isSelected()) {
                mobileb = "Yes";
            } else {
            }

            String chequeb = "No";
            if (chequebook.isSelected()) {
                chequeb = "Yes";
            } else {
            }
            String card = (String) cardchoice.getSelectedItem();
            String declared = "";
            if (declartion.isSelected()) {
                declared = "Yes";
            } else {

            }
            if (atmst.equalsIgnoreCase("yes")) {
                if (!card.equalsIgnoreCase("")) {
                    if (declared.equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Please check the declartion box");
                    } else {
                        try {
                            query = "Insert into signupthree Values('" + formno + "','" + cardno + "','" + pin + "','" + atmst + "','" + internetb + "','" + mobileb + "','" + chequeb + "','" + card + "')";
                            Connectionclass con = new Connectionclass(query);
                            con.s.executeUpdate(query);
                            
                            
                            query = "Insert into carddetails Values('" + formno + "','" + cardno + "','" + pin + "')";
                            con.s.executeUpdate(query);
                            
                            JOptionPane.showMessageDialog(null, "Your Card Number: "+cardno+"\nYour PIN: "+pin);
                            this.setVisible(false);
                            new Login();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Card Type cannot be empty");
                }
            } else {
                if (card.equalsIgnoreCase("")) {
                    if (declared.equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(null, "Please check the declartion box");
                    } else {
                        try {
                            query = "Insert into signupthree Values('" + formno + "','" + cardno + "','" + pin + "','" + atmst + "','" + internetb + "','" + mobileb + "','" + chequeb + "','" + card + "')";
                            Connectionclass con = new Connectionclass(query);
                            con.s.executeUpdate(query);
                            
                            query = "Insert into carddetails Values('" + formno + "','" + cardno + "','" + pin + "')";
                            con.s.executeUpdate(query);
                            
                            JOptionPane.showMessageDialog(null, "Your Card Number: "+cardno+"\nYour PIN: "+pin);
                            this.setVisible(false);
                            new Login();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ATM is not checked");
                }

            }

//               
        }
        else{
            
        }

    }

    public static void main(String[] args) {
        new signupthree("");

    }

}
