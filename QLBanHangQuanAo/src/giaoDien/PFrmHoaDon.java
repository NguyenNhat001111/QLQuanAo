package giaoDien;

import DAO.ChiTietSanPhamDAO;
import DAO.SanPhamDAO;
import MODELS.TaiKhoan;
import helper.Auth;
import helper.XJdbc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class PFrmHoaDon extends javax.swing.JPanel {

    Timer t;
    DefaultTableModel modelHoaDon;
    DefaultTableModel modelKhachHang;
    DefaultTableModel modelDanhSachSP;
    DefaultTableModel modelSanPhamDatMua;
    DefaultTableModel modelHoaDonCho;
    SanPhamDAO daoSP = new SanPhamDAO();
    ChiTietSanPhamDAO daoctsp;
    TableRowSorter<DefaultTableModel> ts;
    int index = 0;
    int indexSPDM = 0;
    int row = -1;
    int i = 0;
    int tongTien = 0;
    int idHoaDon = -1;
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-YYYY");
    String ngay = sdf.format(new Date());
    int MaHD = 0;

    public PFrmHoaDon() {
        initComponents();
        ActionListener a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
                lblNgay.setText(sdf.format(new Date()));
                int tongTien = 0;
                int giamGia = 0;

                for (int j = 0; j < tblThongTinSanPhamDatMua.getRowCount(); j++) {
                    tongTien += Integer.valueOf(tblThongTinSanPhamDatMua.getValueAt(j, 4).toString());
                }
                lblTongTien1.setText(tongTien + "");
                lblTongTien.setText(tongTien + "");
                try {
                    int tienKhachThanhToan = Integer.valueOf(txtKhachThanhToan1.getText());
                    if (tienKhachThanhToan >= tongTien) {
                        int tienTraLai = tienKhachThanhToan - tongTien;
                        lblTienThua1.setText(tienTraLai + "");
                    } else {
                        lblTienThua1.setText("0");
                    }
                } catch (Exception e) {

                }
                try {
                    int tienKhachThanhToan = Integer.valueOf(txtKhachThanhToan.getText());
                    if (tienKhachThanhToan >= tongTien) {
                        int tienTraLai = tienKhachThanhToan - tongTien;
                        lblTienThua.setText(tienTraLai + "");
                    } else {
                        lblTienThua.setText("0");
                    }
                } catch (Exception e) {

                }
            }
        };
        t = new Timer(500, a);
        t.start();
        modelHoaDon = (DefaultTableModel) tblThongTinHoaDon.getModel();
        modelKhachHang = (DefaultTableModel) tblThongTinKhachHang.getModel();
        modelDanhSachSP = (DefaultTableModel) tblThongTinDanhSachSanPham.getModel();
        modelSanPhamDatMua = (DefaultTableModel) tblThongTinSanPhamDatMua.getModel();
        modelHoaDonCho = (DefaultTableModel) tblHoaDonCho.getModel();
        fillToTableHoaDon();
        fillToTableKhachHang();
        fillToTableDanhSachSP();
        fillToHoadonCho();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDonCho = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        btnThemDon = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongTinSanPhamDatMua = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblThongTinDanhSachSanPham = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnCapNhat = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblSoHD = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblTongTien = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtGhichu = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        lblTienThua = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblNgay = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cboHinhThucTT = new javax.swing.JComboBox<>();
        txtKhachThanhToan = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        lblNgay1 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lblSoHD1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblTongTien1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        cboHinhThucTT1 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        txtKhachThanhToan1 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        lblTienThua1 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        btnTraHang = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblThongTinKhachHang = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblThongTinHoaDon = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtTimKiem1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTimKiem2 = new javax.swing.JTextField();

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setPreferredSize(new java.awt.Dimension(520, 610));

        tblHoaDonCho.setBackground(new java.awt.Color(204, 255, 255));
        tblHoaDonCho.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        tblHoaDonCho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaHD", "Ngày Lập", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDonCho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonChoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDonCho);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel22.setText("Hoá đơn chờ");

        btnThemDon.setBackground(new java.awt.Color(51, 153, 255));
        btnThemDon.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        btnThemDon.setText("Tạo Hoá Đơn");
        btnThemDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThemDon, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThemDon, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );

        jPanel7.setBackground(new java.awt.Color(204, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setPreferredSize(new java.awt.Dimension(574, 610));

        tblThongTinSanPhamDatMua.setBackground(new java.awt.Color(204, 255, 255));
        tblThongTinSanPhamDatMua.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        tblThongTinSanPhamDatMua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThongTinSanPhamDatMua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongTinSanPhamDatMuaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblThongTinSanPhamDatMuaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblThongTinSanPhamDatMua);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel21.setText("Sản phẩm đặt mua");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Danh sách sản phẩm");

        tblThongTinDanhSachSanPham.setBackground(new java.awt.Color(204, 255, 255));
        tblThongTinDanhSachSanPham.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblThongTinDanhSachSanPham.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        tblThongTinDanhSachSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên Sản Phẩm", "Danh Mục", "Chất Liệu", "Màu Sắc", "Kích Cỡ", "Nhà Sản Xuất", "Giá Tiền", "Số Lượng", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThongTinDanhSachSanPham.setRowHeight(22);
        tblThongTinDanhSachSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongTinDanhSachSanPhamMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblThongTinDanhSachSanPhamMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblThongTinDanhSachSanPham);

        txtTimKiem.setText("   ");
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel13.setText("Tìm kiếm sản phẩm :");

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(390, 390, 390))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(305, 305, 305))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(354, 354, 354))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel14.setText("Hóa đơn bán hàng");

        jTabbedPane2.setBackground(new java.awt.Color(204, 255, 255));
        jTabbedPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setText("Ngày :");

        lblSoHD.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblSoHD.setText("-1");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel3.setText("Số HĐ :");

        lblTongTien.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblTongTien.setText("0.000 VNĐ");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setText("Tổng tiền hàng :");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel11.setText("Khách thanh toán :");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel12.setText("Tiền thừa trả lại khách :");

        txtGhichu.setColumns(20);
        txtGhichu.setRows(5);
        jScrollPane4.setViewportView(txtGhichu);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel15.setText("Ghi chú :");

        jButton12.setBackground(new java.awt.Color(51, 153, 255));
        jButton12.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButton12.setText("Thanh Toán");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        lblTienThua.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblTienThua.setText("0.000 ");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel23.setText("Hoá đơn");

        lblNgay.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblNgay.setText("Ngày hôm nay");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel29.setText("Hình thức thanh toán");

        cboHinhThucTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển tiền" }));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel31.setText("VNĐ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNgay)
                            .addComponent(lblSoHD))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtKhachThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(120, 120, 120)
                                .addComponent(lblTongTien)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel23))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(0, 45, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(58, 58, 58)
                        .addComponent(lblTienThua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboHinhThucTT, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblNgay))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblSoHD))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblTongTien))
                .addGap(77, 77, 77)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtKhachThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblTienThua)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(cboHinhThucTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        jTabbedPane2.addTab("Thanh toán", jPanel6);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel28.setText("Hoá đơn đặt hàng");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel17.setText("Tên khách hàng : ");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel18.setText("Số điện thoại : ");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel19.setText("Địa chỉ :");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel20.setText("Ngày :");

        lblNgay1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblNgay1.setText("Ngày hôm nay");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel30.setText("Số HĐ :");

        lblSoHD1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblSoHD1.setText("HD01");

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButton1.setText("Giao Hàng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblTongTien1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblTongTien1.setText("0.000 ");

        jLabel32.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel32.setText("Tổng tiền hàng :");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel33.setText("Hình thức thanh toán:");

        cboHinhThucTT1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển tiền" }));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel37.setText("Khách thanh toán :");

        jLabel38.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel38.setText("Tiền thừa trả lại khách :");

        lblTienThua1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        lblTienThua1.setText("0.000 ");

        jLabel39.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel39.setText("VNĐ");

        btnTraHang.setBackground(new java.awt.Color(51, 153, 255));
        btnTraHang.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        btnTraHang.setText("Trả hàng");
        btnTraHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraHangActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel40.setText("VNĐ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboHinhThucTT1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel19)
                                                .addGap(82, 82, 82))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblTongTien1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel40))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel28)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel30)
                                                .addGap(53, 53, 53)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblSoHD1)
                                                    .addComponent(lblNgay1))))
                                        .addGap(45, 45, 45)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTienThua1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel39)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtKhachThanhToan1)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDiaChi, txtKhachThanhToan1, txtSDT, txtTenKhachHang});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(lblSoHD1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lblNgay1))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(lblTongTien1)
                    .addComponent(jLabel40))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtKhachThanhToan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(lblTienThua1)
                    .addComponent(jLabel39))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboHinhThucTT1)
                    .addComponent(jLabel33))
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtDiaChi, txtSDT, txtTenKhachHang});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnTraHang, jButton1});

        jTabbedPane2.addTab("Giao Hàng", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 971, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(651, 651, 651)
                        .addComponent(jLabel14)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 966, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tạo hoá đơn", jPanel2);

        jPanel3.setBackground(new java.awt.Color(102, 255, 255));

        jPanel8.setBackground(new java.awt.Color(153, 255, 255));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel24.setText("Danh sách hoá đơn");

        tblThongTinKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        tblThongTinKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Tên khách hàng", "Địa chỉ", "Điện thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblThongTinKhachHang);

        tblThongTinHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        tblThongTinHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã hoá đơn", "Ngày lập ", "Tổng tiền", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblThongTinHoaDon);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel26.setText("Thông tin khách hàng");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        jLabel27.setText("Thông tin hoá đơn");

        txtTimKiem1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiem1KeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel4.setText("Tìm kiếm :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel5.setText("Tìm kiếm :");

        txtTimKiem2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiem2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(199, 199, 199))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(278, 278, 278))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(640, 640, 640))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel24)
                .addGap(56, 56, 56)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh sách hoá đơn", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblThongTinDanhSachSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongTinDanhSachSanPhamMouseClicked
        row = tblThongTinDanhSachSanPham.getSelectedRow();
    }//GEN-LAST:event_tblThongTinDanhSachSanPhamMouseClicked

    private void tblThongTinDanhSachSanPhamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongTinDanhSachSanPhamMousePressed
        if (evt.getClickCount() == 2) {
            this.row = tblThongTinDanhSachSanPham.rowAtPoint(evt.getPoint());
            insertSanPhamDatMua();
        }
    }//GEN-LAST:event_tblThongTinDanhSachSanPhamMousePressed

    private void btnThemDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDonActionPerformed

        boolean a = helper.MsgBox.confirm(this, "Bạn có muốn tạo hoá đơn mới");
        if (!a) {
            return;
        }
        TaoHoaDon();
    }//GEN-LAST:event_btnThemDonActionPerformed

    private void tblHoaDonChoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonChoMouseClicked
        index = tblHoaDonCho.getSelectedRow();
        MaHD = Integer.valueOf(modelHoaDonCho.getValueAt(index, 0).toString());
        showDetail();

    }//GEN-LAST:event_tblHoaDonChoMouseClicked

    private void tblThongTinSanPhamDatMuaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongTinSanPhamDatMuaMousePressed
        if (evt.getClickCount() == 2) {
            this.row = tblThongTinSanPhamDatMua.rowAtPoint(evt.getPoint());
            updateSoLuong();
            fillToTableHoaDon();
            fillToTableKhachHang();
        }
    }//GEN-LAST:event_tblThongTinSanPhamDatMuaMousePressed

    private void tblThongTinSanPhamDatMuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongTinSanPhamDatMuaMouseClicked
        indexSPDM = tblThongTinSanPhamDatMua.getSelectedRow();
    }//GEN-LAST:event_tblThongTinSanPhamDatMuaMouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed

    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        String tk = txtTimKiem.getText();
        filterTable(tk);
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if (modelSanPhamDatMua.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Hoá đơn chưa có sản phẩm nào");
            return;
        }

        fillToHoadonCho();
        fillToSanPhamDatMuaTheoId();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (modelSanPhamDatMua.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Hoá đơn chưa có sản phẩm nào");
            return;
        }
        boolean a = helper.MsgBox.confirm(this, "Bạn có muốn thanh toán ");
        if (!a) {
            return;
        }
        thanhToanHoaDon();
        modelSanPhamDatMua.setRowCount(0);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (modelSanPhamDatMua.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Hoá đơn chưa có sản phẩm nào");
            return;
        }
        try {
            if (checkRong()) {
                return;
            }
            if (checkSDT()) {
                return;
            }
            boolean a = helper.MsgBox.confirm(this, "Bạn có muốn giao hàng");
            if (!a) {
                return;
            }
            taoKhachHang();
            giaoHang();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTraHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraHangActionPerformed
        if (modelSanPhamDatMua.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Hoá đơn chưa có sản phẩm nào");
            return;
        }
//        String trangthai = modelHoaDonCho.getValueAt(index, 2).toString();
//        if(trangthai != "Đang vận chuyển"){
//            JOptionPane.showMessageDialog(this,"Đơn hàng chưa đạt yêu cầu để dùng chức năng này");
//            return;
//        }
        boolean a = helper.MsgBox.confirm(this, "Bạn có muốn trả hàng");
        if (!a) {
            return;
        }
        traHang();
    }//GEN-LAST:event_btnTraHangActionPerformed

    private void txtTimKiem1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiem1KeyReleased
        String tk = txtTimKiem1.getText();
        filterTable2(tk);

    }//GEN-LAST:event_txtTimKiem1KeyReleased

    private void txtTimKiem2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiem2KeyReleased
        String tk = txtTimKiem2.getText();
        filterTable3(tk);
    }//GEN-LAST:event_txtTimKiem2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThemDon;
    private javax.swing.JButton btnTraHang;
    private javax.swing.JComboBox<String> cboHinhThucTT;
    private javax.swing.JComboBox<String> cboHinhThucTT1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblNgay;
    private javax.swing.JLabel lblNgay1;
    private javax.swing.JLabel lblSoHD;
    private javax.swing.JLabel lblSoHD1;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTienThua1;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTongTien1;
    private javax.swing.JTable tblHoaDonCho;
    private javax.swing.JTable tblThongTinDanhSachSanPham;
    private javax.swing.JTable tblThongTinHoaDon;
    private javax.swing.JTable tblThongTinKhachHang;
    private javax.swing.JTable tblThongTinSanPhamDatMua;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextArea txtGhichu;
    private javax.swing.JTextField txtKhachThanhToan;
    private javax.swing.JTextField txtKhachThanhToan1;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiem1;
    private javax.swing.JTextField txtTimKiem2;
    // End of variables declaration//GEN-END:variables

    private void fillToTableHoaDon() {
        modelHoaDon.setRowCount(0);
        try {
            String a = null;
            String sql = "select IDHoaDon,NgayLapHoaDon,TongGiaTien,TrangThaiHoaDon from HoaDon";
            PreparedStatement pstm = XJdbc.getStmt(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int idHoaDon = rs.getInt(1);
                String ngayLap = rs.getString(2);
                int tongTien = rs.getInt(3);
                int trangThai = rs.getInt(4);
                if (trangThai == 0) {
                    a = "Đang chờ";
                } else if (trangThai == 1) {
                    a = "Hoàn Thành";
                } else if (trangThai == 2) {
                    a = "Đang vận chuyển";
                } else if (trangThai == 3) {
                    a = "Trả lại";
                }
                modelHoaDon.addRow(new Object[]{idHoaDon, ngayLap, tongTien, a});
            }
            rs.close();
            pstm.close();
        } catch (Exception e) {
        }
    }

    private void fillToTableKhachHang() {
        modelKhachHang.setRowCount(0);
        try {
            int i = 1;
            String sql = "select HoTenKH,DiaChi,SDT from KhachHang";
            PreparedStatement pstm = XJdbc.getStmt(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int stt = i++;
                String Hoten = rs.getString(1);
                String DiaChi = rs.getString(2);
                String SDT = rs.getString(3);
                modelKhachHang.addRow(new Object[]{stt, Hoten, DiaChi, SDT});
            }
            rs.close();
            pstm.close();
        } catch (Exception e) {
        }
    }

    private void fillToTableDanhSachSP() {
        modelDanhSachSP.setRowCount(0);
        try {
            String sql = "select IDCTSP, TenSanPham, TenDanhMuc, ChatLieuSP, MauSac, KichCo, TenNhaSX, GiaTien,Soluong,  ChiTietSanPham.TrangThai from ChiTietSanPham \n"
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
                String MaSp = rs.getString(1);
                String TenSP = rs.getString(2);
                String DanhMuc = rs.getString(3);
                String ChatLieu = rs.getString(4);
                String MauSac = rs.getString(5);
                String KichCo = rs.getString(6);
                String NhaSanXuat = rs.getString(7);
                int GiaTien = rs.getInt(8);
                int SoLuong = rs.getInt(9);
                int TrangThai = rs.getInt(10);
                String a;
                if (TrangThai == 0) {
                    a = "Hết hàng";
                } else {
                    a = "Còn hàng";
                }
                modelDanhSachSP.addRow(new Object[]{MaSp, TenSP, DanhMuc, ChatLieu, MauSac, KichCo, NhaSanXuat, GiaTien, SoLuong, a});
            }
            rs.close();
            pstm.close();
        } catch (Exception e) {
        }

    }

    void insertSanPhamDatMua() {
        idHoaDon = Integer.valueOf(lblSoHD.getText());
        if (idHoaDon < 0) {
            JOptionPane.showMessageDialog(this, "Hoá đơn chưa xác định ");
            return;
        }
        fillToSanPhamDatMuaTheoId();
        int so;
        int maSanPham = 0;
        String maSP = (String) tblThongTinDanhSachSanPham.getValueAt(row, 0);
        int donGia = (Integer) tblThongTinDanhSachSanPham.getValueAt(row, 7);
        int soLuongBanDau = (Integer) tblThongTinDanhSachSanPham.getValueAt(row, 8);
        int maHoaDon = Integer.valueOf(modelHoaDonCho.getValueAt(index, 0).toString());
        modelSanPhamDatMua.setRowCount(0);
        try {
            //Check Trung id san pham 
            String sql0 = "select IDCTSP from HoaDonChiTiet where IDHoaDon = ?";
            PreparedStatement pstm1 = XJdbc.getStmt(sql0);
            pstm1.setInt(1, maHoaDon);
            ResultSet rs = pstm1.executeQuery();
            while (rs.next()) {
                maSanPham = rs.getInt(1);
            }
            if (maSanPham == Integer.valueOf(maSP)) {
                JOptionPane.showMessageDialog(this, "Sản phẩm này đã được thêm trong hoá đơn");
                fillToSanPhamDatMuaTheoId();
                return;
            } else {

//                 String soLuongNhap = helper.MsgBox.prompt(this, "Xin mời nhập số lượng "," 1");
                String soLuongNhap = JOptionPane.showInputDialog(this, "Xin mời nhập số lượng", "1");
                if (tblThongTinDanhSachSanPham.getSelectedRow() < 0) {
                    helper.MsgBox.alert(null, "Xin mời chọn sản phẩm cần mua");
                    return;
                }
                try {
                    so = Integer.parseInt(soLuongNhap);
                } catch (Exception e) {
                    helper.MsgBox.alert(null, "Xin mời nhập số lượng sản phẩm là số");
                    return;
                }
                if (Integer.valueOf(soLuongNhap) <= 0) {
                    helper.MsgBox.alert(null, "Xin mời nhập số lượng lớn hơn 0");
                    return;
                } else {
                    //chon masp vừa click
                    int soLuongMoi = Integer.valueOf(soLuongBanDau) - Integer.valueOf(soLuongNhap);
                    if (soLuongMoi < 0) {
                        JOptionPane.showMessageDialog(this, "Số lượng sản phẩm này không đủ");
                        fillToSanPhamDatMuaTheoId();
                        fillToTableDanhSachSP();
                        return;
                    }
                    //Insert hoa don chi tiet
                    String sql = "insert into HoaDonChiTiet(IDHoaDon, IDCTSP, DonGia, SoLuong, TrangThai) values( ? , ?, ?, ?, ?) ";
                    PreparedStatement pstm = XJdbc.getStmt(sql);
                    pstm.setInt(1, maHoaDon);
                    pstm.setString(2, maSP);
                    pstm.setInt(3, donGia);
                    pstm.setInt(4, Integer.valueOf(soLuongNhap));
                    pstm.setInt(5, 0);
                    int row = pstm.executeUpdate();
//                        // update lai so luong san pham trong database
                    String sql2 = "UPDATE ChiTietSanPham SET Soluong = ? WHERE IDCTSP = ? ";
                    PreparedStatement pstm2 = XJdbc.getStmt(sql2);
                    pstm2.setInt(1, soLuongMoi);
                    pstm2.setString(2, maSP);
                    int row2 = pstm2.executeUpdate();
                    fillToTableDanhSachSP();
                    fillToSanPhamDatMuaTheoId();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void fillToSanPhamDatMuaTheoId() {
        modelSanPhamDatMua.setRowCount(0);
        try {
            int i = 0;
            int maHoaDon = Integer.valueOf(modelHoaDonCho.getValueAt(index, 0).toString());
            String sql1 = "	select ChiTietSanPham.TenChiTiet,HoaDonChiTiet.SoLuong,DonGia,HoaDonChiTiet.TrangThai \n"
                    + "	from HoaDonChiTiet inner join ChiTietSanPham on ChiTietSanPham.IDCTSP = HoaDonChiTiet.IDCTSP \n"
                    + "	where IDHoaDon = ?";
            PreparedStatement pstm1 = XJdbc.getStmt(sql1);
            pstm1.setInt(1, maHoaDon);
            ResultSet rs = pstm1.executeQuery();
            while (rs.next()) {
                i++;
                String tenSP = rs.getString(1);
                int soLuong = rs.getInt(2);
                int donGiaa = rs.getInt(3);
                int trangThai = rs.getInt(4);
                String a;
                if (trangThai == 1) {
                    a = "Trả hàng";
                } else {
                    a = "Thanh toán";
                }
                int thanhTien = donGiaa * soLuong;
                tongTien = tongTien += thanhTien;
                modelSanPhamDatMua.addRow(new Object[]{i, tenSP, soLuong, donGiaa, thanhTien, a});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void TaoHoaDon() {
        txtTenKhachHang.setText("");
        txtSDT.setText("");
        lblTongTien.setText("");
        lblTongTien1.setText("");
        txtDiaChi.setText("");
        cboHinhThucTT.setSelectedIndex(0);
        modelSanPhamDatMua.setRowCount(0);
        try {
            TaiKhoan user = Auth.user;
            int idNguoiDung = user.getIdNguoiDung();
            String sql = "insert into HoaDon(IDNguoiDung, NgayLapHoaDon,TrangThaiHoaDon) values(?,?,?)";
            PreparedStatement pstm = XJdbc.getStmt(sql);
            pstm.setInt(1, idNguoiDung);
            pstm.setString(2, ngay);
            pstm.setInt(3, 0);
            int row = pstm.executeUpdate();
            //Lay ra id HoaDon cuoi cung
            String sql1 = "SELECT MAX(IDHoaDon) FROM HoaDon";
            PreparedStatement pstm2 = XJdbc.getStmt(sql1);
            ResultSet rs = pstm2.executeQuery();
            while (rs.next()) {
                idHoaDon = rs.getInt(1);
                lblSoHD.setText(idHoaDon + "");
            }
            if (row > 0) {
                JOptionPane.showMessageDialog(this, "Tạo hoá đơn mới thành công , id = " + idHoaDon);
            } else {
                JOptionPane.showMessageDialog(this, "Tạo hoá đơn thất bại ");
            }
            modelHoaDonCho.addRow(new Object[]{idHoaDon, ngay});
            fillToTableHoaDon();
            fillToTableKhachHang();
            fillToHoadonCho();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void fillToHoadonCho() {
        try {
            String a = null;
            modelHoaDonCho.setRowCount(0);
            String sql = "select IDHoaDon,NgayLapHoaDon, TrangThaiHoaDon from HoaDon where TrangThaiHoaDon != 1 ";
            PreparedStatement pstm = XJdbc.getStmt(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int idHoaDon = rs.getInt(1);
                String ngayLapHD = rs.getString(2);
                int trangThaiHD = rs.getInt(3);
                if (trangThaiHD == 0) {
                    a = "Đang chờ";
                }
                if (trangThaiHD == 2) {
                    a = "Đang vận chuyển";
                }
                if (trangThaiHD == 3) {
                    a = "Trả hàng";
                }
                modelHoaDonCho.addRow(new Object[]{idHoaDon, ngayLapHD, a});
            }
        } catch (Exception e) {
        }

    }

    private void thanhToanHoaDon() {
        txtTenKhachHang.setText("");
        txtSDT.setText("");
        txtDiaChi.setText("");
        cboHinhThucTT.setSelectedIndex(0);
        modelSanPhamDatMua.setRowCount(0);
        tongTien = Integer.valueOf(lblTongTien.getText());
        String ghiChu = txtGhichu.getText();
        int hinhThucTT = cboHinhThucTT.getSelectedIndex() + 1;
        try {
            idHoaDon = Integer.valueOf(modelHoaDonCho.getValueAt(index, 0).toString());
            // insert hoa don
            String sql6 = "UPDATE HoaDon SET  TongGiaTien = ? ,HinhThucThanhToan = ? ,TrangThaiHoaDon = ? ,GhiChu = ? WHERE IDHoaDon = ?";
            PreparedStatement pstm6 = XJdbc.getStmt(sql6);
            pstm6.setInt(1, tongTien);
            pstm6.setInt(2, hinhThucTT);
            pstm6.setInt(3, 1);
            pstm6.setString(4, ghiChu);
            pstm6.setInt(5, idHoaDon);

            int row2 = pstm6.executeUpdate();
            if (row2 > 0) {
                JOptionPane.showMessageDialog(this, "Hoá đơn đã được thanh toán");
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi thanh toán");
            }
            fillToTableHoaDon();
            fillToTableKhachHang();
            fillToHoadonCho();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showDetail() {
        modelSanPhamDatMua.setRowCount(0);
        lblSoHD.setText(modelHoaDonCho.getValueAt(index, 0).toString());
        lblSoHD1.setText(modelHoaDonCho.getValueAt(index, 0).toString());
        lblNgay.setText(modelHoaDonCho.getValueAt(index, 1).toString());
        lblNgay1.setText(modelHoaDonCho.getValueAt(index, 1).toString());
        tblHoaDonCho.setRowSelectionInterval(index, index);
        fillToSanPhamDatMuaTheoId();
        fillToKhachHang();
    }

    private void updateSoLuong() {
        try {
            String trangthai = modelHoaDonCho.getValueAt(index, 2).toString();
            int idSP = 0;
            //validate
            if (trangthai == "Trả hàng") {
                int soLuong = 0;

                String tenSP = modelSanPhamDatMua.getValueAt(indexSPDM, 1).toString();
                String sql = "select IDCTSP from ChiTietSanPham where TenChiTiet = ?";
                PreparedStatement pstm = XJdbc.getStmt(sql);
                pstm.setString(1, tenSP);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    idSP = rs.getInt(1);
                    String sql1 = "select HoaDonChiTiet.Soluong from HoaDonChiTiet where IDHoaDon = ? and IDCTSP = ?";
                    PreparedStatement pstm1 = XJdbc.getStmt(sql1);
                    pstm1.setInt(1, Integer.valueOf(modelHoaDonCho.getValueAt(index, 0).toString()));
                    pstm1.setInt(2, idSP);
                    ResultSet rs1 = pstm1.executeQuery();
                    while (rs1.next()) {
                        soLuong = rs1.getInt(1);
                    }
                }
                double donGia = Double.valueOf(modelSanPhamDatMua.getValueAt(indexSPDM, 3).toString());
                String trangThai = modelSanPhamDatMua.getValueAt(indexSPDM, 4).toString();
                int c = 0;
                if (trangThai.equalsIgnoreCase("Thanh toán")) {
                    c = 0;
                } else if (trangThai.equalsIgnoreCase("Trả hàng")) {
                    c = 1;
                }
                if (indexSPDM >= 0) {
                    PFrmHoaDonChiTiet_trangThai_soLuong f2 = new PFrmHoaDonChiTiet_trangThai_soLuong(tenSP, MaHD, idSP, soLuong, donGia, c);
                    f2.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "chưa chọn dòng nào");
                }
                fillToTableDanhSachSP();
            } else {
                // update soLuongNhap
                int soLuongNhap = Integer.valueOf(helper.MsgBox.prompt(this, "Nhập 0 để xoá sản phẩm , nhập số lượng mới để cập nhật :"));
                String soLuongTrenBang = modelSanPhamDatMua.getValueAt(indexSPDM, 2).toString();
                int soLuong3 = 0;
                int soLuongSP = 0;
                int soLuongSau = 0;

                String tenSP = modelSanPhamDatMua.getValueAt(indexSPDM, 1).toString();
                String sql = "select IDCTSP,Soluong from ChiTietSanPham where TenChiTiet = ?";
                PreparedStatement pstm = XJdbc.getStmt(sql);
                pstm.setString(1, tenSP);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    idSP = rs.getInt(1);
                    soLuongSP = rs.getInt(2);
                    if (Integer.valueOf(soLuongTrenBang) > soLuongNhap) {
                        soLuong3 = Integer.valueOf(soLuongTrenBang) - soLuongNhap;
                        soLuongSau = soLuong3 + soLuongSP;
                    } else if (Integer.valueOf(soLuongTrenBang) < soLuongNhap) {
                        soLuong3 = soLuongNhap - Integer.valueOf(soLuongTrenBang);
                        soLuongSau = soLuongSP - soLuong3;
                    }
                }
                if (soLuongSau < 0) {
                    JOptionPane.showMessageDialog(this, "Số lượng sản phẩm không đủ");
                    fillToSanPhamDatMuaTheoId();
                    fillToTableDanhSachSP();
                    return;
                } else {
                    if (soLuongNhap > 0) {
                        boolean a = helper.MsgBox.confirm(this, "Bạn có muốn cập nhật số lượng ");
                        if (!a) {
                            return;
                        }
                        String sql2 = "update HoaDonChiTiet set SoLuong = ? where IDHoaDon = ? and IDCTSP = ?";
                        PreparedStatement pstm2 = XJdbc.getStmt(sql2);
                        pstm2.setInt(1, soLuongNhap);
                        pstm2.setInt(2, MaHD);
                        pstm2.setInt(3, idSP);
                        int row2 = pstm2.executeUpdate();
                        modelSanPhamDatMua.setRowCount(0);
                        fillToTableDanhSachSP();
                        fillToSanPhamDatMuaTheoId();
                        fillToTableHoaDon();
                        fillToTableKhachHang();
                    } else {
                        boolean a = helper.MsgBox.confirm(this, "Bạn có muốn xoá sản phẩm ");
                        if (!a) {
                            return;
                        }
                        String sql3 = "DELETE FROM HoaDonChiTiet WHERE IDHoaDon = ? and IDCTSP = ?";
                        PreparedStatement pstm3 = XJdbc.getStmt(sql3);
                        pstm3.setInt(1, MaHD);
                        pstm3.setInt(2, idSP);
                        int row3 = pstm3.executeUpdate();
                        modelSanPhamDatMua.setRowCount(0);
                        fillToTableDanhSachSP();
                        fillToSanPhamDatMuaTheoId();
                        fillToTableHoaDon();
                        fillToTableKhachHang();
                    }

                    String sql0 = "update ChiTietSanPham set SoLuong = ? where IDCTSP = ?";
                    PreparedStatement pstm0 = XJdbc.getStmt(sql0);
                    pstm0.setInt(1, soLuongSau);
                    pstm0.setInt(2, idSP);
                    int row0 = pstm0.executeUpdate();
                    fillToTableDanhSachSP();
                }

            }
            modelSanPhamDatMua.setRowCount(0);
            fillToTableDanhSachSP();
            fillToSanPhamDatMuaTheoId();
            fillToTableHoaDon();
            fillToTableKhachHang();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void filterTable(String tk) {
        ts = new TableRowSorter<>(modelDanhSachSP);
        tblThongTinDanhSachSanPham.setRowSorter(ts);
        if (tk.trim().length() == 0) {
            ts.setRowFilter(null);
        } else {
            ts.setRowFilter(RowFilter.regexFilter("(?i)" + tk));
        }
    }

    private void taoKhachHang() {
        try {
            String tenKH = txtTenKhachHang.getText();
            String SDT = txtSDT.getText();
            String diaChi = txtDiaChi.getText();
            MaHD = Integer.valueOf(modelHoaDonCho.getValueAt(index, 0).toString());
            lblSoHD1.setText(MaHD + "");

            String sql5 = "insert into KhachHang(HoTenKH, SDT, DiaChi) values(?, ?, ?)";
            PreparedStatement pstm5 = XJdbc.getStmt(sql5);
            pstm5.setString(1, tenKH);
            pstm5.setString(2, SDT);
            pstm5.setString(3, diaChi);
            int row = pstm5.executeUpdate();
//             lay id khach hang cuoi cung
            String sql3 = "SELECT MAX(IDKhachHang) FROM KhachHang";
            PreparedStatement pstm3 = XJdbc.getStmt(sql3);
            ResultSet rs3 = pstm3.executeQuery();
            while (rs3.next()) {
                int idKhachHang = rs3.getInt(1);
                String sql4 = "update HoaDon set IDKhachHang = ? where IDHoaDon = ?";
                PreparedStatement pstm = XJdbc.getStmt(sql4);
                pstm.setInt(1, idKhachHang);
                pstm.setInt(2, MaHD);
                int row2 = pstm.executeUpdate();
            }
        } catch (Exception e) {
        }
        fillToTableHoaDon();
        fillToTableKhachHang();
    }

    private boolean checkRong() {
        try {
            if (txtTenKhachHang.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập họ tên khách hàng !");
                txtTenKhachHang.requestFocus();
                return true;
            }
            if (txtSDT.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập SDT !");
                txtSDT.requestFocus();
                return true;
            }
            if (txtDiaChi.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ !");
                txtDiaChi.requestFocus();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean checkSDT() {
        try {
            if (!txtSDT.getText().matches("0\\d{9}")) {
                JOptionPane.showMessageDialog(this, "Mời nhập SDT có 10 chữ số và bắt đầu bằng số 0");
                txtSDT.requestFocus();
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi checkSDT");
        }
        return false;
    }

    private void fillToKhachHang() {
        try {
            String sql = "select HoTenKH,SDT,DiaChi from KhachHang inner join HoaDon on HoaDon.IDKhachHang = KhachHang.IDKhachHang where IDHoaDon =  ?";
            PreparedStatement pstm = XJdbc.getStmt(sql);
            pstm.setInt(1, Integer.valueOf(modelHoaDonCho.getValueAt(index, 0).toString()));
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                txtTenKhachHang.setText(rs.getString(1));
                txtSDT.setText(rs.getString(2));
                txtDiaChi.setText(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void giaoHang() {
        // Insert thông tin khách hàng
        taoKhachHang();
        //
        txtTenKhachHang.setText("");
        txtSDT.setText("");
        lblTongTien.setText("");
        txtDiaChi.setText("");
        modelSanPhamDatMua.setRowCount(0);
        tongTien = Integer.valueOf(lblTongTien1.getText());
        int hinhThucTT = cboHinhThucTT1.getSelectedIndex() + 1;
        try {
            idHoaDon = Integer.valueOf(modelHoaDonCho.getValueAt(index, 0).toString());
            String sql6 = "UPDATE HoaDon SET  TongGiaTien = ? ,HinhThucThanhToan = ? ,TrangThaiHoaDon = ? WHERE IDHoaDon = ?";
            PreparedStatement pstm6 = XJdbc.getStmt(sql6);
            pstm6.setInt(1, tongTien);
            pstm6.setInt(2, hinhThucTT);
            pstm6.setInt(3, 2);
            pstm6.setInt(4, idHoaDon);
            int row2 = pstm6.executeUpdate();
            if (row2 > 0) {
                JOptionPane.showMessageDialog(this, "Tạo hoá đơn giao hàng thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Chưa tạo được");
            }
            fillToTableHoaDon();
            fillToTableKhachHang();
            fillToHoadonCho();
        } catch (Exception e) {
        }
    }

    private void traHangThanhCong() {
        try {
            lblSoHD1.getText();
            String sql = "update HoaDon set TrangThaiHoaDon = ? where IDHoaDon = ?";
            PreparedStatement pstm = XJdbc.getStmt(sql);
            pstm.setInt(1, 1);
            pstm.setInt(2, Integer.valueOf(lblSoHD1.getText()));
            int row = pstm.executeUpdate();
            if (row > 0) {
                JOptionPane.showMessageDialog(this, "Thanh toán thành công");
            }
            fillToTableHoaDon();
            fillToTableKhachHang();
            fillToHoadonCho();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void traHang() {
        try {
            String sql = "update HoaDon set TrangThaiHoaDon = ? where IDHoaDon = ?";
            PreparedStatement pstm = XJdbc.getStmt(sql);
            pstm.setInt(1, 3);
            pstm.setInt(2, MaHD);
            int row = pstm.executeUpdate();
            if (row > 0) {
                JOptionPane.showMessageDialog(this, "Trạng thái hoá đơn : Trả hàng");
            }
            fillToTableHoaDon();
            fillToTableKhachHang();
            fillToHoadonCho();
            fillToSanPhamDatMuaTheoId();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void filterTable2(String tk) {

        ts = new TableRowSorter<>(modelHoaDon);
        tblThongTinHoaDon.setRowSorter(ts);
        if (tk.trim().length() == 0) {
            ts.setRowFilter(null);
        } else {
            ts.setRowFilter(RowFilter.regexFilter("(?i)" + tk));
        }
    }

    private void filterTable3(String tk) {

        ts = new TableRowSorter<>(modelKhachHang);
        tblThongTinKhachHang.setRowSorter(ts);
        if (tk.trim().length() == 0) {
            ts.setRowFilter(null);
        } else {
            ts.setRowFilter(RowFilter.regexFilter("(?i)" + tk));
        }
    }
}
