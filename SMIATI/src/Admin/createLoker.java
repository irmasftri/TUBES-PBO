/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import SMIATI.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author idhammidori
 */
public class createLoker extends javax.swing.JFrame {

    private DefaultTableModel model;
    String vNama,vJabat,vEmail,vAlmt;
    /**
     * Creates new form createLoker
     */
    public void getData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try {
            Statement stat = (Statement) koneksi.getKoneksi().createStatement();
            String sql = "Select * from lowongan_kerja";
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
            Object[] obj = new Object[4];
            obj[0] = res.getString("nama_perusahaan");
            obj[1] = res.getString("jabatan");
            obj[2] = res.getString("email");
            obj[3] = res.getString("alamat");
            
            model.addRow(obj);
            }
        } catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public createLoker() {
        initComponents();
        setLocationRelativeTo(null);
        
        model = new DefaultTableModel();
        tabel.setModel(model);
        model.addColumn("Nama Perusahaan");
        model.addColumn("Jabatan");
        model.addColumn("Kontak");
        model.addColumn("Alamat");
        
        getData();
    }

    public void loadData(){
        vNama = nama.getText();
        vJabat = jabatan.getText();
        vEmail = email.getText(); 
        vAlmt = alamat.getText(); 
    }
    
    public void saveData(){
        loadData();
        try{
            Statement stat = (Statement) koneksi.getKoneksi().createStatement();
            String sql = "insert into lowongan_kerja(nama_perusahaan,jabatan,email,alamat) values ('"
                         +vNama+"','"+vJabat+"','"+vEmail+"','"+vAlmt+"')";
            
            PreparedStatement p = (PreparedStatement) koneksi.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            getData();
        } catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void reset(){
        vNama = "";
        vJabat = "";
        vEmail = "";
        vAlmt = "";
        nama.setText(vNama);
        jabatan.setText(vJabat);
        email.setText(vEmail);
        alamat.setText(vAlmt);
    }
    
    public void dataSelect(){
        int i = tabel.getSelectedRow();
        if(i == -1){
            return;
        }
        
        nama.setText(""+model.getValueAt(i,0));
        jabatan.setText(""+model.getValueAt(i,1));
        email.setText(""+model.getValueAt(i,2));
        alamat.setText(""+model.getValueAt(i,3));
    }
    
    public void updateData(){
        loadData();
        try{
            Statement stat = (Statement) koneksi.getKoneksi().createStatement();
            
            String sql = "UPDATE lowongan_kerja SET nama_perusahaan = '"+vNama+"',"+"jabatan = '"+vJabat+"',"
                    +"email = '"+vEmail+"',"+"alamat = '"+vAlmt+"' WHERE email = '"+vEmail+"'";
            //String sql = "UPDATE akunalumni SET NIM = '"+vUname+"',"
              //      +"Password = '"+ vPass +"' WHERE NIM = '" + vUname +"'";
            PreparedStatement p = (PreparedStatement) koneksi.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            getData();
            reset();
            JOptionPane.showMessageDialog(null, "Update berhasil");
        } catch(SQLException er){
            JOptionPane.showMessageDialog(null, er.getMessage());
        }
    }
    
    public void delData(){
        loadData();
        int pesan = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus"+vEmail+"?","Konfirmasi",
                    JOptionPane.OK_CANCEL_OPTION);
        
        if(pesan==JOptionPane.OK_OPTION){
            try{
                Statement stat = (Statement) koneksi.getKoneksi().createStatement();
                String sql = "DELETE FROM lowongan_kerja WHERE email = '"+vEmail+"'";
                PreparedStatement p = (PreparedStatement) koneksi.getKoneksi().prepareStatement(sql);
                p.executeUpdate();
                getData();
                reset();
                JOptionPane.showMessageDialog(null, "Delete berhasil");
            } catch(SQLException er){
                JOptionPane.showMessageDialog(null, er.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabelNama = new javax.swing.JLabel();
        jLabelJabatan = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelAdrs = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jabatan = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Tambah Lowongan Pekerjaan");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jLabelNama.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabelNama.setForeground(new java.awt.Color(12, 12, 79));
        jLabelNama.setText("Nama Perusahaan");
        getContentPane().add(jLabelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 117, 20));

        jLabelJabatan.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabelJabatan.setForeground(new java.awt.Color(12, 12, 79));
        jLabelJabatan.setText("Lowongan Jabatan");
        getContentPane().add(jLabelJabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 117, -1));

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabelEmail.setForeground(new java.awt.Color(12, 12, 79));
        jLabelEmail.setText("Email Perusahaan");
        getContentPane().add(jLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 117, 20));

        jLabelAdrs.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabelAdrs.setForeground(new java.awt.Color(12, 12, 79));
        jLabelAdrs.setText("Alamat Perusahaan");
        getContentPane().add(jLabelAdrs, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 117, 20));
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 448, -1));
        getContentPane().add(jabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 448, -1));
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 448, -1));
        getContentPane().add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 448, 20));

        save.setForeground(new java.awt.Color(0, 0, 102));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 98, -1));

        btnReset.setForeground(new java.awt.Color(0, 0, 102));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 101, -1));

        btnDelete.setForeground(new java.awt.Color(0, 0, 102));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 97, -1));

        btnUpdate.setForeground(new java.awt.Color(0, 0, 102));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 98, -1));

        btnBack.setForeground(new java.awt.Color(0, 0, 102));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 81, -1));

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
        jScrollPane2.setViewportView(tabel);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 264, 675, 210));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/82794.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
        new Admin().show();
    }//GEN-LAST:event_btnBackActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
       saveData();
    }//GEN-LAST:event_saveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        dataSelect();
    }//GEN-LAST:event_tabelMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateData();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delData();
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(createLoker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createLoker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createLoker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createLoker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createLoker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAdrs;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelJabatan;
    private javax.swing.JLabel jLabelNama;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jabatan;
    private javax.swing.JTextField nama;
    private javax.swing.JButton save;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
