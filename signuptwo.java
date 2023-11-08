package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class signuptwo extends JFrame implements ActionListener {

    

    String query;
    Connection con;
    String formno ;
    static JButton next, previous;
    static JTextField panfield, aadharfield;
    static JComboBox religionbox, categorybox, incomebox, educationbox, occubox, accbox;
    static ButtonGroup bg,gb;
    static JRadioButton yes, no, yesacc, noacc;
    
    signuptwo(String random) {
        this.formno = random;
        
        setTitle("NEW APPLICATION FORM");
        setSize(850, 830);
        setLocation(350, 0);
        setLayout(null);
        Color cool = new Color(189, 237, 253);

        Color cool1 = new Color(30, 112, 213);

        Font label = new Font("Raleway", Font.BOLD, 18);
        Font field = new Font("Raleway", Font.PLAIN, 16);

        getContentPane().setBackground(cool);

        JLabel applicatonno = new JLabel("Application No. " + formno);
        applicatonno.setFont(new Font("Raleway", Font.PLAIN, 35));
        applicatonno.setForeground(cool1);
        applicatonno.setBounds(270, 20, 400, 40);
        add(applicatonno);

        JLabel additionaldetails = new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway", Font.ROMAN_BASELINE, 20));
        additionaldetails.setBounds(300, 75, 400, 25);
        add(additionaldetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(label);
        religion.setBounds(150, 140, 200, 23);
        add(religion);

        String[] relig = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionbox = new JComboBox(relig);
        religionbox.setFont(field);
        religionbox.setBackground(Color.white);
        religionbox.setBounds(440, 140, 250, 23);
        add(religionbox);

        JLabel category = new JLabel("Category:");
        category.setFont(label);
        category.setBounds(150, 180, 200, 23);
        add(category);

        String[] cate = {"General", "SC", "ST", "OBC", "EWD", "Other"};
        categorybox = new JComboBox(cate);
        categorybox.setFont(field);
        categorybox.setBackground(Color.white);
        categorybox.setBounds(440, 180, 250, 23);
        add(categorybox);

        JLabel income = new JLabel("Annual Income:");
        income.setFont(label);
        income.setBounds(150, 220, 200, 23);
        add(income);

        String[] inco = {"Null", "Under 99,999 Rs", "1,00,000-2,49,999 Rs", "2,50,000-4,99,999 Rs", "5,00,000-9,99,999 Rs", "Above 10,00,000 Rs"};
        incomebox = new JComboBox(inco);
        incomebox.setFont(field);
        incomebox.setBackground(Color.white);
        incomebox.setBounds(440, 220, 250, 23);
        add(incomebox);

        JLabel qual = new JLabel("Educational Qualification:");
        qual.setFont(label);
        qual.setBounds(150, 260, 250, 23);
        add(qual);

        String[] edu = {"Matric", "Intermediate", "Graduate", "Post-Graduate", "Doctarate", "Other"};
        educationbox = new JComboBox(edu);
        educationbox.setFont(field);
        educationbox.setBackground(Color.white);
        educationbox.setBounds(440, 260, 250, 23);
        add(educationbox);

        JLabel occu = new JLabel("Occupation:");
        occu.setFont(label);
        occu.setBounds(150, 300, 200, 23);
        add(occu);

        String[] ocu = {"Student", "Self-Employed", "Salaried", "Business", "Retired", "Other"};
        occubox = new JComboBox(ocu);
        occubox.setFont(field);
        occubox.setBackground(Color.white);
        occubox.setBounds(440, 300, 250, 23);
        add(occubox);

        JLabel pan = new JLabel("PAN No:");
        pan.setFont(label);
        pan.setBounds(150, 340, 200, 23);
        add(pan);

        panfield = new JTextField();
        panfield.setFont(field);
        panfield.setBounds(440, 340, 250, 23);
        add(panfield);

        JLabel aadhar = new JLabel("Aadhar No:");
        aadhar.setFont(label);
        aadhar.setBounds(150, 380, 200, 23);
        add(aadhar);

        aadharfield = new JTextField();
        aadharfield.setFont(field);
        aadharfield.setBounds(440, 380, 250, 23);
        add(aadharfield);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(label);
        senior.setBounds(150, 420, 200, 23);
        add(senior);

        yes = new JRadioButton("Yes");
        yes.setFont(field);
        yes.setBackground(Color.white);
        yes.setBounds(440, 420, 100, 23);
        add(yes);

        no = new JRadioButton("No");
        no.setFont(field);
        no.setBackground(Color.white);
        no.setBounds(590, 420, 100, 23);
        add(no);

         bg = new ButtonGroup();
        bg.add(yes);
        bg.add(no);

        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(label);
        existing.setBounds(150, 460, 200, 23);
        add(existing);

        yesacc = new JRadioButton("Yes");
        yesacc.setFont(field);
        yesacc.setBackground(Color.white);
        yesacc.setBounds(440, 460, 100, 23);
        add(yesacc);

        noacc = new JRadioButton("No");
        noacc.setFont(field);
        noacc.setBackground(Color.white);
        noacc.setBounds(590, 460, 100, 23);
        add(noacc);

         gb = new ButtonGroup();
        gb.add(yesacc);
        gb.add(noacc);

        JLabel account = new JLabel("Account Type:");
        account.setFont(label);
        account.setBounds(150, 500, 200, 23);
        add(account);

        String[] acctype = {"Savings", "Current", "Salary", "Fixed Deposit", "Recurring Deposit"};
        accbox = new JComboBox(acctype);
        accbox.setFont(field);
        accbox.setBackground(Color.white);
        accbox.setBounds(440, 500, 250, 28);
        add(accbox);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 22));
        next.setBackground(cool1);
        next.setForeground(Color.white);
        next.setBounds(650, 700, 150, 30);
        next.addActionListener(this);
        add(next);

        previous = new JButton("Previous");
        previous.setFont(new Font("Raleway", Font.BOLD, 22));
        previous.setBackground(cool1);
        previous.setForeground(Color.white);
        previous.setBounds(480, 700, 150, 30);
        previous.addActionListener(this);
        add(previous);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String religion = (String) religionbox.getSelectedItem();

            String category = (String) categorybox.getSelectedItem();

            String income = (String) incomebox.getSelectedItem();

            String education = (String) educationbox.getSelectedItem();

            String occupation = (String) occubox.getSelectedItem();

            String pan = panfield.getText();

            String aadhar = aadharfield.getText();

            String senior = null;
            if (yes.isSelected()) {
                senior = "Yes";
            } else if (no.isSelected()) {
                senior = "No";
            }

            String eaccount = null;
            if (yesacc.isSelected()) {
                eaccount = "Yes";
            } else if (noacc.isSelected()) {
                eaccount = "No";
            }

            String account = (String) accbox.getSelectedItem();

            try {
                if (religion.equals("") || category.equals("") || income.equals("") || education.equals("") || occupation.equals("") || pan.equals("") || aadhar.equals("") || eaccount.equals("") || account.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the enteries properly");
                } else {

                    query = "insert into signuptwo values('" + formno + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + pan + "','" + aadhar + "','" + senior + "','" + eaccount + "','" + account + "')";
                    Connectionclass con = new Connectionclass(query);
                    con.s.executeUpdate(query);
                    signupthree s = new signupthree(formno);
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == previous) {
            setVisible(false);
            try {
                  signupone s = new signupone(formno);
                        query = "Select * from signupone where formno =?";
                       
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
                       details [10] = set.getString(12);
                       details [11] = set.getString(13);
                        
                       signupone.methodone(details);
                        }
                        else{
                            System.out.println("something went wrong");
                        }
                      
            
                query = "Delete from signupone where formno=?";
                Connectionclass con = new Connectionclass(query);
                con.p.setString(1, formno);
                con.p.executeUpdate();
            }
                     
                        catch(Exception e){
                                e.printStackTrace();
                                }
//                        
//                        
//                   
//                    
        }
        
    }
    
    static void methodone(String[] ab) {
        if(ab[0].equalsIgnoreCase("Hindu")){
        religionbox.getModel().setSelectedItem("Hindu");
        }
        else if(ab[0].equalsIgnoreCase("Muslim")){
            religionbox.getModel().setSelectedItem("Muslim");
        }
        
        else if(ab[0].equalsIgnoreCase("Sikh")){
            religionbox.getModel().setSelectedItem("Sikh");
        }
        
        else if(ab[0].equalsIgnoreCase("Christian")){
            religionbox.getModel().setSelectedItem("Christian");
        }
        
        else if(ab[0].equalsIgnoreCase("Other")){
            religionbox.getModel().setSelectedItem("Other");
        }
        else{
            
        }
        if(ab[1].equalsIgnoreCase("General")){
        categorybox.getModel().setSelectedItem("General");
        }
        else if(ab[1].equalsIgnoreCase("SC")){
            categorybox.getModel().setSelectedItem("SC");
        }
        
        else if(ab[1].equalsIgnoreCase("ST")){
            categorybox.getModel().setSelectedItem("ST");
        }
        
        else if(ab[1].equalsIgnoreCase("EWD")){
            categorybox.getModel().setSelectedItem("EWD");
        }
        
        else if(ab[1].equalsIgnoreCase("Other")){
            categorybox.getModel().setSelectedItem("Other");
        }
        else{
            
        }
        
        if(ab[2].equalsIgnoreCase("")){
            incomebox.getModel().setSelectedItem("");
        }
        else if(ab[2].equalsIgnoreCase("Under 99,999 Rs")){
            incomebox.getModel().setSelectedItem("Under 99,999 Rs");
        }
        
        else if(ab[2].equalsIgnoreCase("1,00,000-2,49,999 Rs")){
            incomebox.getModel().setSelectedItem("1,00,000-2,49,999 Rs");
        }
        
        else if(ab[2].equalsIgnoreCase("2,50,000-4,99,999 Rs")){
            incomebox.getModel().setSelectedItem("2,50,000-4,99,999 Rs");
        }
        
        else if(ab[2].equalsIgnoreCase("5,00,000-9,99,999 Rs")){
            incomebox.getModel().setSelectedItem("5,00,000-9,99,999 Rs");
        }
        else if(ab[2].equalsIgnoreCase("Above 10,00,000 Rs")){
            incomebox.getModel().setSelectedItem("Above 10,00,000 Rs");
        }
        else{
            
        }
        
        if(ab[3].equalsIgnoreCase("Matric")){
            educationbox.getModel().setSelectedItem("Matric");
        }
        else if(ab[3].equalsIgnoreCase("Intermediate")){
            educationbox.getModel().setSelectedItem("Intermediate");
        }
        
        else if(ab[3].equalsIgnoreCase("Graduate")){
            educationbox.getModel().setSelectedItem("Graduate");
        }
        
        else if(ab[3].equalsIgnoreCase("Post-Graduate")){
            educationbox.getModel().setSelectedItem("Post-Graduate");
        }
        
        else if(ab[3].equalsIgnoreCase("Doctarate")){
            educationbox.getModel().setSelectedItem("Doctarate");
        }
        else if(ab[3].equalsIgnoreCase("Other")){
            educationbox.getModel().setSelectedItem("Other");
        }
        else{
            
        }
        
        if(ab[4].equalsIgnoreCase("Student")){
            occubox.getModel().setSelectedItem("Student");
        }
        else if(ab[4].equalsIgnoreCase("Self-Employed")){
            occubox.getModel().setSelectedItem("Self-Employed");
        }
        
        else if(ab[4].equalsIgnoreCase("Salaried")){
            occubox.getModel().setSelectedItem("Salaried");
        }
        
        else if(ab[4].equalsIgnoreCase("Business")){
            occubox.getModel().setSelectedItem("Business");
        }
        
        else if(ab[4].equalsIgnoreCase("Retired")){
            occubox.getModel().setSelectedItem("Retired");
        }
        else if(ab[4].equalsIgnoreCase("Other")){
            occubox.getModel().setSelectedItem("Other");
        }
        else{
            
        }
        
        panfield.setText(ab[5]);
        aadharfield.setText(ab[6]);
        if(ab[7].equalsIgnoreCase("yes")){
            bg.setSelected(yes.getModel(), true);
        }
        else {
            bg.setSelected(no.getModel(), true);
        }
        
        if(ab[8].equalsIgnoreCase("yes")){
            gb.setSelected(yesacc.getModel(), true);
        }
        else{
            gb.setSelected(noacc.getModel(), true);
        }
        
           if(ab[9].equalsIgnoreCase("Savings")){
            occubox.getModel().setSelectedItem("Savings");
        }
        else if(ab[9].equalsIgnoreCase("Current")){
            occubox.getModel().setSelectedItem("Current");
        }
        
        else if(ab[9].equalsIgnoreCase("Salary")){
            occubox.getModel().setSelectedItem("Salary");
        }
        
        else if(ab[9].equalsIgnoreCase("Fixed Deposit")){
            occubox.getModel().setSelectedItem("Fixed Deposit");
        }
        
        else if(ab[9].equalsIgnoreCase("Recurring Deposit")){
            occubox.getModel().setSelectedItem("Recurring Deposit");
        }
        else if(ab[9].equalsIgnoreCase("Other")){
            occubox.getModel().setSelectedItem("Other");
        }
        else{
            
        }
    }

    public static void main(String[] args) {
        new signuptwo("");
    }
}
