/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasored;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author inspector
 */
public class PostgresDB {

    private String user;
    private String pass;
    private String server;
    private String DB;
    private String DriverPostgres;
    private Connection con;
    protected ResultSet Rs;
    protected CallableStatement Cst;
    protected Statement St;
    protected PreparedStatement Pst;

    public PostgresDB() {
        user = "postgres";
        pass = "Tbryan.1996";
        server = "jdbc:postgresql://192.168.1.166:5432/";
        DB = "gasored";
        DriverPostgres = "org.postgresql.Driver";
        con = null;

    }

     public Connection OpenDB() {
        try {
            Class.forName(DriverPostgres);
            con = DriverManager.getConnection(server + DB, user, pass);
            
        } catch (ClassNotFoundException ex) {
            //System.out.println("No se a podido localizar el Driver: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
            con = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
            con = null;
        }
        return con;
    }

    public void CloseDB() {
        try {
            if (Cst != null) {
                Cst.close();
                //System.out.println("CST Cerrada");
            }
            if (Pst != null) {
                Pst.close();
                //System.out.println("PST Cerrada");
            }
            if (Rs != null) {
                Rs.close();
                //System.out.println("RS Cerrada");
            }
            if (St != null) {
                St.close();
                //System.out.println("ST Cerrada");
            }
            if (con != null) {
                con.close();
                //System.out.println("CON cerrada");
            }

        } catch (SQLException sqle) {
            System.out.println("Error al cerra las conexiones: " + sqle.getMessage());
        }
    }

    
}
