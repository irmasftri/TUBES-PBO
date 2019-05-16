/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CariNama;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.lang.String;
import java.util.TreeMap;
import SMIATI.*;

/**
 *
 * @author Windows 10
 */
public class namacari  {
    //String nama,nim,thn,kp,rkerja,ta,email;
        double ipk;
         Map <String,Alumni> carinama = new TreeMap<String, Alumni>(String.CASE_INSENSITIVE_ORDER);
    public namacari(){
       
        try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/smiati_final", "root", "");
            Statement stmt = conn.createStatement();
            ){  
                ResultSet rset = stmt.executeQuery("select * from alumni");
                int i=0;
                while (rset.next()){
                    Alumni alm = new Alumni(rset.getString("NIM"), rset.getString("NAMA"),rset.getString("Tahun_Lulus"), rset.getString("Tempat_KP"), rset.getDouble("IPK"), rset.getString("Riwayat_Kerja"), rset.getString("Judul_TA"), rset.getString("email"));
                    carinama.put(rset.getString("NAMA"), alm);
                    i++;
                } 
                }catch (SQLException ex){
                ex.printStackTrace();
            }
         }    
        
}    

