/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasored;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author inspector
 */
public class M_Codigos extends ConexionBD{
    void insertDatabase(String folio){
        try {
            Cst=OpenDB().prepareCall("{call escaneaI(?)}");
            Cst.setString(1, folio);
            int resp=Cst.executeUpdate();
            if (resp > 0) {
                CloseDB();
                
            }
            CloseDB();
        } catch (SQLException ex) {
            String msj="SQL";
            if (ex.getMessage().contains("Duplicate entry")) {
                msj="de Duplicidad";
            }else if(ex.getMessage().contains("data too long")){
                msj="nombre del cliente muy largo";
            }
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error "+msj, JOptionPane.ERROR_MESSAGE);
        }
        CloseDB();
    }
    void updateDatabase(String folio){
        try {
            Cst=OpenDB().prepareCall("{call escaneaU(?)}");
            Cst.setString(1, folio);
            int resp=Cst.executeUpdate();
            if (resp > 0) {
                CloseDB();
                
            }else{
                JOptionPane.showMessageDialog(null, "El folio: "+ folio+" no existe en la BD","ERROR",JOptionPane.WARNING_MESSAGE);
            }
            CloseDB();
        } catch (SQLException ex) {
           String msj="SQL";
            if (ex.getMessage().contains("Duplicate entry")) {
                msj="de Duplicidad";
            }else if(ex.getMessage().contains("data too long")){
                msj="nombre del cliente muy largo";
            }
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error "+msj, JOptionPane.ERROR_MESSAGE);
        }
        CloseDB();
    }
    ArrayList<String> selectDatabase(){
       ArrayList<String> lis=new ArrayList<>();
       String val=null;
        try {
            
            Pst= OpenDB().prepareCall("SELECT cod_escaneado FROM codigos_280618");
            Rs=Pst.executeQuery();
            
            while (Rs.next()) {
                val=Rs.getString(1);
                if (val!=null) {
                    lis.add(val);
                }
                
            }
           
            CloseDB();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        CloseDB();
        return lis;
    }
    /*public static void main(String[] args) {
        System.out.println(new M_Codigos().selectDatabase());
    }*/
}
