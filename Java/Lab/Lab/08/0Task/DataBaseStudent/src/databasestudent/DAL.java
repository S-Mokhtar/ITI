/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasestudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;


/**
 *
 * @author Abdo
 */
public class DAL {

    static Connection connection;
    static int counter = 0;
    static ArrayList<DTO> al = new ArrayList<>();

    public DAL() {

    }

    /* public static DTO nextSTudent() {
        if (counter < al.size() - 1) {
            counter++;
        }

        return al.get(counter);
    }

    public static DTO preStudent() {
        if (counter > 0) {
            counter--;
        }
        return al.get(counter);
    }

    public static DTO firstStudent() {
        counter = 0;
        return al.get(counter);
    }

    public static DTO lastSTuendt() {
        int size = al.size();
        return al.get(size - 1);
    }
     */
    public static void addStudent(DTO student) {
        try {
            try {
                DriverManager.registerDriver(new ClientDriver());
                connection = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentsRecordes", "root", "root");
            } catch (SQLException ex) {
                Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
            }
            PreparedStatement pst = connection.prepareStatement("insert into Student values(?,?,?,?,?)");
            pst.setString(1, student.getFirstName());
            pst.setInt(2, student.getID());
            pst.setString(3, student.getLastName());
            pst.setString(4, student.getEmail());
            pst.setInt(5, student.getPhoneNumber());
            pst.executeUpdate();
            System.err.println("you saved succes");
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateStudent(DTO student) {
        try {
            try {
                DriverManager.registerDriver(new ClientDriver());
                connection = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentsRecordes", "root", "root");
            } catch (SQLException ex) {
                Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
            }
            PreparedStatement pst = connection.prepareStatement("update Student set Name = ?, LASTNAME=?,EMAIL=?,PHONENUMBER=? where ID = ? ");
            pst.setString(1, student.getFirstName());
            pst.setInt(5, student.getID());
            pst.setString(2, student.getLastName());
            pst.setString(3, student.getEmail());
            pst.setInt(4, student.getPhoneNumber());
            pst.executeUpdate();
            System.err.println("you updated succes");
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteStudent(int ID) {
        try {
            try {
                DriverManager.registerDriver(new ClientDriver());
                connection = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentsRecordes", "root", "root");
            } catch (SQLException ex) {
                Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
            }
            PreparedStatement pst = connection.prepareStatement("delete from STUDENT where id = ?");
            pst.setInt(1, ID);
            pst.executeUpdate();
            System.err.println("you delete succes");
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<DTO> selectStudent() {
        // Connection connection = null;
        try {
            DriverManager.registerDriver(new ClientDriver());
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/StudentsRecordes", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResultSet rs = null;
        try {
            Statement stmt = connection.createStatement();
            String queryString = new String("select * from STUDENT");
            rs = stmt.executeQuery(queryString);
            while (rs.next()) {
                al.add(new DTO(Integer.parseInt(rs.getString(2)), Integer.parseInt(rs.getString(2)), rs.getString(1), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return al;
    }
}
