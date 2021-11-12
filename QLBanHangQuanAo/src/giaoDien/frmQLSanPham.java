package giaoDien;

import DAO.ChiTietSanPhamDAO;
import DAO.ThuocTinhDAO;
import MODELS.ChatLieu;
import MODELS.ChiTietSanPham;
import MODELS.DanhMuc;
import MODELS.DonViTinh;
import MODELS.GioiTinh;
import MODELS.KichCo;
import MODELS.MauSac;
import MODELS.NhaSanXuat;
import MODELS.SanPham;
import helper.XJdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class frmQLSanPham extends javax.swing.JFrame {

    Connection cn;

    ChiTietSanPhamDAO chitietspDao = new ChiTietSanPhamDAO();
    int row = - 1;
    int i = 1;
    ArrayList<ChiTietSanPham> listChiTiet = new ArrayList<>();
    DefaultTableModel model;
    ThuocTinhDAO ttDAO;

    public frmQLSanPham() {
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        model = (DefaultTableModel) tblDanhSach.getModel();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiemMaSp = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtMaSp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboKichCo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cboMauSac = new javax.swing.JComboBox<>();
        cboChatLieu = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtGiaTien = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        cboDonViTinh = new javax.swing.JComboBox<>();
        cboTrangThai = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSuaCT = new javax.swing.JButton();
        btnLamMoiCT = new javax.swing.JButton();
        btnThemCT = new javax.swing.JButton();
        txtTenCT = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnThemCboTT = new javax.swing.JButton();
        cboDanhMuc = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboNhaSX = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        btnThemCboDonVi = new javax.swing.JButton();
        btnThemCboDanhMuc = new javax.swing.JButton();
        btnThemCboNSX = new javax.swing.JButton();
        btnThemCboMauSac = new javax.swing.JButton();
        btnThemCboKichCo = new javax.swing.JButton();
        btnThemCboChatLieu = new javax.swing.JButton();
        btnThemCboTen = new javax.swing.JButton();
        cboTenSP = new javax.swing.JComboBox<>();
        cboGioiTinh = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        btnThemCboGioiTinh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 20))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Mã sản phẩm:");

        jButton1.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiemMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemMaSp, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Mã Sản Phẩm:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Kích Cỡ:");

        cboKichCo.setEditable(true);
        cboKichCo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Màu Sắc:");

        cboMauSac.setEditable(true);
        cboMauSac.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cboChatLieu.setEditable(true);
        cboChatLieu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel10.setText("Chất Liệu:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel12.setText("Giá Tiền:");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        cboDonViTinh.setEditable(true);
        cboDonViTinh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cboTrangThai.setEditable(true);
        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn hàng", "Hết hàng" }));
        cboTrangThai.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel11.setText("Tên chi tiết: ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("Đơn Vị Tính:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Trạng Thái:");

        btnSuaCT.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnSuaCT.setText("Cập Nhật");
        btnSuaCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCTActionPerformed(evt);
            }
        });

        btnLamMoiCT.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnLamMoiCT.setText("Làm Mới");
        btnLamMoiCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiCTActionPerformed(evt);
            }
        });

        btnThemCT.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnThemCT.setText("Thêm Sản Phẩm");
        btnThemCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCTActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel13.setText("Giới Tính:");

        btnThemCboTT.setText("+");
        btnThemCboTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCboTTActionPerformed(evt);
            }
        });

        cboDanhMuc.setEditable(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Danh Mục:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Tên Sản Phẩm:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Nhà Sản Xuất:");

        cboNhaSX.setEditable(true);
        cboNhaSX.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabel14.setText("Sản Phẩm");

        btnThemCboDonVi.setText("+");
        btnThemCboDonVi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCboDonViActionPerformed(evt);
            }
        });

        btnThemCboDanhMuc.setText("+");
        btnThemCboDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCboDanhMucActionPerformed(evt);
            }
        });

        btnThemCboNSX.setText("+");
        btnThemCboNSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCboNSXActionPerformed(evt);
            }
        });

        btnThemCboMauSac.setText("+");
        btnThemCboMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCboMauSacActionPerformed(evt);
            }
        });

        btnThemCboKichCo.setText("+");
        btnThemCboKichCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCboKichCoActionPerformed(evt);
            }
        });

        btnThemCboChatLieu.setText("+");
        btnThemCboChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCboChatLieuActionPerformed(evt);
            }
        });

        btnThemCboTen.setText("+");
        btnThemCboTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCboTenActionPerformed(evt);
            }
        });

        cboTenSP.setEditable(true);
        cboTenSP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cboGioiTinh.setEditable(true);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel15.setText("Mô Tả:");

        btnThemCboGioiTinh.setText("+");
        btnThemCboGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCboGioiTinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(btnLamMoiCT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSuaCT)
                .addGap(136, 136, 136)
                .addComponent(btnThemCT)
                .addGap(126, 126, 126))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel12))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtGiaTien, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cboChatLieu, 0, 193, Short.MAX_VALUE)
                        .addComponent(cboMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cboTenSP, 0, 212, Short.MAX_VALUE)
                        .addComponent(cboNhaSX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemCboNSX)
                    .addComponent(btnThemCboMauSac)
                    .addComponent(btnThemCboKichCo)
                    .addComponent(btnThemCboChatLieu)
                    .addComponent(btnThemCboTen))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel3)
                    .addComponent(jLabel15)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cboDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTenCT, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cboDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemCboTT)
                    .addComponent(btnThemCboDanhMuc)
                    .addComponent(btnThemCboDonVi)
                    .addComponent(btnThemCboGioiTinh))
                .addGap(28, 28, 28))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(361, 361, 361)
                .addComponent(jLabel14)
                .addContainerGap(413, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboChatLieu, cboKichCo, cboMauSac, cboNhaSX, cboTenSP, txtGiaTien, txtMaSp});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboDanhMuc, cboDonViTinh, cboGioiTinh, cboTrangThai, jScrollPane2, txtTenCT});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cboTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboNhaSX, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThemCboTen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemCboNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btnThemCboKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemCboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemCboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenCT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemCboDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThemCboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(btnThemCboTT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(btnThemCboDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemCT)
                        .addComponent(btnLamMoiCT))
                    .addComponent(btnSuaCT))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboChatLieu, cboKichCo, cboMauSac, cboNhaSX, cboTenSP, txtGiaTien, txtMaSp});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(504, 504, 504))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCTActionPerformed

    }//GEN-LAST:event_btnSuaCTActionPerformed

    private void btnLamMoiCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiCTActionPerformed
        clearForm();
    }//GEN-LAST:event_btnLamMoiCTActionPerformed

    private void btnThemCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCTActionPerformed

    }//GEN-LAST:event_btnThemCTActionPerformed

    private void btnThemCboTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCboTTActionPerformed
        checkTrungVaThemCombo(cboTrangThai);
    }//GEN-LAST:event_btnThemCboTTActionPerformed

    private void btnThemCboDonViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCboDonViActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemCboDonViActionPerformed

    private void btnThemCboDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCboDanhMucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemCboDanhMucActionPerformed

    private void btnThemCboNSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCboNSXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemCboNSXActionPerformed

    private void btnThemCboMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCboMauSacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemCboMauSacActionPerformed

    private void btnThemCboKichCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCboKichCoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemCboKichCoActionPerformed

    private void btnThemCboChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCboChatLieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemCboChatLieuActionPerformed

    private void btnThemCboTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCboTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemCboTenActionPerformed

    private void btnThemCboGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCboGioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemCboGioiTinhActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmQLSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoiCT;
    private javax.swing.JButton btnSuaCT;
    private javax.swing.JButton btnThemCT;
    private javax.swing.JButton btnThemCboChatLieu;
    private javax.swing.JButton btnThemCboDanhMuc;
    private javax.swing.JButton btnThemCboDonVi;
    private javax.swing.JButton btnThemCboGioiTinh;
    private javax.swing.JButton btnThemCboKichCo;
    private javax.swing.JButton btnThemCboMauSac;
    private javax.swing.JButton btnThemCboNSX;
    private javax.swing.JButton btnThemCboTT;
    private javax.swing.JButton btnThemCboTen;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboDanhMuc;
    private javax.swing.JComboBox<String> cboDonViTinh;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JComboBox<String> cboKichCo;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboNhaSX;
    private javax.swing.JComboBox<String> cboTenSP;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtMaSp;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtTenCT;
    private javax.swing.JTextField txtTimKiemMaSp;
    // End of variables declaration//GEN-END:variables

    private void init() {
        fillTable();
        fillcomboTenSP();
        fillComboDanhMuc();
        fillComboNSX();
        fillComboKichCo();
        fillComboMauSac();
        fillComboChatLieu();
        fillComboDonVi();
        fillComboGioiTinh(); 
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
            helper.MsgBox.alert(null, "Lỗi table");
        }
    }

    void setForm(ChiTietSanPham ctsp, SanPham sp) {
        txtMaSp.setText(ctsp.getMaSP());
        txtGiaTien.setText(ctsp.getGiaTien() + "");
        cboDanhMuc.setSelectedItem(sp.getIdDanhMuc());
        cboNhaSX.setSelectedItem(sp.getIdNhaSanXuat());
        cboMauSac.setSelectedItem(ctsp.getIdMauSac());
    }

    private void insert() {

    }

    private void fillcomboTenSP() {
        AutoCompleteDecorator.decorate(cboTenSP);
        DefaultComboBoxModel modelCombo = (DefaultComboBoxModel) cboTenSP.getModel();
        modelCombo.removeAllElements();
        try {
            String sql = "select * from SanPham";
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                modelCombo.addElement(new SanPham(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            helper.MsgBox.alert(null, "Lỗi combo");
        }
    }
    
    private void fillComboDanhMuc() {
        AutoCompleteDecorator.decorate(cboDanhMuc);
        DefaultComboBoxModel modelCombo = (DefaultComboBoxModel) cboDanhMuc.getModel();
        modelCombo.removeAllElements();
        try {
            String sql = "select * from DanhMucSP";
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                modelCombo.addElement(new DanhMuc(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            helper.MsgBox.alert(null, "Lỗi combo");
        }
    }

    private void fillComboNSX() {
        AutoCompleteDecorator.decorate(cboNhaSX);
        DefaultComboBoxModel modelCombo = (DefaultComboBoxModel) cboNhaSX.getModel();
        modelCombo.removeAllElements();
        try {
            String sql = "select * from NhaSanXuat";
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                modelCombo.addElement(new NhaSanXuat(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            helper.MsgBox.alert(null, "Lỗi combo");
        }
    }

    private void fillComboKichCo() {
        AutoCompleteDecorator.decorate(cboKichCo);
        DefaultComboBoxModel modelCombo = (DefaultComboBoxModel) cboKichCo.getModel();
        modelCombo.removeAllElements();
        try {
            String sql = "select * from KichCoSP";
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                modelCombo.addElement(new KichCo(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            helper.MsgBox.alert(null, "Lỗi combo");
        }
    }

    private void fillComboMauSac() {
        AutoCompleteDecorator.decorate(cboMauSac);
        DefaultComboBoxModel modelCombo = (DefaultComboBoxModel) cboMauSac.getModel();
        modelCombo.removeAllElements();
        try {
            String sql = "select * from MauSac";
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                modelCombo.addElement(new MauSac(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            helper.MsgBox.alert(null, "Lỗi combo");
        }
    }

    private void fillComboChatLieu() {
        AutoCompleteDecorator.decorate(cboTrangThai);
        AutoCompleteDecorator.decorate(cboChatLieu);
        DefaultComboBoxModel modelCombo = (DefaultComboBoxModel) cboChatLieu.getModel();
        modelCombo.removeAllElements();
        try {
            String sql = "select * from ChatLieu";
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                modelCombo.addElement(new ChatLieu(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            helper.MsgBox.alert(null, "Lỗi combo");
        }
    }

    private void fillComboDonVi() {
        AutoCompleteDecorator.decorate(cboDonViTinh);
        DefaultComboBoxModel modelCombo = (DefaultComboBoxModel) cboDonViTinh.getModel();
        modelCombo.removeAllElements();
        try {
            String sql = "select * from DonViTinh";
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                modelCombo.addElement(new DonViTinh(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            helper.MsgBox.alert(null, "Lỗi combo");
        }
    }
    
    private void fillComboGioiTinh() {
        AutoCompleteDecorator.decorate(cboGioiTinh);
        DefaultComboBoxModel modelCombo = (DefaultComboBoxModel) cboGioiTinh.getModel();
        modelCombo.removeAllElements();
        try {
            String sql = "select * from GioiTinh";
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                modelCombo.addElement(new GioiTinh(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            helper.MsgBox.alert(null, "Lỗi combo");
        }
    }

    private void checkTrungVaThemCombo(JComboBox cbo) {
        String temp = cbo.getSelectedItem().toString();
        int size = cbo.getItemCount();
        for (int j = 0; j < size; j++) {
            if (temp.equalsIgnoreCase(cbo.getItemAt(j).toString())) {
                helper.MsgBox.alert(null, temp + " là giá trị đã có sẵn, không được thêm trùng!");
                return;
            }
        }
        if (temp.equals("")) {
            helper.MsgBox.alert(null, "Giá trị thêm mới không được trống!");
            return;
        }
        cbo.addItem(cbo.getSelectedItem().toString());
    }

    private void clearForm() {
        txtGiaTien.setText("");
        txtMaSp.setText("");
        txtTenCT.setText("");
        txtMoTa.setText("");
    }

}
