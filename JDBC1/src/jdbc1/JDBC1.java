/*
     * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sangram
 */
public class JDBC1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws Exception{
        
        try {
            String q ="Select * from name where id=2";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","");
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);
            res.next();
            String name = res.getString(2);
            System.out.println(name);
            
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        
        // TODO code application logic here
    }
    
}
