package giaoDien;

import helper.XJdbc;

public class PFrmHoaDonChiTiet_trangThai_soLuong extends javax.swing.JFrame {

    int soLuong;
    int trangThai;
    double donGia;

    public PFrmHoaDonChiTiet_trangThai_soLuong(String tenSP, int MaHD, int idSP, int soLuong, double donGia, int trangThai) {
        initComponents();
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.donGia = donGia;
        lbltenSP.setText(tenSP);
        setLocationRelativeTo(null);
        lblMaHD.setText(MaHD + "");
        lblIDsp.setText(idSP + "");
        txtSoLuong.setText(soLuong + "");
        cboTrangThai.setSelectedIndex(trangThai);
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

        lbltenSP.setText("Tên SP");

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thanh Toán", "Trả hàng" }));

        jLabel1.setText("Mã hoá đơn:");

        lblMaHD.setText("Mã HĐ");

        jLabel4.setText("Mã sản phẩm chi tiết:");

        lblIDsp.setText("Mã SPCT");

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
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(43, 43, 43)
                                .addComponent(lblIDsp))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(92, 92, 92)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(85, 85, 85)
                                .addComponent(lblMaHD))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(43, 43, 43)
                                .addComponent(cboTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(91, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(btnTrangThai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(btnTrangThai)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangThaiActionPerformed
        if (validateNumber()) {
            return;
        }
        int maHD = Integer.valueOf(lblMaHD.getText());
        int idsp = Integer.valueOf(lblIDsp.getText());
        int soLuongMoi = Integer.valueOf(txtSoLuong.getText());
        int tt = cboTrangThai.getSelectedIndex();
        int soLuongThua = soLuong - soLuongMoi;

        if (tt == 0) {
            try {
                String sql = "update HoaDonChiTiet set SoLuong = ?, TrangThai = ? where IDHoaDon = ? and IDCTSP = ?";
                int row = XJdbc.update(sql, soLuongMoi, tt, maHD, idsp);

                String sql2 = "insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)\n"
                        + "values(?, ?, ?, ?, ?)";
                int row2 = XJdbc.update(sql2, maHD, idsp, donGia, soLuongThua, 1);
                
                String sql3 = "update ChiTietSanPham set Soluong = Soluong + ? where IDCTSP = ?";
                int row3 = XJdbc.update(sql3, soLuongThua, idsp);
                if (row2 > 0 && row > 0 && row3 > 0) {
                    helper.MsgBox.alert(null, "Thành công");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (tt == 1){
            try {
                String sql = "update HoaDonChiTiet set SoLuong = ?, TrangThai = ? where IDHoaDon = ? and IDCTSP = ?";
                int row = XJdbc.update(sql, soLuongMoi, tt, maHD, idsp);

                String sql2 = "insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)\n"
                        + "values(?, ?, ?, ?, ?)";
                int row2 = XJdbc.update(sql2, maHD, idsp, donGia, soLuongThua, 0);
                
                String sql3 = "update ChiTietSanPham set Soluong = Soluong + ? where IDCTSP = ?";
                int row3 = XJdbc.update(sql3, soLuongMoi, idsp);
                if (row > 0 && row2 > 0 && row3 > 0) {
                    helper.MsgBox.alert(null, "Thành công");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.dispose();
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

    private boolean validateNumber() {
        int amount;
        if (txtSoLuong.getText().isEmpty()) {
            helper.MsgBox.alert(null, "Xin mời nhập số lượng");
            txtSoLuong.requestFocus();
            return true;
        }
        try {
            amount = Integer.valueOf(txtSoLuong.getText());
        } catch (Exception e) {
            helper.MsgBox.alert(null, "Xin mời nhập số lượng là số");
            txtSoLuong.requestFocus();
            return true;
        }
        if (amount <= 0 || amount > this.soLuong) {
            helper.MsgBox.alert(null, "Xin mời nhập số lượng lớn hơn 0 và nhỏ hơn số lượng trong đơn hàng");
            txtSoLuong.requestFocus();
            return true;
        }
        return false;
    }

}
