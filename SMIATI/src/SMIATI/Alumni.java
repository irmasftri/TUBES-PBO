/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMIATI;


public class Alumni  {
    public String nim;
    public String nama;
    public String thn;
    public String kp;
    public double ipk;
    public String rkerja;
    public String ta;
    public String email;
    public Alumni(String nim,String nama, String thn, String kp, double ipk, String rkerja, String ta, String email ){
        this.nim=nim;
        this.nama=nama;
        this.thn=thn;
        this.kp=kp;
        this.ipk=ipk;
        this.rkerja=rkerja;
        this.ta=ta;
        this.email=email;
    }
    
    public String getNim(){
        return nim;
    }
    public String getNama(){
        return nama;
    }
    public String getThn(){
        return thn;
    }
    public String getKp (){
        return kp;
    }
    public double getIpk(){
        return ipk;
    }
    public String getTa (){
        return ta;
    }
    public String getEmail(){
        return email;
    }
    
}
