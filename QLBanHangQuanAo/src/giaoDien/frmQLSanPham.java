package giaoDien;

import DAO.ChiTietSanPhamDAO;
import MODELS.ChiTietSanPham;
import MODELS.SanPham;
import helper.XJdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class frmQLSanPham extends javax.swing.JFrame {

    Connection cn;

    ChiTietSanPhamDAO chitietspDao = new ChiTietSanPhamDAO();
    int row = - 1;
    int i = 1;
    ArrayList<ChiTietSanPham> listChiTiet = new ArrayList<>();
    DefaultTableModel model;

    public frmQLSanPham() {
        initComponents();
        setLocationRelativeTo(null);
//        setExtendedState(JFrame.MAXIMIZED_BOTH);

        model = (DefaultTableModel) tblDanhSach.getModel();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiemMaSp = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboDanhMuc = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenSp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboKichCo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        txtGiaTien = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cboNhaSX = new javax.swing.JComboBox<>();
        cboMauSac = new javax.swing.JComboBox<>();
        cboChatLieu = new javax.swing.JComboBox<>();
        cboTrangThai = new javax.swing.JComboBox<>();
        cboDonViTinh = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 20))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Mã sản phẩm:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiemMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemMaSp, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Mã Sản Phẩm:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Danh Mục:");

        cboDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Áo Khoác Nữ", "Áo Khoác Nam", "Quần Jean" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Nhà Sản Xuất:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Tên Sản Phẩm:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Trạng Thái:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Kích Cỡ:");

        cboKichCo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L", "Xl", "XXL" }));
        cboKichCo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Màu Sắc:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("Đơn Vị Tính:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel10.setText("Chất Liệu:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel11.setText("Mô Tả:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel12.setText("Giá Tiền:");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton1.setText("Làm Mới");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton2.setText("Cập Nhật");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton3.setText("Thêm Sản Phẩm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cboNhaSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L", "Xl", "XXL" }));
        cboNhaSX.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cboMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L", "Xl", "XXL" }));
        cboMauSac.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cboChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L", "Xl", "XXL" }));
        cboChatLieu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L", "Xl", "XXL" }));
        cboTrangThai.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cboDonViTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L", "Xl", "XXL" }));
        cboDonViTinh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12))
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cboKichCo, javax.swing.GroupLayout.Alignment.LEADING, 0, 261, Short.MAX_VALUE)
                            .addComponent(cboMauSac, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboChatLieu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboNhaSX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaSp)
                            .addComponent(txtGiaTien, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(11, 11, 11)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cboTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel9))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2)
                                        .addComponent(cboDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboDanhMuc, 0, 237, Short.MAX_VALUE)
                                    .addComponent(txtTenSp))))
                        .addGap(48, 48, 48))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboNhaSX, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(cboDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel11))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(45, 45, 45))
        );

        tblDanhSach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblDanhSach.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Sản Phẩm", "Danh Mục", "Chất Liệu", "Màu Sắc", "Kích Cỡ", "Nhà Sản Xuất", "Giá Tiền", "Số Lượng", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSach.setRowHeight(22);
        jScrollPane3.setViewportView(tblDanhSach);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(477, 477, 477)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmQLSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboDanhMuc;
    private javax.swing.JComboBox<String> cboDonViTinh;
    private javax.swing.JComboBox<String> cboKichCo;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboNhaSX;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtMaSp;
    private javax.swing.JTextField txtTenSp;
    private javax.swing.JTextField txtTimKiemMaSp;
    // End of variables declaration//GEN-END:variables

    private void init() {
        fillTable();
    }

    private void fillTable() {
        model.setRowCount(0);
        try {
            String sql = "select TenSanPham, TenDanhMuc, ChatLieuSP, MauSac, KichCo, TenNhaSX, GiaTien,Soluong,  ChiTietSanPham.TrangThai from ChiTietSanPham \n"
                    + "inner join MauSac on MauSac.IDMauSac=ChiTietSanPham.IDMauSac\n"
                    + "inner join DonViTinh on DonViTinh.IDDonViTinh = ChiTietSanPham.IDDonViTinh\n"
                    + "inner join ChatLieu on ChatLieu.IDChatLieu=ChiTietSanPham.IDChatLieu\n"
                    + "inner join GioiTinh on GioiTinh.IDGioiTinh=ChiTietSanPham.IDgioiTinh\n"
                    + "inner join KichCoSP on KichCoSP.IDKichCo=ChiTietSanPham.IDKichCo\n"
                    + "inner join SanPham on ChiTietSanPham.IDSanPham=SanPham.IDSanPham\n"
                    + "inner join DanhMucSP on DanhMucSP.IDDanhMuc=SanPham.IDDanhMuc\n"
                    + "inner join NhaSanXuat on NhaSanXuat.IDNhaSanXuat=SanPham.IDNhaSanXuat";
            PreparedStatement pstm = XJdbc.getStmt(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String TenSP = rs.getString(1);
                String DanhMuc = rs.getString(2);
                String ChatLieu = rs.getString(3);
                String MauSac = rs.getString(4);
                String KichCo = rs.getString(5);
                String NhaSanXuat = rs.getString(6);
                int GiaTien = rs.getInt(7);
                int SoLuong = rs.getInt(8);
                int TrangThai = rs.getInt(9);
                model.addRow(new Object[]{TenSP, DanhMuc, ChatLieu, MauSac, KichCo, NhaSanXuat, GiaTien, SoLuong, TrangThai});

            }
            rs.close();
            pstm.close();
        } catch (Exception e) {
        }
    }
    void setForm(ChiTietSanPham ctsp, SanPham sp){
        txtMaSp.setText(ctsp.getMaSP());
        txtTenSp.setText(ctsp.getTenCT());
        txtGiaTien.setText(ctsp.getGiaTien()+"");
        cboDanhMuc.setSelectedItem(sp.getIdDanhMuc());
        cboNhaSX.setSelectedItem(sp.getIdNhaSanXuat());
        cboMauSac.setSelectedItem(ctsp.getIdMauSac());
        
    }

    private void insert() {
       
    }
}
