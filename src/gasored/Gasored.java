/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasored;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author inspector
 */
public class Gasored {

    /**
     * @param args the command line arguments
     */
    void leerDocumento(String ruta) {
        try {
            File archivo = new File(ruta);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String linea = br.readLine();
            M_Codigos mc=new M_Codigos();
            int aa=0;
            while ((linea = br.readLine()) != null) {
                //System.out.println(linea);
                mc.insertDatabase(linea);
                aa++;
                //System.out.println(linea+" "+aa);
            }
            System.out.println("listo");
            //JOptionPane.showMessageDialog(null, "La base de datos se cargo con exito","EXITO",JOptionPane.DEFAULT_OPTION);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    

}
