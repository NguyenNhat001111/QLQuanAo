package giaoDien;

import helper.XJdbc;

public class PFrmHoaDonChiTiet_trangThai_soLuong extends javax.swing.JFrame {

    int soLuong;
    int trangThai;
    double donGia;
    int maHD;
    int idSP;

    public PFrmHoaDonChiTiet_trangThai_soLuong(String tenSP, int MaHD, int idSP, int soLuong, double donGia, int trangThai) {
        initComponents();
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.donGia = donGia;
        this.maHD = MaHD;
        this.idSP = idSP;
        lbltenSP.setText(tenSP);
        setLocationRelativeTo(null);
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

        jLabel3.setText("Số lượng :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTrangThai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(btnTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(lbltenSP)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboTrangThai, txtSoLuong});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltenSP)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboTrangThai, txtSoLuong});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangThaiActionPerformed
        if (validateNumber()) {
            return;
        }
        int soLuongMoi = Integer.valueOf(txtSoLuong.getText());
        int tt = cboTrangThai.getSelectedIndex();
        int soLuongThua = soLuong - soLuongMoi;

        if (tt == 0) {
            try {
                String sql = "update HoaDonChiTiet set SoLuong = ?, TrangThai = ? where IDHoaDon = ? and IDCTSP = ?";
                int row = XJdbc.update(sql, soLuongMoi, tt, maHD, idSP);

                String sql2 = "insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)\n"
                        + "values(?, ?, ?, ?, ?)";
                int row2 = XJdbc.update(sql2, maHD, idSP, donGia, soLuongThua, 1);
                
                String sql3 = "update ChiTietSanPham set Soluong = Soluong + ? where IDCTSP = ?";
                int row3 = XJdbc.update(sql3, soLuongThua, idSP);
                if (row2 > 0 && row > 0 && row3 > 0) {
                    helper.MsgBox.alert(null, "Thành công");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (tt == 1){
            try {
                String sql = "update HoaDonChiTiet set SoLuong = ?, TrangThai = ? where IDHoaDon = ? and IDCTSP = ?";
                int row = XJdbc.update(sql, soLuongMoi, tt, maHD, idSP);

                String sql2 = "insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai)\n"
                        + "values(?, ?, ?, ?, ?)";
                int row2 = XJdbc.update(sql2, maHD, idSP, donGia, soLuongThua, 0);
                
                String sql3 = "update ChiTietSanPham set Soluong = Soluong + ? where IDCTSP = ?";
                int row3 = XJdbc.update(sql3, soLuongMoi, idSP);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
