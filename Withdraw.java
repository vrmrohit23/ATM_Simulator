
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import javax.swing.JLabel;
import java.sql.*;


public class Withdraw extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw,back;
    String pin ;
    Withdraw(String pin){
        this.pin = pin;
        setLayout(null);
        setSize(900, 850);
        setLocation(300, 0);
        Color cool = new Color(145, 153, 255);
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("required files/atm.jpg"));
        Image itemp = ic.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon ics = new ImageIcon(itemp);
        JLabel im = new JLabel(ics);
        im.setBounds(0, 0, 900, 850);
        im.setVisible(true);
        add(im);
        
        
        JLabel toptext = new JLabel("Enter the amount you wanna Withdraw");
        toptext.setBounds(215, 300, 300, 20);
        toptext.setForeground(Color.white);
        toptext.setFont(new Font("Calibari", Font.PLAIN, 15));
        im.add(toptext);
        
        amount = new JTextField();
        amount.setBounds(200, 350, 270, 30);
        amount.setFont(new Font("Raleway", Font.BOLD, 20));
        amount.setBackground(Color.WHITE);
        im.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(345, 461, 155, 23);
        withdraw.setBackground(cool);
        withdraw.setForeground(Color.BLACK);
        withdraw.setFont(new Font("Calibari", Font.PLAIN, 16));
        withdraw.addActionListener(this);
        im.add(withdraw);
//
//        cashw = new JButton("Cash Withdrawl");
//        cashw.setBounds(345, 395, 155, 23);
//        cashw.setBackground(cool);
//        cashw.setForeground(Color.BLACK);
//        cashw.setFont(new Font("Calibari", Font.PLAIN, 16));
//        im.add(cashw);
//
//        fastc = new JButton("Fast Cash");
//        fastc.setBounds(170, 428, 155, 23);
//        fastc.setBackground(cool);
//        fastc.setForeground(Color.BLACK);
//        fastc.setFont(new Font("Calibari", Font.PLAIN, 16));
//        im.add(fastc);
//
//        minis = new JButton("Mini Statement");
//        minis.setBounds(345, 428, 155, 23);
//        minis.setBackground(cool);
//        minis.setForeground(Color.BLACK);
//        minis.setFont(new Font("Calibari", Font.PLAIN, 16));
//        im.add(minis);
//
//        pinc = new JButton("Pin Change");
//        pinc.setBounds(170, 461, 155, 23);
//        pinc.setBackground(cool);
//        pinc.setForeground(Color.BLACK);
//        pinc.setFont(new Font("Calibari", Font.PLAIN, 16));
//        im.add(pinc);
//
//        bale = new JButton("Balance Enquiry");
//        bale.setBounds(345, 461, 155, 23);
//        bale.setBackground(cool);
//        bale.setForeground(Color.BLACK);
//        bale.setFont(new Font("Calibari", Font.PLAIN, 16));
//        im.add(bale);
//        
        back = new JButton("Back");
        back.setBounds(345, 494, 155, 23);
        back.setBackground(cool);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Calibari", Font.PLAIN, 16));
        back.addActionListener(this);
        im.add(back);
        
        
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            new Transactions(pin);
            setVisible(false);
        }
        else if(ae.getSource() == withdraw){
            String depo = amount.getText();
            Date date = new Date();
            if(depo.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you wanna Withdraw");
            }
            else{
                 String amount = ((JButton)ae.getSource()).getText().substring(3);
            String query = "Select * from statement where pin = '"+pin+"'";
            Connectionclass con = new Connectionclass(query);
            int balance = 0;
            try{
            ResultSet set = con.s.executeQuery(query);
            
            while(set.next()){
                
                if(set.getString("type").equalsIgnoreCase("deposit")){
                    balance += Integer.parseInt(set.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(set.getString("amount"));
                }
            }
            }
            catch(Exception e){
                    e.printStackTrace();
                    }
            if(balance<Integer.parseInt(depo)){
                JOptionPane.showMessageDialog(null, "Insufficient Balance in account");
                return;
            }
            else{
             query = "Insert into statement values('"+pin+"','"+date+"','Withdrawl','"+depo+"')";
                try{
                
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "RS "+depo+" Withdrawl successfully");
                new Login();
                    setVisible(false);
                }
                catch(Exception e){
                    System.out.println(e);
                    e.printStackTrace();
                }
            }
            }
        }
    }
    public static void main(String[] args) {
        new Withdraw("");
    }
 }
    

