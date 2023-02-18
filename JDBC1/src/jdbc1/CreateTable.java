/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author sangram
 */
public class CreateTable {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1", "root", "");

            if (con.isClosed()) {
                System.out.println("Connection Close...");
            } else {
                String q = "CREATE TABLE User (PersonID int primary key auto_increment,LastName varchar(255),FirstName varchar(255),Address varchar(255),City varchar(255))";
//                String q = "create database table1"; table create 
                Statement stmt = con.createStatement();
                stmt.executeUpdate(q);
                System.out.println("Create Database..");
                con.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
