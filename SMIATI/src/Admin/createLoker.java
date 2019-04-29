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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Tambah Lowongan Pekerjaan");

        jLabelNama.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNama.setText("Nama Perusahaan");

        jLabelJabatan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelJabatan.setText("Lowongan Jabatan");

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelEmail.setText("Email Perusahaan");

        jLabelAdrs.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelAdrs.setText("Alamat Perusahaan");

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNama, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelAdrs, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(alamat)
                                    .addComponent(email)
                                    .addComponent(jabatan)
                                    .addComponent(nama))))))
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNama)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelJabatan)
                    .addComponent(jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAdrs)
                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnReset))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(19, 19, 19))
        );

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
