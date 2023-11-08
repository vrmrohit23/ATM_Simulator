package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.sql.*;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author Rohit Vermaji
 */
public class Fastcash extends JFrame implements ActionListener {

    JButton rs100, rs500, rs1000, rs5000,rs2000 , exit;
    String pin;
    Fastcash(String pin) {
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

        JLabel toptext = new JLabel("Select the amount to Withdraw");
        toptext.setBounds(230, 300, 300, 20);
        toptext.setForeground(Color.white);
        toptext.setFont(new Font("Calibari", Font.PLAIN, 15));
        im.add(toptext);

        rs100 = new JButton("RS 100");
        rs100.setBounds(170, 395, 155, 23);
        rs100.setBackground(cool);
        rs100.setForeground(Color.BLACK);
        rs100.addActionListener(this);
        rs100.setFont(new Font("Calibari", Font.PLAIN, 16));
        im.add(rs100);

        rs500 = new JButton("Rs 500");
        rs500.setBounds(345, 395, 155, 23);
        rs500.setBackground(cool);
        rs500.setForeground(Color.BLACK);
        rs500.addActionListener(this);
        rs500.setFont(new Font("Calibari", Font.PLAIN, 16));
        im.add(rs500);

        rs1000 = new JButton("RS 1000");
        rs1000.setBounds(170, 428, 155, 23);
        rs1000.setBackground(cool);
        rs1000.setForeground(Color.BLACK);
        rs1000.addActionListener(this);
        rs1000.setFont(new Font("Calibari", Font.PLAIN, 16));
        im.add(rs1000);

        rs2000 = new JButton("RS 2000");
        rs2000.setBounds(345, 428, 155, 23);
        rs2000.setBackground(cool);
        rs2000.setForeground(Color.BLACK);
        rs2000.addActionListener(this);
        rs2000.setFont(new Font("Calibari", Font.PLAIN, 16));
        im.add(rs2000);

        rs5000 = new JButton("RS 5000");
        rs5000.setBounds(170, 461, 155, 23);
        rs5000.setBackground(cool);
        rs5000.setForeground(Color.BLACK);
        rs5000.addActionListener(this);
        rs5000.setFont(new Font("Calibari", Font.PLAIN, 16));
        im.add(rs5000);

        
        
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

    /**
     *
     * @param ae
     */
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pin);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            String query = "Select * from statement where pin = '"+pin+"'";
            Connectionclass con = new Connectionclass(query);
            try{
            ResultSet set = Connectionclass.s.executeQuery(query);
            int balance = 0;
            while(set.next()){
                
                if(set.getString("type").equalsIgnoreCase("deposit")){
                    balance += Integer.parseInt(set.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(set.getString("amount"));
                }
            }
            if(balance<Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null, "Insufficient Balance in account");
                return;
            }
            
            Date date = new Date();
            String query1 = "Insert into statement values('"+pin+"','"+date+"','Withdrawl','"+amount+"')";
            con.s.executeUpdate(query1);
            JOptionPane.showMessageDialog(null, "RS "+amount+" debited successfully");
                setVisible(false);
                new Login().setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
                e.printStackTrace();
            }
            
        }
            
        
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        new Fastcash("");
    }
}
