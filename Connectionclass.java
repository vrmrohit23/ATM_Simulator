
package bank.management.system;


import java.sql.*;
            
public class  Connectionclass {
        static Statement s;
        static PreparedStatement p;
         Connection con;
       public Connectionclass(String a){
            try{
                con = DriverManager.getConnection("jdbc:mysql:///bankdatabase","root","Vermaji@8");
                s = con.createStatement();
                p = con.prepareStatement(a);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
           
       }
            
       
}
