/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sangram
 */
public class connectionTest {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1", "root", "");
            
            if(con.isClosed()){
                System.out.println("Connection Close...");
            }
            else{
                System.out.println("Connection...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
