
package SMIATI;
import java.sql.*;

public class view {
    public void data (){
     try(
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
            Statement stmt = conn.createStatement();
            ){
                //String strSelect = "select * from test";
               // System.out.println("Data alumni Teknik Informatika: "+ strSelect +"\n");
                
                ResultSet rset = stmt.executeQuery("select * from alumni");
                
                System.out.println("The records selected are:");
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
                }
                System.out.println("Banyak Data = "+ rowCount);
            }catch (SQLException ex){
                ex.printStackTrace();
            }
    }
}
