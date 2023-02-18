/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

/**
 *
 * @author sangram
 */
public class DynamicDatabaseInsert {

    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/table1", "root", "");

            if (con.isClosed()) {
                System.out.println("Connection Close....");
            } else {
                String query = "insert into user(LastName,FristName,Address,City) values(?,?,?,?)";
                PreparedStatement pstmt = con.prepareStatement(query);
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter the Last Name :");
                String lastName = br.readLine();
                
                System.out.println("Enter the Frist Name :");
                String fristName = br.readLine();
                
                System.out.println("Enter the Address Name");
                String usrAddress = br.readLine();
                System.out.println("Enter the City Name");
                String usrCity = br.readLine();
                
                
                pstmt.setString(1, lastName);
                pstmt.setString(2, fristName);
                pstmt.setString(3, usrAddress);
                pstmt.setString(4, usrCity);
                
                pstmt.executeUpdate();
                
                System.out.println("Success Full Dynamic  Insertdata....");
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
