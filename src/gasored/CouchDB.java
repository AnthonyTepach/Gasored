/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gasored;

import com.fourspaces.couchdb.Session;
import java.util.Arrays;

/**
 *
 * @author inspector
 */
public class CouchDB {

    Session dbSession = new Session("localhost", 5984);
    String dbname = "employee";

    void data() {
        
        System.out.println(Arrays.toString(dbSession.getDatabaseNames().toArray()));
    }
    public static void main(String[] args) {
        CouchDB a=new CouchDB();
        a.data();
    }
}
