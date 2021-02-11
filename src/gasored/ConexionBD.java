package gasored;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionBD {

    private String user;
    private String pass;
    private String server;
    private String DB;
    private String DriverMySQL;
    private Connection con;
    protected ResultSet Rs;
    protected CallableStatement Cst;
    protected Statement St;
    protected PreparedStatement Pst;

    public ConexionBD() {
        user = "anthonytepach";
        pass = "Tbryan.1996";
        server = "jdbc:mysql://192.168.1.166:3306/";
        DB = "gasored";
        DriverMySQL = "com.mysql.jdbc.Driver";
        con = null;

    }
     public ConexionBD(String usuario,String contrasenia) {
        user = usuario;
        pass = contrasenia;
        server = "jdbc:mysql://localhost/";
        DB = "GASORED";
        DriverMySQL = "com.mysql.jdbc.Driver";
        con = null;

    }

    public Connection OpenDB() {
        try {
            Class.forName(DriverMySQL);
            con = DriverManager.getConnection(server + DB, user, pass);
            
        } catch (ClassNotFoundException ex) {
            //System.out.println("No se a podido localizar el Driver: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
            con = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
            con = null;
        }
        CloseDB();
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

    public static void main(String[] args) {
      ConexionBD con=new ConexionBD();
        System.out.println(con.OpenDB());
    }
}
