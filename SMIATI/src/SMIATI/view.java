
package SMIATI;
import java.sql.*;
import java.util.*;

public class view {
    Map<Integer,Alumni>  data = new HashMap<Integer,Alumni>();
    int sum;
    public view (){
        
     try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/smiati_final", "root", "");
            Statement stmt = conn.createStatement();
            ){  
                ResultSet rset = stmt.executeQuery("select * from alumni");
                int i=0;
                while (rset.next()){
                    Alumni alm = new Alumni(rset.getString("NIM"), rset.getString("NAMA"),rset.getString("Tahun_Lulus"), rset.getString("Tempat_KP"), rset.getDouble("IPK"), rset.getString("Riwayat_Kerja"), rset.getString("Judul_TA"), rset.getString("email"));
                    data.put(i, alm);
                    i++;
                } 

              /* for (int j=1;j<i;j++){
                   if (data.get(j).ipk<4){
                   System.out.println(data.get(j).nama+" "+data.get(j).ipk);
                   }
               }*/
               /* System.out.println("The records selected are:");
                int rowCount=0;
                while(rset.next()){
                    String NIM = rset.getString("NIM");
                    String nama = rset.getString("NAMA");
                    String thnlulus = rset.getString("Tahun_Lulus");
                    String kp = rset.getString("Tempat_KP");
                    String rk = rset.getString("Riwayat_Kerja");
                    String ta = rset.getString("Judul_TA");
                    String email = rset.getString("email");
                    double ipk = rset.getDouble("IPK");
                    System.out.println(NIM+" "+nama+", "+thnlulus+ " "+kp+" "+ rk + " "+ ta+" "+email+" "+ipk);
                    ++rowCount;
                }*/
               // System.out.println("Banyak Data = "+ rowCount);
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }    

}
