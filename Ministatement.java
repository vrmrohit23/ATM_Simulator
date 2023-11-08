package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Ministatement extends JFrame {

    public Ministatement(String pin) {
        setLayout(null);
        setSize(400, 600);
        setLocation(30, 0);

        JLabel bankname = new JLabel("Indian Bank");
        bankname.setBounds(150, 20, 200, 20);
        bankname.setFont(new Font("System", Font.BOLD, 16));
        add(bankname);
        setVisible(true);

        JLabel statementtext = new JLabel("Bank Statements:");
        statementtext.setBounds(130, 50, 200, 20);
        statementtext.setFont(new Font("System", Font.BOLD, 15));
        add(statementtext);
        setVisible(true);

        JLabel cardtext = new JLabel("Card no. ");
        cardtext.setBounds(10, 120, 100, 20);
        cardtext.setFont(new Font("System", Font.BOLD, 14));
        add(cardtext);

        JLabel cardinfo = new JLabel();
        cardinfo.setBounds(75, 121, 150, 20);
        cardinfo.setFont(new Font("System", Font.BOLD, 12));
        add(cardinfo);

        JLabel statments = new JLabel();
        statments.setBounds(50, 200, 500, 100);
//            statments.setFont(new Font("System",Font.BOLD,15));
        add(statments);
        
         JLabel showbalance = new JLabel();
        showbalance.setBounds(50, 500, 300, 20);
        showbalance.setFont(new Font("System", Font.BOLD, 15));
        add(showbalance);
        setVisible(true);


        String query = "Select * from carddetails where Pin = '"+pin+"'";
        Connectionclass con = new Connectionclass(query);
        try {
            ResultSet set = con.s.executeQuery(query);
            while (set.next()) {

                cardinfo.setText(set.getString("cardno").substring(0, 4) + "XXXXXXXX" + set.getString("cardno").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

        try {
            query = "select * from statement where pin = '"+pin+"'";
            ResultSet set = con.s.executeQuery(query);
            while (set.next()) {
                statments.setText(statments.getText() + "<html>" + set.getString("date") + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + set.getString("type") + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + set.getString("amount") + "<br/><br/><html>");

            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        
       
            query = "Select * from statement where pin = '"+pin+"'";
            int balance = 0;
            try {
                ResultSet set = con.s.executeQuery(query);
                
                while (set.next()) {

                    if(set.getString("type").equalsIgnoreCase("deposit")) {
                        balance += Integer.parseInt(set.getString("amount"));
                    }
                    else{
                    balance -= Integer.parseInt(set.getString("amount"));
                    }
                }
               showbalance.setText("Your Current balance is :RS "+balance);
        }
        catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ministatement("");
    }

}
