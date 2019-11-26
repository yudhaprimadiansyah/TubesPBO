package com.tubs.gaspol.view;
import com.tubs.gaspol.list.*;
import com.tubs.gaspol.db.Koneksi;
import java.sql.Connection;
import javax.swing.DefaultComboBoxModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DORIZU
 */

public class UserHome extends javax.swing.JFrame {

    /**
     * Creates new form UserHome
     */
    
    private Connection conn;
    private String[] listDosen;
    private String[] listDosbing;
    public UserHome() {
        initComponents();
        this.setTitle("Registrasi Sidang Mahasiswa");
        this.conn = Koneksi.bukaKoneksi();
        
        DefaultComboBoxModel keahlians = new DefaultComboBoxModel(new ListData().getAllKeahlian()[1]);
        
        mataKeahlian.setModel(keahlians);
        DefaultComboBoxModel kodeDosens = new DefaultComboBoxModel(new ListData().getKodeAllDosen());
        DefaultComboBoxModel kodeDosens2 = new DefaultComboBoxModel(new ListData().getKodeAllDosen());
        dosbing1.setModel(kodeDosens);
        dosbing2.setModel(kodeDosens2);
        
        DefaultComboBoxModel tahuns = new DefaultComboBoxModel(new ListPeriode().getAllTahunSidang());
        tahunSidang.setModel(tahuns);
        //System.out.println(tahunSidang.getSelectedItem());
        DefaultComboBoxModel periodes = new DefaultComboBoxModel(new ListPeriode().getPeriode((Integer)tahunSidang.getSelectedItem()));
        periodeSidang.setModel(periodes);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfNimMhs = new javax.swing.JTextField();
        tfJudulPa = new javax.swing.JTextField();
        registrasi = new javax.swing.JButton();
        mataKeahlian = new javax.swing.JComboBox<>();
        dosbing2 = new javax.swing.JComboBox<>();
        dosbing1 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        tahunSidang = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        periodeSidang = new javax.swing.JComboBox<>();
        registrasiMahasiswa = new javax.swing.JButton();
        background = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        HomeUser = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Registrasi Jadwal Sidang");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("NIM");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Mata Keahlian");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Judul PA");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Dosen Pembimbing 1");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Dosen Pembimbing 2");

        registrasi.setBackground(new java.awt.Color(221, 89, 89));
        registrasi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        registrasi.setForeground(new java.awt.Color(255, 255, 255));
        registrasi.setText("Registrasi");
        registrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrasiActionPerformed(evt);
            }
        });

        mataKeahlian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        mataKeahlian.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                mataKeahlianItemStateChanged(evt);
            }
        });
        mataKeahlian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mataKeahlianActionPerformed(evt);
            }
        });

        dosbing2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dosbing2ItemStateChanged(evt);
            }
        });

        dosbing1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosbing1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("Tahun Sidang");

        tahunSidang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tahunSidangItemStateChanged(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("Periode Ke");

        periodeSidang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                periodeSidangItemStateChanged(evt);
            }
        });

        registrasiMahasiswa.setBackground(new java.awt.Color(221, 89, 89));
        registrasiMahasiswa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        registrasiMahasiswa.setForeground(new java.awt.Color(255, 255, 255));
        registrasiMahasiswa.setText("Registrasi Mahasiswa");
        registrasiMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrasiMahasiswaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(391, 391, 391))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(59, 574, Short.MAX_VALUE)
                .addComponent(registrasi)
                .addGap(459, 459, 459))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(registrasiMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(periodeSidang, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tahunSidang, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(dosbing2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dosbing1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfJudulPa, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mataKeahlian, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfNimMhs, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(235, 235, 235))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfNimMhs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6))
                    .addComponent(mataKeahlian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tfJudulPa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(dosbing1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(dosbing2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(registrasiMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tahunSidang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(periodeSidang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(registrasi)
                .addGap(40, 40, 40))
        );

        background.setBackground(new java.awt.Color(221, 89, 89));

        logo.setFont(new java.awt.Font("Segoe UI Black", 0, 48)); // NOI18N
        logo.setForeground(new java.awt.Color(255, 255, 255));
        logo.setText("SidangAja.");

        HomeUser.setBackground(new java.awt.Color(221, 89, 89));
        HomeUser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        HomeUser.setPreferredSize(new java.awt.Dimension(90, 90));
        HomeUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeUserMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tubs/gaspol/image/home-icon-silhouette.png"))); // NOI18N

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Home");

        javax.swing.GroupLayout HomeUserLayout = new javax.swing.GroupLayout(HomeUser);
        HomeUser.setLayout(HomeUserLayout);
        HomeUserLayout.setHorizontalGroup(
            HomeUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HomeUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        HomeUserLayout.setVerticalGroup(
            HomeUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(968, 968, 968)
                .addComponent(logo)
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundLayout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addComponent(HomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1132, Short.MAX_VALUE)))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backgroundLayout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(HomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(436, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrasiActionPerformed
        // TODO add your handling code here:
        String nim = tfNimMhs.getText();
        int idKeahlian = Integer.parseInt(new ListData().getAllKeahlian()[0][mataKeahlian.getSelectedIndex()]);
        String judulPa = tfJudulPa.getText();
        String dosenPembimbing1 = dosbing1.getSelectedItem().toString();
        String dosenPembimbing2 = dosbing2.getSelectedItem().toString();
        int tahunSidangg = Integer.parseInt(tahunSidang.getSelectedItem().toString());
        int periodSidang = Integer.parseInt(periodeSidang.getSelectedItem().toString());
        
      //  new JadwalSidang().registrasi(nama,nim,idKeahlian,email,dosenPembimbing1,dosenPembimbing2,tahunSidangg,periodSidang);
        
       
    }//GEN-LAST:event_registrasiActionPerformed

    private void HomeUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeUserMouseClicked
        // TODO add your handling code here:
        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeUserMouseClicked

    private void mataKeahlianItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mataKeahlianItemStateChanged
        // TODO add your handling code here:
       
        //int idKeahlian = new ListKeahlian().getAllKeahlianlian()[0][Integer.parseInt(mataKeahlian.getSelectedIndex())];
        //DefaultComboBoxModel kodeDosens = new DefaultComboBoxModel(new ListDosen().getKodeAllDosenByKeahlian(idKeahlian));
    }//GEN-LAST:event_mataKeahlianItemStateChanged

    private void dosbing2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dosbing2ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_dosbing2ItemStateChanged

    private void dosbing1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosbing1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dosbing1ActionPerformed

    private void mataKeahlianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mataKeahlianActionPerformed
        // TODO add your handling code here:
        DefaultComboBoxModel kodeDosens = new DefaultComboBoxModel(new ListData().getKodeAllDosen());
        DefaultComboBoxModel kodeDosens2 = new DefaultComboBoxModel(new ListData().getKodeAllDosen());
        dosbing1.setModel(kodeDosens);
        dosbing2.setModel(kodeDosens2);
        
    }//GEN-LAST:event_mataKeahlianActionPerformed

    private void tahunSidangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tahunSidangItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tahunSidangItemStateChanged

    private void periodeSidangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_periodeSidangItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_periodeSidangItemStateChanged

    private void registrasiMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrasiMahasiswaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registrasiMahasiswaActionPerformed

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
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHome().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HomeUser;
    private javax.swing.JPanel background;
    private javax.swing.JComboBox<String> dosbing1;
    private javax.swing.JComboBox<String> dosbing2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    private javax.swing.JComboBox<String> mataKeahlian;
    private javax.swing.JComboBox<String> periodeSidang;
    private javax.swing.JButton registrasi;
    private javax.swing.JButton registrasiMahasiswa;
    private javax.swing.JComboBox<String> tahunSidang;
    private javax.swing.JTextField tfJudulPa;
    private javax.swing.JTextField tfNimMhs;
    // End of variables declaration//GEN-END:variables
}
