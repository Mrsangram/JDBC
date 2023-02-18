/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc1;

import java.sql.*;
import java.sql.DriverManager;

/**
 *
 * @author sangram
 */
public class InsherDatabaseUsingPreparedstatements {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/table1";
            String usr = "root";
            String pass = "";
            Connection con = DriverManager.getConnection(url, usr, pass);
            if(con.isClosed()){
                System.out.println("Not Insert Database.. please Try Again");
            }
            else{
                
                String query = "insert into user(LastName,FristName,Address,City) values(?,?,?,?)";
                
                //Prepared Statements in quary 
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1,"HACKER");
                pstmt.setString(2,"SANGRAM");
                pstmt.setString(3,"Vill MAHARAJGANJ MAHRAJGANJ");
                pstmt.setString(4,"MHARAJGANJ");
                
                pstmt.executeUpdate();
                System.out.println("Insert Database SuccessFull..");
            }

        } catch (Exception e) {
            
            e.printStackTrace();
        }

    }

}
