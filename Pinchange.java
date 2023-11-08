package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener {

    JTextField newpinfield, confirmpinfield;
    JButton change, back;
    String pin;

    Pinchange(String pinnumber) {
        pin = pinnumber;
        setSize(900, 850);
        setLocation(300, 0);
        setLayout(null);
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("required files/atm.jpg"));
        Image ime = im.getImage().getScaledInstance(900, 850, Image.SCALE_DEFAULT);
        ImageIcon imn = new ImageIcon(ime);
        JLabel image = new JLabel(imn);
        image.setBounds(0, 30, 900, 850);
        add(image);

        Color cool = new Color(145, 153, 255);

        JLabel text = new JLabel("Change Your PIN");
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(270, 300, 300, 20);
        image.add(text);

        JLabel newpin = new JLabel("New PIN:");
        newpin.setFont(new Font("Raleway", Font.BOLD, 16));
        newpin.setForeground(Color.WHITE);
        newpin.setBounds(170, 350, 155, 23);
        image.add(newpin);

        newpinfield = new JTextField();
        newpinfield.setFont(new Font("Raleway", Font.BOLD, 16));
        newpinfield.setBackground(Color.white);
        newpinfield.setBounds(345, 350, 155, 23);
        image.add(newpinfield);

        JLabel confirmpin = new JLabel("Confirm PIN:");
        confirmpin.setFont(new Font("Raleway", Font.BOLD, 16));
        confirmpin.setForeground(Color.WHITE);
        confirmpin.setBounds(170, 380, 155, 23);
        image.add(confirmpin);

        confirmpinfield = new JTextField();
        confirmpinfield.setFont(new Font("Raleway", Font.BOLD, 16));
        confirmpinfield.setBackground(Color.white);
        confirmpinfield.setBounds(345, 380, 155, 23);
        image.add(confirmpinfield);

        change = new JButton("Change");
        change.setBounds(400, 450, 110, 23);
        change.setBackground(cool);
        change.setFont(new Font("Calibari", Font.BOLD, 18));
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(400, 480, 110, 23);
        back.setBackground(cool);
        back.setFont(new Font("Calibari", Font.BOLD, 18));
        back.addActionListener(this);
        image.add(back);

        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String npin = newpinfield.getText();
        String cpin = confirmpinfield.getText();
        if (ae.getSource() == change) {
            try {
                if (!cpin.equals(npin)) {
                    JOptionPane.showMessageDialog(null, "Pins Does not Match");
                    return;
                }

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Pin cannot be empty");
                    return;
                }
                if (npin.length() > 4 || npin.length() < 4) {
                    JOptionPane.showMessageDialog(null, "Pin must be of 4 digits");
                    return;
                }

                String query = "Update statement set pin = '" + npin + "' where pin ='" + pin + "'";
                String query1 = "Update signupthree set pin = '" + npin + "' where pin ='" + pin + "'";
                String query2 = "Update carddetails set pin = '" + npin + "' where pin ='" + pin + "'";
                Connectionclass con = new Connectionclass(query);
                con.s.executeUpdate(query);
                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "PIN changed Successfully");
                setVisible(false);
                new Login();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
            new Transactions(pin);
        }

    }

    public static void main(String[] args) {
        new Pinchange("");
    }
}
