package SMIATI;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer id
 */
public class Isidata extends javax.swing.JFrame {

    private DefaultTableModel model;
    String a,b,c, d, e, f, g, h;
    
    public Isidata() {
        initComponents();
        setLocationRelativeTo(null);
        
        model = new DefaultTableModel ();
        tabel.setModel(model);
        model.addColumn("Nama");
        model.addColumn("Nim");
        model.addColumn("Tahun Lulus");
        model.addColumn("Tempat KP");
        model.addColumn("IPK");
        model.addColumn("Riwayar Kerja");
        model.addColumn("Judul TA");
        model.addColumn("email");
        
        getData();
    }
    
    public void getData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            Statement stat = (Statement) koneksi.getKoneksi().createStatement();
            String sql = "SELECT * FROM alumni";
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
                Object[] obj = new Object[8];
                obj[0] = res.getString("NAMA");
                obj[1] = res.getString("NIM");
                obj[2] = res.getString("Tahun_Lulus");
                obj[3] = res.getString("Tempat_KP");
                obj[4] = res.getString("IPK");
                obj[5] = res.getString("Riwayat_Kerja");
                obj[6] = res.getString("Judul_TA");
                obj[7] = res.getString("email");
                
                model.addRow(obj);
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    public void loadData(){
        a   = nama.getText();
        b   = nim.getText();
        c   = lulus.getText();
        d   = kp.getText();
        e   = ipk.getText();
        f   = kerja.getText();
        g   = ta.getText();
        h   = email.getText();
        
    }
    public void saveData() {
        loadData();
        try{
            Statement stat = (Statement)koneksi.getKoneksi().createStatement();
            String sql = "Insert into alumni (NAMA, NIM, Tahun_Lulus, Tempat_KP, IPK, Riwayat_Kerja, Judul_TA, email)"
                    +"values ('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"')";
            PreparedStatement p = (PreparedStatement)koneksi.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            getData();
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    public void Reset(){
        a = "";
        b = "";
        c = "";
        d = "";
        e = "";
        f = "";
        g = "";
        h = "";
        nama.setText(a);
        nim.setText(b);
        lulus.setText(c);
        kp.setText(d);
        ipk.setText(e);
        kerja.setText(f);
        ta.setText(g);
        email.setText(h);
        
    }
    
   public void dataSelect(){
        int i = tabel.getSelectedRow();
        if (i == -1){
            return;
        }
        
        nama.setText(""+model.getValueAt(i, 0));
        nim.setText(""+model.getValueAt(i, 1));
        lulus.setText(""+model.getValueAt(i, 2));
        kp.setText(""+model.getValueAt(i, 3));
        ipk.setText(""+model.getValueAt(i, 4));
        kerja.setText(""+model.getValueAt(i, 5));
        ta.setText(""+model.getValueAt(i, 6));
        email.setText(""+model.getValueAt(i, 7));
    }
    
    public void updateData(){
        loadData();
        try{
            Statement stat =(Statement)koneksi.getKoneksi().createStatement();
            String sql = "UPDATE alumni SET NAMA    = '"+a+"',"
                                            +"NIM   = '"+b+"',"
                                            +"Tahun_Lulus   = '"+c+"',"
                                            +"Tempat_KP = '"+d+"',"
                                            +"IPK   = '"+e+"',"
                                            +"Riwayat_Kerja = '"+f+"',"
                                            +"Judul_TA  = '"+g+"',"
                                            +"email = '"+h+"' WHERE NIM = '"+b+"'";
            PreparedStatement p = (PreparedStatement)koneksi.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            
            getData();
            Reset();
            JOptionPane.showMessageDialog(null, "Update berhasil . . .");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void deleteData(){
        loadData();
        
        int pesan = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data "+b+" ?", "Konfirmasi",
                JOptionPane.OK_CANCEL_OPTION);
        if (pesan == JOptionPane.OK_OPTION){
            try{
                Statement stat = (Statement)koneksi.getKoneksi().createStatement();
                String sql = "DELETE FROM alumni WHERE NIM = '"+b+"'";
                PreparedStatement p = (PreparedStatement)koneksi.getKoneksi().prepareStatement(sql);
                p.executeUpdate();
                getData();
                Reset();
                JOptionPane.showMessageDialog(null, "Delete Berhasil");
            }catch(SQLException err){
                JOptionPane.showMessageDialog(null, err.getMessage());
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        email = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        nim = new javax.swing.JTextField();
        lulus = new javax.swing.JTextField();
        kp = new javax.swing.JTextField();
        ipk = new javax.swing.JTextField();
        kerja = new javax.swing.JTextField();
        ta = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        update = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        delet = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 400, -1));

        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 400, -1));
        getContentPane().add(nim, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 400, -1));
        getContentPane().add(lulus, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 400, -1));
        getContentPane().add(kp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 400, -1));
        getContentPane().add(ipk, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 400, -1));
        getContentPane().add(kerja, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 400, -1));
        getContentPane().add(ta, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 400, -1));

        simpan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        simpan.setForeground(new java.awt.Color(0, 0, 102));
        simpan.setText("SAVE");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        getContentPane().add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 80, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("NAMA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("NIM");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Tahun Lulus");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 102));
        jLabel4.setText("IPK");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 102));
        jLabel5.setText("Tempat KP");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setText("Judul TA");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 102));
        jLabel7.setText("Riwayat Kerja");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 102));
        jLabel8.setText("Email");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setText("DATA ALUMNI TEKNIK INFORMATIKA ITERA");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 500, -1));

        reset.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        reset.setForeground(new java.awt.Color(0, 0, 102));
        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 80, -1));

        update.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        update.setForeground(new java.awt.Color(0, 0, 102));
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 80, -1));

        kembali.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kembali.setForeground(new java.awt.Color(0, 0, 102));
        kembali.setText("CANCEL");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 80, -1));

        delet.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        delet.setForeground(new java.awt.Color(0, 0, 102));
        delet.setText("DELETE");
        delet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletActionPerformed(evt);
            }
        });
        getContentPane().add(delet, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 80, -1));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 775, 205));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 102));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/(2).jpg"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_namaActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        saveData();
        
    }//GEN-LAST:event_simpanActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        Reset();
    }//GEN-LAST:event_resetActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
        Reset();
        new menunya().show();
        dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        dataSelect();
    }//GEN-LAST:event_tabelMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        updateData();
    }//GEN-LAST:event_updateActionPerformed

    private void deletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletActionPerformed
        // TODO add your handling code here:
        deleteData();
    }//GEN-LAST:event_deletActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Isidata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Isidata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Isidata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Isidata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Isidata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delet;
    private javax.swing.JTextField email;
    private javax.swing.JTextField ipk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JTextField kerja;
    private javax.swing.JTextField kp;
    private javax.swing.JTextField lulus;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nim;
    private javax.swing.JButton reset;
    private javax.swing.JButton simpan;
    private javax.swing.JTextField ta;
    private javax.swing.JTable tabel;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
