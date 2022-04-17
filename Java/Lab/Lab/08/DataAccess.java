/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contacts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;

/**
 *
 * @author karam
 */
public class DataAccess {

    private static boolean flag = false;
    private static Connection con;
    private static Statement stmt;

    public DataAccess() {
        try {
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void connect() {
        try {
            DriverManager.registerDriver(new ClientDriver());
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/phoneBook", "root", "root");
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void closeConnection() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
            flag = false;
        } catch (SQLException ex) {
            // Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static boolean addContact(MyDTO t) {

        if (flag && !t.getPhone().trim().equalsIgnoreCase("")) {
            try {
                stmt = con.createStatement();
                String queryString = new String("INSERT INTO CONTACTS VALUES('" + t.getPhone() + "','" + t.getFName() + "','" + t.getLName() + "','" + t.getEmail() + "')");

                stmt.executeUpdate(queryString);

            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }

        }
        return true;
    }

    static boolean updateR(MyDTO temp, String s) {
        
            deleteR(s.trim());
            
            addContact(temp);
        
        return true;
    }

    static void deleteR(String s) {
        if (flag && !s.trim().equalsIgnoreCase("")) {
            try {
                stmt = con.createStatement();
                String queryString = new String("delete from CONTACTS where phone = '" + s + "'");
                
                stmt.executeUpdate(queryString);

            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    static ArrayList getAll() {
        MyDTO p;
        ArrayList<MyDTO> t = new ArrayList<>();
        ResultSet rs = null;
        if (flag) {
            try {
                Statement stmt = con.createStatement();
                String queryString = new String("select * from contacts");

                rs = stmt.executeQuery(queryString);

            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            while (rs.next()) {
                p = new MyDTO(rs.getString(2), rs.getString(3), rs.getString(1), rs.getString(4));
                t.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return t;
    }

}
