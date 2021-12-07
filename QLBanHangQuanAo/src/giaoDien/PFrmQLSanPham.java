package giaoDien;

import DAO.ChiTietSanPhamDAO;
import DAO.SanPhamDAO;
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
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class PFrmQLSanPham extends javax.swing.JPanel {

    ChiTietSanPhamDAO chitietspDao = new ChiTietSanPhamDAO();
    SanPhamDAO spDao = new SanPhamDAO();
    ThuocTinhDAO ttDao = new ThuocTinhDAO();
    int row = -1;
    ArrayList<ChiTietSanPham> listChiTiet = new ArrayList<>();
    DefaultTableModel model;
    TableRowSorter<DefaultTableModel> ts;

    public PFrmQLSanPham() {
        initComponents();

        model = (DefaultTableModel) tblDanhSach.getModel();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
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
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        txtTenCT = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
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
        btnThemCboTenSP = new javax.swing.JButton();
        cboTenSP = new javax.swing.JComboBox<>();
        cboGioiTinh = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        btnThemCboGioiTinh = new javax.swing.JButton();
        txtSoLuong = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 20))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Tìm kiếm:");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        tblDanhSach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblDanhSach.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Danh Mục", "Chất Liệu", "Màu Sắc", "Kích Cỡ", "Giới Tính", "Nhà Sản Xuất", "Giá Tiền", "Số Lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDanhSach.setRowHeight(22);
        tblDanhSach.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDanhSachMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblDanhSach);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtMaSp.setEditable(false);
        txtMaSp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMaSp.setText("Mã sản phẩm tự sinh");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã Sản Phẩm:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Kích Cỡ:");

        cboKichCo.setEditable(true);
        cboKichCo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboKichCo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Màu Sắc:");

        cboMauSac.setEditable(true);
        cboMauSac.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboMauSac.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cboChatLieu.setEditable(true);
        cboChatLieu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboChatLieu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Chất Liệu:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Giá Tiền:");

        txtGiaTien.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtMoTa.setColumns(20);
        txtMoTa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMoTa.setRows(5);
        txtMoTa.setText("Mô tả mặc định");
        txtMoTa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtMoTaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(txtMoTa);

        cboDonViTinh.setEditable(true);
        cboDonViTinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboDonViTinh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cboTrangThai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn hàng", "Hết hàng" }));
        cboTrangThai.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Tên chi tiết: ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Đơn Vị Tính:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Trạng Thái:");

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSua.setText("Cập Nhật");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThem.setText("Thêm Sản Phẩm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        txtTenCT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTenCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtTenCTMousePressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Giới Tính:");

        cboDanhMuc.setEditable(true);
        cboDanhMuc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Danh Mục:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tên Sản Phẩm:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nhà Sản Xuất:");

        cboNhaSX.setEditable(true);
        cboNhaSX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboNhaSX.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
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

        btnThemCboTenSP.setText("+");
        btnThemCboTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCboTenSPActionPerformed(evt);
            }
        });

        cboTenSP.setEditable(true);
        cboTenSP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboTenSP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cboGioiTinh.setEditable(true);
        cboGioiTinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Mô Tả:");

        btnThemCboGioiTinh.setText("+");
        btnThemCboGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCboGioiTinhActionPerformed(evt);
            }
        });

        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Số Lượng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSoLuong)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtMaSp)
                        .addComponent(cboKichCo, 0, 215, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtGiaTien)
                            .addComponent(cboChatLieu, 0, 193, Short.MAX_VALUE)
                            .addComponent(cboMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cboTenSP, 0, 212, Short.MAX_VALUE)
                            .addComponent(cboNhaSX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemCboNSX)
                    .addComponent(btnThemCboMauSac)
                    .addComponent(btnThemCboKichCo)
                    .addComponent(btnThemCboChatLieu)
                    .addComponent(btnThemCboTenSP))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
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
                    .addComponent(btnThemCboDanhMuc)
                    .addComponent(btnThemCboDonVi)
                    .addComponent(btnThemCboGioiTinh))
                .addGap(28, 28, 28))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addComponent(jLabel14))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(btnLamMoi)
                        .addGap(134, 134, 134)
                        .addComponent(btnSua)
                        .addGap(140, 140, 140)
                        .addComponent(btnThem)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboDanhMuc, cboDonViTinh, cboGioiTinh, cboTrangThai, jScrollPane2, txtTenCT});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboChatLieu, cboKichCo, cboMauSac, cboNhaSX, cboTenSP, txtGiaTien, txtMaSp});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel14)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenCT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtMaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemCboDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemCboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(btnThemCboDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(cboTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboNhaSX, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnThemCboTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnThemCboNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
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
                                .addComponent(btnThemCboKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnThemCboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnThemCboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamMoi)
                    .addComponent(btnSua)
                    .addComponent(btnThem))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(565, 565, 565))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (validateSP()) {
            return;
        }
        suaSP();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        clearForm();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (validateSP()) {
            return;
        }
        themSP();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnThemCboDonViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCboDonViActionPerformed
        String donVi = cboDonViTinh.getSelectedItem().toString();

        if (checkValidateCombo(cboDonViTinh)) {
            return;
        }
        if (!helper.MsgBox.confirm(null, "Bạn có muốn thêm " + donVi + " vào hệ thống?")) {
            return;
        }

        XJdbc.update("insert into DonViTinh(DonViTinh) values(?)", donVi);
        fillComboDonVi();
        cboDonViTinh.setSelectedIndex(cboDonViTinh.getItemCount() - 1);
    }//GEN-LAST:event_btnThemCboDonViActionPerformed

    private void btnThemCboDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCboDanhMucActionPerformed
        String danhMuc = cboDanhMuc.getSelectedItem().toString();

        if (checkValidateCombo(cboDanhMuc)) {
            return;
        }
        if (!helper.MsgBox.confirm(null, "Bạn có muốn thêm " + danhMuc + " vào hệ thống?")) {
            return;
        }

        XJdbc.update("insert into DanhMucSP(TenDanhMuc) values(?)", danhMuc);
        fillComboDanhMuc();
        cboDanhMuc.setSelectedIndex(cboDanhMuc.getItemCount() - 1);
    }//GEN-LAST:event_btnThemCboDanhMucActionPerformed

    private void btnThemCboNSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCboNSXActionPerformed
        String nhaSX = cboNhaSX.getSelectedItem().toString();

        if (checkValidateCombo(cboNhaSX)) {
            return;
        }
        if (!helper.MsgBox.confirm(null, "Bạn có muốn thêm " + nhaSX + " vào hệ thống?")) {
            return;
        }

        XJdbc.update("insert into NhaSanXuat(TenNhaSX) values(?)", nhaSX);
        fillComboNSX();
        cboNhaSX.setSelectedIndex(cboNhaSX.getItemCount() - 1);
    }//GEN-LAST:event_btnThemCboNSXActionPerformed

    private void btnThemCboMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCboMauSacActionPerformed
        String mauSac = cboMauSac.getSelectedItem().toString();

        if (checkValidateCombo(cboMauSac)) {
            return;
        }
        if (!helper.MsgBox.confirm(null, "Bạn có muốn thêm " + mauSac + " vào hệ thống?")) {
            return;
        }

        XJdbc.update("insert into MauSac(MauSac) values(?)", mauSac);
        fillComboMauSac();
        cboMauSac.setSelectedIndex(cboMauSac.getItemCount() - 1);
    }//GEN-LAST:event_btnThemCboMauSacActionPerformed

    private void btnThemCboKichCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCboKichCoActionPerformed
        String kichCo = cboKichCo.getSelectedItem().toString();

        if (checkValidateCombo(cboKichCo)) {
            return;
        }
        if (!helper.MsgBox.confirm(null, "Bạn có muốn thêm " + kichCo + " vào hệ thống?")) {
            return;
        }

        XJdbc.update("insert into KichCoSP(KichCo) values(?)", kichCo);
        fillComboKichCo();
        cboKichCo.setSelectedIndex(cboKichCo.getItemCount() - 1);
    }//GEN-LAST:event_btnThemCboKichCoActionPerformed

    private void btnThemCboChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCboChatLieuActionPerformed
        String chatLieu = cboChatLieu.getSelectedItem().toString();

        if (checkValidateCombo(cboChatLieu)) {
            return;
        }
        if (!helper.MsgBox.confirm(null, "Bạn có muốn thêm " + chatLieu + " vào hệ thống?")) {
            return;
        }

        XJdbc.update("insert into ChatLieu(ChatLieuSP) values(?)", chatLieu);
        fillComboChatLieu();
        cboChatLieu.setSelectedIndex(cboChatLieu.getItemCount() - 1);
    }//GEN-LAST:event_btnThemCboChatLieuActionPerformed

    private void btnThemCboTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCboTenSPActionPerformed
        NhaSanXuat nsx = (NhaSanXuat) cboNhaSX.getSelectedItem();
        DanhMuc dm = (DanhMuc) cboDanhMuc.getSelectedItem();
        int idDM = dm.getIdDanhMuc();
        int idNSX = nsx.getIdNhaSanXuat();
        String tenSP = cboTenSP.getSelectedItem().toString();
        int trangThai = cboTrangThai.getSelectedIndex() + 1;

        if (checkValidateCombo(cboTenSP)) {
            return;
        }
        if (!helper.MsgBox.confirm(null, "Bạn có muốn thêm Sản phẩm " + tenSP
                + " trong Danh mục " + cboDanhMuc.getSelectedItem().toString()
                + "\nvà có Nhà SX là " + cboNhaSX.getSelectedItem().toString() + " vào hệ thống?")) {
            return;
        }

        XJdbc.update("insert into SanPham(IDDanhMuc, IDNhaSanXuat, TenSanPham, TrangThai)\n"
                + "values(?, ?, ?, ?)", idDM, idNSX, tenSP, trangThai);
        fillcomboTenSP();
        cboTenSP.setSelectedIndex(cboTenSP.getItemCount() - 1);
    }//GEN-LAST:event_btnThemCboTenSPActionPerformed

    private void btnThemCboGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCboGioiTinhActionPerformed
        String gioiTinh = cboGioiTinh.getSelectedItem().toString();

        if (checkValidateCombo(cboGioiTinh)) {
            return;
        }
        if (!helper.MsgBox.confirm(null, "Bạn có muốn thêm " + gioiTinh + " vào hệ thống?")) {
            return;
        }

        XJdbc.update("insert into GioiTinh(GioiTinh) values(?)", gioiTinh);
        fillComboGioiTinh();
        cboGioiTinh.setSelectedIndex(cboGioiTinh.getItemCount() - 1);
    }//GEN-LAST:event_btnThemCboGioiTinhActionPerformed

    private void tblDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMouseClicked
        row = tblDanhSach.getSelectedRow();
    }//GEN-LAST:event_tblDanhSachMouseClicked

    private void tblDanhSachMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMousePressed
        if (evt.getClickCount() == 2) {
            row = tblDanhSach.getSelectedRow();
            txtTimKiem.setText("");
            String tk = txtTimKiem.getText();
            filterTable(tk);
            setForm();
        }
    }//GEN-LAST:event_tblDanhSachMousePressed

    private void txtTenCTMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenCTMousePressed
        if (evt.getClickCount() == 2) {
            setTenCT();
        }
    }//GEN-LAST:event_txtTenCTMousePressed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        String tk = txtTimKiem.getText();
        filterTable(tk);
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void txtMoTaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMoTaMousePressed
        if (evt.getClickCount() == 2) {
            txtMoTa.setText("Mô tả mặc định");
        }
    }//GEN-LAST:event_txtMoTaMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemCboChatLieu;
    private javax.swing.JButton btnThemCboDanhMuc;
    private javax.swing.JButton btnThemCboDonVi;
    private javax.swing.JButton btnThemCboGioiTinh;
    private javax.swing.JButton btnThemCboKichCo;
    private javax.swing.JButton btnThemCboMauSac;
    private javax.swing.JButton btnThemCboNSX;
    private javax.swing.JButton btnThemCboTenSP;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboDanhMuc;
    private javax.swing.JComboBox<String> cboDonViTinh;
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JComboBox<String> cboKichCo;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboNhaSX;
    private javax.swing.JComboBox<String> cboTenSP;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenCT;
    private javax.swing.JTextField txtTimKiem;
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
        setTenCT();
    }

    private void fillTable() {
        model.setRowCount(0);
        try {
            String sql = "select MaSanPham, TenChiTiet, TenDanhMuc, ChatLieuSP, MauSac, KichCo, GioiTinh, TenNhaSX, GiaTien, Soluong from ChiTietSanPham\n"
                    + "inner join MauSac on MauSac.IDMauSac=ChiTietSanPham.IDMauSac\n"
                    + "inner join DonViTinh on DonViTinh.IDDonViTinh = ChiTietSanPham.IDDonViTinh\n"
                    + "inner join ChatLieu on ChatLieu.IDChatLieu=ChiTietSanPham.IDChatLieu\n"
                    + "inner join GioiTinh on GioiTinh.IDGioiTinh=ChiTietSanPham.IDgioiTinh\n"
                    + "inner join KichCoSP on KichCoSP.IDKichCo=ChiTietSanPham.IDKichCo\n"
                    + "inner join SanPham on ChiTietSanPham.IDSanPham=SanPham.IDSanPham\n"
                    + "inner join DanhMucSP on DanhMucSP.IDDanhMuc=SanPham.IDDanhMuc\n"
                    + "inner join NhaSanXuat on NhaSanXuat.IDNhaSanXuat=SanPham.IDNhaSanXuat";
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                String maSP = rs.getString("MaSanPham");
                String tenSP = rs.getString("TenChiTiet");
                String danhMuc = rs.getString("TenDanhMuc");
                String chatLieu = rs.getString("ChatLieuSP");
                String mauSac = rs.getString("MauSac");
                String kichCo = rs.getString("KichCo");
                String gioiTinh = rs.getString("GioiTinh");
                String nhaSanXuat = rs.getString("TenNhaSX");
                int giaTien = rs.getInt("GiaTien");
                int soLuong = rs.getInt("Soluong");
                model.addRow(new Object[]{maSP, tenSP, danhMuc, chatLieu, mauSac, kichCo, gioiTinh, nhaSanXuat, giaTien, soLuong});
            }
            rs.close();
        } catch (Exception e) {
            helper.MsgBox.alert(null, "Lỗi table");
        }
    }

    void setForm() {
        String maSp = tblDanhSach.getValueAt(row, 0).toString();
        txtMaSp.setText(maSp);
        cboTrangThai.setSelectedIndex(Integer.valueOf(tblDanhSach.getValueAt(row, 9).toString()) > 0 ? 0 : 1);
        txtTenCT.setText(tblDanhSach.getValueAt(row, 1) + "");
        txtGiaTien.setText(tblDanhSach.getValueAt(row, 8) + "");
        txtSoLuong.setText(tblDanhSach.getValueAt(row, 9) + "");
        
        try {
            ChiTietSanPham ctsp = chitietspDao.selectByMa(maSp);
            SanPham sp = spDao.selectById(ctsp.getIdSanPham());
            cboTenSP.setSelectedItem(sp);
            DanhMuc dm = ttDao.selectByIDDanhMuc(sp.getIdDanhMuc());
            cboDanhMuc.setSelectedItem(dm);
            NhaSanXuat nsx = ttDao.selectByIDNSX(sp.getIdNhaSanXuat());
            cboNhaSX.setSelectedItem(nsx);
            GioiTinh gt = ttDao.selectByIDGioiTinh(ctsp.getIdGioiTinh());
            cboGioiTinh.setSelectedItem(gt);
            KichCo kc = ttDao.selectByIDKichCo(ctsp.getIdKichCo());
            cboKichCo.setSelectedItem(kc);
            MauSac ms = ttDao.selectByIDMauSac(ctsp.getIdMauSac());
            cboMauSac.setSelectedItem(ms);
            ChatLieu cl = ttDao.selectByIDChatLieu(ctsp.getIdChatLieu());
            cboChatLieu.setSelectedItem(cl);
            DonViTinh dvt = ttDao.selectByIDDonViTinh(ctsp.getIdDonViTinh());
            cboDonViTinh.setSelectedItem(dvt);
        } catch (Exception e) {
            helper.MsgBox.alert(this, "Lỗi set form");
        }
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
        cboTenSP.setSelectedIndex(0);
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
        cboDanhMuc.setSelectedIndex(0);
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
        cboNhaSX.setSelectedIndex(0);
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
        cboKichCo.setSelectedIndex(0);
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
        cboMauSac.setSelectedIndex(0);
    }

    private void fillComboChatLieu() {
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
        cboChatLieu.setSelectedIndex(0);
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
        cboDonViTinh.setSelectedIndex(0);
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
        cboGioiTinh.setSelectedIndex(0);
    }

    private boolean checkValidateCombo(JComboBox cbo) {
        String temp = cbo.getSelectedItem().toString();
        int size = cbo.getItemCount();
        for (int j = 0; j < size; j++) {
            if (temp.equalsIgnoreCase(cbo.getItemAt(j).toString())) {
                helper.MsgBox.alert(null, temp + " là giá trị đã có sẵn, không được thêm trùng!");
                return true;
            }
        }
        if (temp.equals("")) {
            helper.MsgBox.alert(null, "Giá trị thêm mới không được trống!");
            return true;
        }
        return false;
    }

    private void clearForm() {
        txtGiaTien.setText("");
        txtMaSp.setText("Mã sản phẩm tự sinh");
        txtMoTa.setText("Mô tả mặc định");
        txtSoLuong.setText("");
        txtTenCT.setText("");
    }

    private boolean validateSP() {
        if (txtTenCT.getText().equalsIgnoreCase("")) {
            helper.MsgBox.alert(null, "Xin mời nhập tên chi tiết cho sản phẩm");
            txtTenCT.requestFocus();
            return true;
        }
        double giaTien;
        if (txtSoLuong.getText().equalsIgnoreCase("")) {
            helper.MsgBox.alert(null, "Xin mời nhập giá tiền cho sản phẩm");
            txtSoLuong.requestFocus();
            return true;
        }
        try {
            giaTien = Double.parseDouble(txtGiaTien.getText());
        } catch (Exception e) {
            helper.MsgBox.alert(null, "Xin mời nhập giá tiền sản phẩm là số");
            txtGiaTien.requestFocus();
            return true;
        }
        if (giaTien <= 0) {
            helper.MsgBox.alert(null, "Xin mời nhập giá tiền sản phẩm là số lớn hơn 0");
            txtGiaTien.requestFocus();
            return true;
        }
        int soLuong;
        if (txtSoLuong.getText().equalsIgnoreCase("")) {
            helper.MsgBox.alert(null, "Xin mời nhập số lượng cho sản phẩm");
            txtSoLuong.requestFocus();
            return true;
        }
        try {
            soLuong = Integer.parseInt(txtSoLuong.getText());
        } catch (Exception e) {
            helper.MsgBox.alert(null, "Xin mời nhập số lượng sản phẩm là số");
            txtSoLuong.requestFocus();
            return true;
        }
        if (soLuong < 0) {
            helper.MsgBox.alert(null, "Xin mời nhập số lượng sản phẩm là số lớn hơn hoặc = 0");
            txtSoLuong.requestFocus();
            return true;
        }
        if (txtMoTa.getText().equalsIgnoreCase("")) {
            helper.MsgBox.alert(null, "Xin mời nhập mô tả cho sản phẩm");
            txtMoTa.requestFocus();
            return true;
        }
        return false;
    }

    public ChiTietSanPham getForm() {
        SanPham sp = (SanPham) cboTenSP.getSelectedItem();
        ChatLieu cl = (ChatLieu) cboChatLieu.getSelectedItem();
        DonViTinh dv = (DonViTinh) cboDonViTinh.getSelectedItem();
        GioiTinh gt = (GioiTinh) cboGioiTinh.getSelectedItem();
        KichCo kc = (KichCo) cboKichCo.getSelectedItem();
        MauSac ms = (MauSac) cboMauSac.getSelectedItem();

        ChiTietSanPham ct = new ChiTietSanPham();
        ct.setMaSP("SP" + (tblDanhSach.getRowCount() + 1));
        ct.setIdChatLieu(cl.getIdChatLieu());
        ct.setIdDonViTinh(dv.getIdDonViTinh());
        ct.setIdGioiTinh(gt.getIdGioiTinh());
        ct.setIdKichCo(kc.getIdKichCo());
        ct.setIdMauSac(ms.getIdMauSac());
        ct.setIdSanPham(sp.getIdSanPham());
        ct.setMoTa(txtMoTa.getText());
        ct.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
        ct.setTenCT(txtTenCT.getText());
        ct.setTrangThai(cboTrangThai.getSelectedIndex() + 1);
        ct.setIdChiTietSP(row < 0 ? 0 : row);
        ct.setGiaTien(Float.valueOf(txtGiaTien.getText()));
        return ct;
    }

    private void themSP() {
        ChiTietSanPham sp = getForm();
        chitietspDao.insert(sp);
        fillTable();
        helper.MsgBox.alert(null, "Thêm sản phẩm thành công");
    }

    private void suaSP() {
        ChiTietSanPham sp = getForm();
        chitietspDao.update(sp);
        fillTable();
        helper.MsgBox.alert(null, "Sửa sản phẩm thành công");
    }

    private void setTenCT() {
        txtTenCT.setText(cboTenSP.getSelectedItem().toString() + " " + cboGioiTinh.getSelectedItem().toString() + " " + cboMauSac.getSelectedItem().toString());
    }

    private void filterTable(String tk) {
        ts = new TableRowSorter<>(model);
        tblDanhSach.setRowSorter(ts);
        if (tk.trim().length() == 0) {
            ts.setRowFilter(null);
        } else {
            ts.setRowFilter(RowFilter.regexFilter("(?i)" + tk));
        }
    }
    
}
