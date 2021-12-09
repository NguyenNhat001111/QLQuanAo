package giaoDien;

import DAO.NguoiDungDAO;
import helper.Auth;
import helper.MsgBox;
import helper.XJdbc;
import MODELS.NguoiDung;
import java.util.regex.Pattern;
public class Taikhoan extends javax.swing.JPanel {

    NguoiDungDAO nddao;
    
    public Taikhoan() {
        initComponents();
        this.nddao = new NguoiDungDAO();
        fillTXT();
        System.out.println(Auth.user.getIdNguoiDung());
        System.out.println(Auth.user.getEmail());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paldoimk = new javax.swing.JPanel();
        lblthongtin = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        lblhoten = new javax.swing.JLabel();
        lblsdt = new javax.swing.JLabel();
        lblcccd = new javax.swing.JLabel();
        lbldc = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        txtCCCD = new javax.swing.JTextField();
        txtDiachi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();

        paldoimk.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblthongtin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblthongtin.setText("THÔNG TIN CÁ NHÂN");

        btnLuu.setBackground(new java.awt.Color(255, 255, 255));
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinhanh/Accept.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hinhanh/Refresh.png"))); // NOI18N
        btnThoat.setText("Làm Mới");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        lblhoten.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblhoten.setText("Họ tên ");

        lblsdt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblsdt.setText("SDT");

        lblcccd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblcccd.setText("CCCD");

        lbldc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbldc.setText("Địa chỉ ");

        javax.swing.GroupLayout paldoimkLayout = new javax.swing.GroupLayout(paldoimk);
        paldoimk.setLayout(paldoimkLayout);
        paldoimkLayout.setHorizontalGroup(
            paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paldoimkLayout.createSequentialGroup()
                .addGroup(paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paldoimkLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblcccd)
                            .addComponent(lbldc)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paldoimkLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblsdt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblhoten, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47)
                .addGroup(paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(131, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paldoimkLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paldoimkLayout.createSequentialGroup()
                        .addComponent(lblthongtin)
                        .addGap(222, 222, 222))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paldoimkLayout.createSequentialGroup()
                        .addComponent(btnLuu)
                        .addGap(76, 76, 76)
                        .addComponent(btnThoat)
                        .addGap(147, 147, 147))))
        );

        paldoimkLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCCCD, txtDiachi});

        paldoimkLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnLuu, btnThoat});

        paldoimkLayout.setVerticalGroup(
            paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paldoimkLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblthongtin)
                .addGap(44, 44, 44)
                .addGroup(paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblhoten)
                    .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblsdt))
                .addGap(39, 39, 39)
                .addGroup(paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcccd))
                .addGap(47, 47, 47)
                .addGroup(paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnThoat))
                .addGap(55, 55, 55))
        );

        paldoimkLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCCCD, txtDiachi, txtSDT, txthoten});

        paldoimkLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnLuu, btnThoat});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(paldoimk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(paldoimk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        fillTXT();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        String hoTen = txthoten.getText();
        String SDT = txtSDT.getText();
        String CCCD = txtCCCD.getText();
        String diaChi = txtDiachi.getText();
        Pattern s = Pattern.compile("^[0-9\\-\\+]{10}$");
        if (s.matcher(SDT).find()) {
               
        } else {
            MsgBox.alert(this, "Định dạng số điện thoại sai(Phải là số và có 10 số)");
            txtSDT.requestFocus();
            return;
        }
        Pattern p = Pattern.compile("^[0-9\\-\\+]{12}$");
         if(p.matcher(CCCD).find()){
               
        } else {
            MsgBox.alert(this, "Định dạng CCCD sai(Phải là số và có 12 số)");
            txtCCCD.requestFocus();
            return;
        }
        String sql = "update NguoiDung set HoTenNhanVien=?, SDT=?, CCCD=?, DiaChi=? where IDNguoiDung=?";
        XJdbc.update(sql, hoTen, SDT, CCCD, diaChi, Auth.user.getIdNguoiDung());
        MsgBox.alert(this, "Cập nhật thông tin tài khoản thành công");
    }//GEN-LAST:event_btnLuuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel lblcccd;
    private javax.swing.JLabel lbldc;
    private javax.swing.JLabel lblhoten;
    private javax.swing.JLabel lblsdt;
    private javax.swing.JLabel lblthongtin;
    private javax.swing.JPanel paldoimk;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txthoten;
    // End of variables declaration//GEN-END:variables
    private void fillTXT(){
        NguoiDung nd = this.nddao.selectById(Auth.user.getIdNguoiDung());
        txthoten.setText(nd.getHoTen());
        txtSDT.setText(nd.getSdt());
        txtCCCD.setText(nd.getCccd());
        txtDiachi.setText(nd.getDiaChi());
    }
}
