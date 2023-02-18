/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc1;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.sql.PreparedStatement.*;
import java.sql.*;

/**
 *
 * @author sangram
 */
public class Imagein_javaDatabases {

    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            if (con.isClosed()) {
                System.out.println("Connection Colse...");
            } else {
                String q = "insert into image(pi) value(?)";
                PreparedStatement pstmt = con.prepareStatement(q);

                File blob = new File("C:\\Users\\sangram\\Documents\\NetBeansProjects\\JDBC1\\src\\jdbc1\\office.jpg");
                FileInputStream in = new FileInputStream(blob);

//                 FileInputStream fis =new  FileInputStream("C:\\Users\\sangram\\Documents\\NetBeansProjects\\JDBC1\\src\\jdbc1\\office.jpg");
                pstmt.setBinaryStream(1, in, (int) blob.length());

                pstmt.setInt(1,42);  // set the PK value
                pstmt.executeUpdate();
                con.commit();
                pstmt.close();
                System.out.println("Done...");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
