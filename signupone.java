
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class signupone extends JFrame implements ActionListener {
         
         
          int random;
        JButton next;
        static JTextField namefield ,fnamefield,mnamefield,addressfield,pincodefield,cityfield,statefield,phonefield,emailfield;
        static JDateChooser dobcalender;
        static ButtonGroup jb,bg;
        static JRadioButton male,female,other,single,married,marriageother;

  
       
        signupone(String st){
            setTitle("NEW APPLICATION FORM");
            setSize(850, 830);
            setLocation(350, 0);
            setLayout(null);
            Color cool = new Color(189,237,253);
                    
            Color cool1 = new Color(30,112,213);
            
            Font label = new Font("Raleway",Font.BOLD,18);
            Font field = new Font("Raleway",Font.PLAIN,16);
           
            getContentPane().setBackground(cool);
            Random rand = new Random();
            
            int used = rand.nextInt(10000);
              random = used+1;
             if(!st.equalsIgnoreCase("")){
                 random = Integer.parseInt(st);
             }
             else{
                 random = used+1;
             }
           
            JLabel formno = new JLabel("Application No. "+random);
            formno.setFont(new Font("Raleway",Font.PLAIN,35));
            formno.setForeground(cool1);
            formno.setBounds(270, 20,400 , 40);
            add(formno);
            
            JLabel details = new JLabel("Page 1: Personal Details");
            details.setFont(new Font("Raleway",Font.ROMAN_BASELINE,20));
            details.setBounds(300, 75,400 , 25);
            add(details);
            
            
            JLabel name = new JLabel("Name:");
            name.setFont(label);
            name.setBounds(200, 140,200 , 23);
            add(name);
            
            namefield = new JTextField("<html>");
            namefield.setFont(field);
            namefield.setBounds(400, 140, 250, 23);
            
            add(namefield);
            
            JLabel mname = new JLabel("Mother's Name:");
            mname.setFont(label);
            mname.setBounds(200, 180,200 , 23);
            add(mname);
            
            mnamefield = new JTextField();
            mnamefield.setFont(field);
            mnamefield.setBounds(400, 180, 250, 23);
            add(mnamefield);
            
            
            JLabel fname = new JLabel("Father's Name:");
            fname.setFont(label);
            fname.setBounds(200, 220,200 , 23);
            add(fname);
            
            fnamefield = new JTextField();
            fnamefield.setFont(field);
            fnamefield.setBounds(400, 220, 250, 23);
            add(fnamefield);
            
            JLabel dob = new JLabel("Date of Birth:");
            dob.setFont(label);
            dob.setBounds(200, 260,200 , 23);
            add(dob);
            
            dobcalender = new JDateChooser();
            dobcalender.setBounds(400, 260, 150, 23);
            add(dobcalender);
            
            JLabel gender = new JLabel("Gender:");
            gender.setFont(label);
            gender.setBounds(200, 300,200 , 23);
            add(gender);
            
            male = new JRadioButton("Male");
            male.setFont(field);
            male.setBackground(Color.white);
            male.setBounds(400, 300, 87, 23);
            add(male);
            
            female = new JRadioButton("Female");
            female.setFont(field);
            female.setBackground(Color.white);
            female.setBounds(483, 300, 87, 23);
            add(female);
            
            other = new JRadioButton("Other");
            other.setFont(field);
            other.setBackground(Color.white);
            other.setBounds(570, 300, 80, 23);
            add(other);
            
            bg = new ButtonGroup();
            bg.add(male);
            bg.add(female);
            bg.add(other);
            
            JLabel marital = new JLabel("Marital Status:");
            marital.setFont(label);
            marital.setBounds(200, 340,200 , 23);
            add(marital);
            
            single = new JRadioButton("Single");
            single.setFont(field);
            single.setBackground(Color.WHITE);
            single.setBounds(400, 340, 83, 23);
            add(single);
            
            married = new JRadioButton("Married");
            married.setFont(field);
            married.setBackground(Color.WHITE);
            married.setBounds(483, 340, 87, 23);
            add(married);
            
            marriageother = new JRadioButton("Other");
            marriageother.setFont(field);
            marriageother.setBackground(Color.WHITE);
            marriageother.setBounds(570, 340, 80, 23);
            add(marriageother);
            
            jb = new ButtonGroup();
            jb.add(single);
            jb.add(married);
            jb.add(marriageother);
            
            JLabel address = new JLabel("Home Address:");
            address.setFont(label);
            address.setBounds(200, 380,200 , 23);
            add(address);
            
            addressfield = new JTextField();
            addressfield.setFont(field);
            addressfield.setBounds(400, 380, 250, 23);
            add(addressfield);
            
            
            JLabel pincode = new JLabel("Pincode:");
            pincode.setFont(label);
            pincode.setBounds(200, 420,200 , 23);
            add(pincode);
            
            pincodefield = new JTextField();
            pincodefield.setFont(field);
            pincodefield.setBounds(400, 420, 250, 23);
            add(pincodefield);
            
            JLabel city = new JLabel("City:");
            city.setFont(label);
            city.setBounds(200, 460,200 , 23);
            add(city);
            
            cityfield = new JTextField();
            cityfield.setFont(field);
            cityfield.setBounds(400, 460, 250, 23);
            add(cityfield);
            
            JLabel state = new JLabel("State:");
            state.setFont(label);
            state.setBounds(200, 500,200 , 23);
            add(state);
            
            statefield = new JTextField();
            statefield.setFont(field);
            statefield.setBounds(400, 500, 250, 23);
            add(statefield);
            
            JLabel phone = new JLabel("Phone no:");
            phone.setFont(label);
            phone.setBounds(200, 540,200 , 23);
            add(phone);
            
            phonefield = new JTextField();
            phonefield.setFont(field);
            phonefield.setBounds(400, 540, 250, 23);
            add(phonefield);
            
            JLabel email = new JLabel("Email Address:");
            email.setFont(label);
            email.setBounds(200, 580,200 , 23);
            add(email);
            
            emailfield = new JTextField();
            emailfield.setFont(field);
            emailfield.setBounds(400, 580, 250, 23);
            add(emailfield);
            
            next = new JButton("Next");
            next.setFont(new Font("Raleway",Font.BOLD,22));
            next.setBackground(cool1);
            next.setForeground(Color.white);
            next.setBounds(650, 700, 150, 30);
            next.addActionListener(this);
            add(next);
            
            
            setVisible(true);
        }
        public void actionPerformed(ActionEvent ae){
                String formno = ""+random;
                
                String name = namefield.getText();
                String mname = mnamefield.getText();
                
                String fname = fnamefield.getText();
                String dob = ((JTextField)dobcalender.getDateEditor().getUiComponent()).getText();
                String gender = null;
                if(male.isSelected()){
                    gender = "Male";
                }
                else if(female.isSelected()){
                    gender = "Female";
                }
                else if(other.isSelected()){
                    gender = "Other";
                }
                String marital = null;
                if(single.isSelected()){
                    marital = "Single";
                }
                else if(married.isSelected()){
                    marital = "Married";
                }
                else if(other.isSelected()){
                    marital = "Other";
                }
                String address = addressfield.getText();
                String pincode = pincodefield.getText();
                String city = cityfield.getText();
                String state = statefield.getText();
                String phone = phonefield.getText();
                String email = emailfield.getText();
                try{
                    if(name.equals("")||mname.equals("")||fname.equals("")||dob.equals("")||marital.equals("")||address.equals("")|| pincode.equals("")||phone.equals("")||email.equals("")||gender.equals("")){
                        JOptionPane.showMessageDialog(null,"Please fill all the enteries properly");
                        
                       }
                    else{
                           
                           String query = "insert into signupone values('"+formno+"','"+name+"','"+mname+"','"+fname+"','"+dob+"','"+gender+"','"+marital+"','"+address+"','"+pincode+"','"+city+"','"+state+"','"+phone+"','"+email+"')";
                           Connectionclass con = new Connectionclass(query);
                           con.s.executeUpdate(query);
                           signuptwo sign = new signuptwo(formno);
                           setVisible(false);
                           
                    }
                    }
                catch(Exception e){
                    e.printStackTrace();
            }
               
            
        }
        
        public static void methodone(String[] ab ){
            try{
            namefield.setText(ab[0]);
            mnamefield.setText(ab[1]);
            fnamefield.setText(ab[2]);
            Date date = new SimpleDateFormat("dd-MMM-yyyy").parse(ab[3]);
            dobcalender.setDate(date);
            if(ab[4].equalsIgnoreCase("male")){
                bg.setSelected(male.getModel(), true);
            }
            else if(ab[4].equalsIgnoreCase("female")){
                bg.setSelected(female.getModel(), true);
            }
            else if(ab[4].equalsIgnoreCase("other")){
                bg.setSelected(other.getModel(), true);
            }
            else{
                
            }
            
            if(ab[5].equalsIgnoreCase("single")){
                jb.setSelected(single.getModel(), true);
            }
            else if(ab[5].equalsIgnoreCase("married")){
                jb.setSelected(married.getModel(), true);
            }
            else if(ab[5].equalsIgnoreCase("other")){
                jb.setSelected(marriageother.getModel(), true);
            }
            addressfield.setText(ab[6]);
            pincodefield.setText(ab[7]);
            cityfield.setText(ab[8]);
            statefield.setText(ab[9]);
            phonefield.setText(ab[10]);
            emailfield.setText(ab[11]);
           
        }
            catch(Exception e){
                System.out.println(e);
                e.printStackTrace();
            }
        }
//      
      
         
    public static void main(String[] args) {
        signupone so = new signupone("");
        
    }
}
