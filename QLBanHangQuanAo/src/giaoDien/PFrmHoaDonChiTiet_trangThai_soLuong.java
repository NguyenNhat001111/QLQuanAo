
package giaoDien;

import helper.XJdbc;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class PFrmHoaDonChiTiet_trangThai_soLuong extends javax.swing.JFrame {

    public PFrmHoaDonChiTiet_trangThai_soLuong(String tenSP, int MaHD, int idSP) {
        initComponents();
        lbltenSP.setText(tenSP);
        setLocationRelativeTo(null);
        lblMaHD.setText(MaHD + "");
        lblIDsp.setText(idSP + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTrangThai = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbltenSP = new javax.swing.JLabel();
        cboTrangThai = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        lblMaHD = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblIDsp = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnTrangThai.setText("Ok");
        btnTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangThaiActionPerformed(evt);
            }
        });

        jLabel2.setText("Trạng thái hoá đơn :");

        lbltenSP.setText("jLabel1");

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Huỷ", "Thanh Toán" }));

        jLabel1.setText("Mã hoá đơn");

        lblMaHD.setText("jLabel1");

        jLabel4.setText("Mã sản phẩm chi tiết");

        lblIDsp.setText("jLabel1");

        jLabel3.setText("Số lượng :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(lbltenSP))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblMaHD)
                            .addComponent(cboTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIDsp)
                            .addComponent(txtSoLuong)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(btnTrangThai)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltenSP)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblMaHD))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblIDsp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btnTrangThai)
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangThaiActionPerformed
        try {
            int MaHD = Integer.valueOf(lblMaHD.getText());
            int idsp = Integer.valueOf(lblIDsp.getText());
            int soLuong = Integer.valueOf(txtSoLuong.getText());
            if (soLuong > 0) {
                String sql2 = "update HoaDonChiTiet set SoLuong = ? where IDHoaDon = ? and IDCTSP = ?";
                PreparedStatement pstm2 = XJdbc.getStmt(sql2);
                pstm2.setInt(1, soLuong);
                pstm2.setInt(2, MaHD);
                pstm2.setInt(3, idsp);
                int row2 = pstm2.executeUpdate();

            } else {
                String sql3 = "DELETE FROM HoaDonChiTiet WHERE IDHoaDon = ? and IDCTSP = ?";
                PreparedStatement pstm3 = XJdbc.getStmt(sql3);
                pstm3.setInt(1, MaHD);
                pstm3.setInt(2, idsp);
                int row3 = pstm3.executeUpdate();
            }
            String sql = "update HoaDonChiTiet set TrangThai = ? where IDHoaDon = ? and IDCTSP = ?";
            PreparedStatement pstm2 = XJdbc.getStmt(sql);
            int trangThai = cboTrangThai.getSelectedIndex();
            pstm2.setInt(1, trangThai);
            pstm2.setInt(2, MaHD);
            pstm2.setInt(3, idsp);
            int row2 = pstm2.executeUpdate();
            if (row2 > 0) {
                JOptionPane.showMessageDialog(this, "update trang thái thành công với trạng thái : " + trangThai);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnTrangThaiActionPerformed

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PFrmHoaDonChiTiet_trangThai_soLuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PFrmHoaDonChiTiet_trangThai_soLuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PFrmHoaDonChiTiet_trangThai_soLuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PFrmHoaDonChiTiet_trangThai_soLuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PFrmHoaDonChiTiet_trangThai_soLuong().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTrangThai;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblIDsp;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lbltenSP;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables

}
