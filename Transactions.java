package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, cashw, fastc, minis, pinc, bale, exit;
    String pin;

    Transactions(String pin) {
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

        JLabel toptext = new JLabel("Please Select Your Transaction");
        toptext.setBounds(230, 300, 300, 20);
        toptext.setForeground(Color.white);
        toptext.setFont(new Font("Calibari", Font.PLAIN, 15));
        im.add(toptext);

        deposit = new JButton("Deposit");
        deposit.setBounds(170, 395, 155, 23);
        deposit.setBackground(cool);
        deposit.setForeground(Color.BLACK);
        deposit.addActionListener(this);
        deposit.setFont(new Font("Calibari", Font.PLAIN, 16));
        im.add(deposit);

        cashw = new JButton("Cash Withdrawl");
        cashw.setBounds(345, 395, 155, 23);
        cashw.setBackground(cool);
        cashw.setForeground(Color.BLACK);
        cashw.addActionListener(this);
        cashw.setFont(new Font("Calibari", Font.PLAIN, 16));
        im.add(cashw);

        fastc = new JButton("Fast Cash");
        fastc.setBounds(170, 428, 155, 23);
        fastc.setBackground(cool);
        fastc.setForeground(Color.BLACK);
        fastc.addActionListener(this);
        fastc.setFont(new Font("Calibari", Font.PLAIN, 16));
        im.add(fastc);

        minis = new JButton("Mini Statement");
        minis.setBounds(345, 428, 155, 23);
        minis.setBackground(cool);
        minis.setForeground(Color.BLACK);
        minis.addActionListener(this);
        minis.setFont(new Font("Calibari", Font.PLAIN, 16));
        im.add(minis);

        pinc = new JButton("Pin Change");
        pinc.setBounds(170, 461, 155, 23);
        pinc.setBackground(cool);
        pinc.setForeground(Color.BLACK);
        pinc.addActionListener(this);
        pinc.setFont(new Font("Calibari", Font.PLAIN, 16));
        im.add(pinc);

        bale = new JButton("Balance Enquiry");
        bale.setBounds(345, 461, 155, 23);
        bale.setBackground(cool);
        bale.setForeground(Color.BLACK);
        bale.addActionListener(this);
        bale.setFont(new Font("Calibari", Font.PLAIN, 16));
        im.add(bale);

        exit = new JButton("Exit");
        exit.setBounds(345, 494, 155, 23);
        exit.setBackground(cool);
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("Calibari", Font.PLAIN, 16));
        exit.addActionListener(this);
        im.add(exit);
 
        
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
//            new Login();
      
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pin);

        } else if (ae.getSource() == cashw) {
            setVisible(false);
            new Withdraw(pin);

        } else if (ae.getSource() == fastc) {
            setVisible(false);
            new Fastcash(pin);
        } else if (ae.getSource() == pinc) {
            setVisible(false);
            new Pinchange(pin);
        } else if (ae.getSource() == fastc) {
            setVisible(false);
            new Fastcash(pin);
        } else if(ae.getSource() == bale){
            String query = "Select * from statement where pin = '" + pin + "'";
            Connectionclass con = new Connectionclass(query);
            try {
                ResultSet set = con.s.executeQuery(query);
                int balance = 0;
                while (set.next()) {

                    if(set.getString("type").equalsIgnoreCase("deposit")) {
                        balance += Integer.parseInt(set.getString("amount"));
                    }
                    else{
                    balance -= Integer.parseInt(set.getString("amount"));
                    }
                }
                
                JOptionPane.showMessageDialog(null, "Your Current Balance is RS "+balance);
                
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }

        }
        else{
            new Ministatement(pin);
        }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
