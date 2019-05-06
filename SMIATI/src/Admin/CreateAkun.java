/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Ctrate akum
package Admin;

import SMIATI.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author idhammidori
 */
public final class CreateAkun extends javax.swing.JFrame {

    private DefaultTableModel model;
    String vUname,vPass;
    /**
     * Creates new form CreateAkun
     */
    
    public void getData(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try {
            Statement stat = (Statement) koneksi.getKoneksi().createStatement();
            String sql = "Select * from akunalumni";
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
            Object[] obj = new Object[2];
            obj[0] = res.getString("NIM");
            obj[1] = res.getString("Password");
            
            model.addRow(obj);
            }
        } catch (SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    } 
    
    public CreateAkun() {
        initComponents();
        setLocationRelativeTo(null);
        
        model = new DefaultTableModel();
        table.setModel(model);
        model.addColumn("Username");
        model.addColumn("Password");
        
        getData();
    }
    
    public void loadData(){
        vUname = uname.getText();
        vPass = pw.getText();   
    }
    
    public void saveData(){
        loadData();
        try{
            Statement stat = (Statement) koneksi.getKoneksi().createStatement();
            String sql = "insert into akunalumni(NIM,Password) values ('" +vUname+"','"+vPass+"')";
            
            PreparedStatement p = (PreparedStatement) koneksi.getKoneksi().prepareStatement(sql);
            p.executeUpdate();
            getData();
        } catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void reset(){
        vUname = "";
        vPass = "";
        uname.setText(vUname);
        pw.setText(vPass);
    }
    
    public void dataSelect(){
        int i = table.getSelectedRow();
        if(i == -1){
            return;
        }
        
        uname.setText(""+model.getValueAt(i,0));
        pw.setText(""+model.getValueAt(i,1));
    }
    
    public void updateData(){
        loadData();
        try{
            Statement stat = (Statement) koneksi.getKoneksi().createStatement();
            
            String sql = "UPDATE akunalumni SET NIM = '"+vUname+"',"
                    +"Password = '"+ vPass +"' WHERE NIM = '" + vUname +"'";
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
        int pesan = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus "+vUname+"?","Konfirmasi",
                    JOptionPane.OK_CANCEL_OPTION);
        
        if(pesan==JOptionPane.OK_OPTION){
            try{
                Statement stat = (Statement) koneksi.getKoneksi().createStatement();
                String sql = "DELETE FROM akunalumni WHERE NIM = '"+vUname+"'";
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

        jLabelUname = new javax.swing.JLabel();
        jLabelPass = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        pw = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelUname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUname.setForeground(new java.awt.Color(0, 0, 102));
        jLabelUname.setText("Username");
        getContentPane().add(jLabelUname, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, 30));

        jLabelPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPass.setForeground(new java.awt.Color(0, 0, 102));
        jLabelPass.setText("Password");
        getContentPane().add(jLabelPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, 30));

        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });
        getContentPane().add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 240, 30));

        pw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwActionPerformed(evt);
            }
        });
        getContentPane().add(pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 240, 30));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 0, 102));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 80, -1));

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnReset.setForeground(new java.awt.Color(0, 0, 102));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 80, -1));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 0, 102));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, -1, -1));

        btnDel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnDel.setForeground(new java.awt.Color(0, 0, 102));
        btnDel.setText("Delete");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        getContentPane().add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 70, -1));

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 0, 102));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 460, 70, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Create Account");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 280, 29));

        table.setForeground(new java.awt.Color(0, 0, 102));
        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 652, 200));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/82794.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameActionPerformed
        
    }//GEN-LAST:event_unameActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        saveData();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        dispose();
        new Admin().show();
    }//GEN-LAST:event_btnBackActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        dataSelect();
    }//GEN-LAST:event_tableMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateData();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        delData();
    }//GEN-LAST:event_btnDelActionPerformed

    private void pwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwActionPerformed

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
            java.util.logging.Logger.getLogger(CreateAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAkun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateAkun().setVisible(true);
            }
        }); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelPass;
    private javax.swing.JLabel jLabelUname;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pw;
    private javax.swing.JTable table;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}
