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
import java.util.regex.Pattern;
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
                lblTongTien.setText(tongTien + "");
                lblKhachCanTra.setText(tongTien - giamGia + "");
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
        fillHoadonCho();
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
        jLabel14 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblSoHD = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblTongTien = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        lblGiamGia = new javax.swing.JLabel();
        lblKhachCanTra = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cboTrangThaiHoaDon = new javax.swing.JComboBox<>();
        lblNgay = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cboHinhThucTT = new javax.swing.JComboBox<>();
        txtKhachThanhToan = new javax.swing.JTextField();
        btnTinhTien = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
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
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jTextField7 = new javax.swing.JTextField();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jTextField8 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblThongTinKhachHang = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblThongTinHoaDon = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setPreferredSize(new java.awt.Dimension(520, 610));

        tblHoaDonCho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaHD", "Ngày Lập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Hoá đơn chờ");

        btnThemDon.setText("Tạo Hoá đơn");
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
                .addGap(86, 86, 86)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(btnThemDon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setPreferredSize(new java.awt.Dimension(574, 610));

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

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Sản phẩm đặt mua");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Danh sách sản phẩm");

        tblThongTinDanhSachSanPham.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblThongTinDanhSachSanPham.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tblThongTinDanhSachSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên Sản Phẩm", "Danh Mục", "Chất Liệu", "Màu Sắc", "Kích Cỡ", "Nhà Sản Xuất", "Giá Tiền", "Số Lượng", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false
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
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(395, 395, 395)
                                .addComponent(jLabel1)
                                .addGap(0, 385, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(327, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel21)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapNhat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setText("Danh sách hoá đơn");

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Ngày :");

        lblSoHD.setText("HD01");

        jLabel3.setText("Số HĐ :");

        lblTongTien.setText("0.000 VNĐ");

        jLabel8.setText("Tổng tiền hàng :");

        jLabel9.setText("Khách cần trả :");

        jLabel10.setText("Giảm giá :");

        jLabel11.setText("Khách thanh toán :");

        jLabel12.setText("Tiền thừa trả lại khách :");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jLabel15.setText("Ghi chú :");

        jLabel16.setText("Trạng thái : ");

        jButton12.setText("Thanh Toán");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        lblGiamGia.setText("0.000 VNĐ");

        lblKhachCanTra.setText("0.000 ");

        lblTienThua.setText("0.000 ");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Hoá đơn đặt hàng");

        cboTrangThaiHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang chờ", "Hoàn thành", "Đang vận chuyển", "Hủy", "Trả lại" }));

        lblNgay.setText("Ngày hôm nay");

        jLabel29.setText("Hình thức thanh toán");

        cboHinhThucTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển tiền" }));

        btnTinhTien.setText("Tính");
        btnTinhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhTienActionPerformed(evt);
            }
        });

        jLabel7.setText("VNĐ");

        jLabel31.setText("VNĐ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNgay)
                                    .addComponent(jLabel23)
                                    .addComponent(lblSoHD)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel16))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 44, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                    .addGap(127, 127, 127)
                                    .addComponent(btnTinhTien))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGap(105, 105, 105)
                                    .addComponent(cboTrangThaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(99, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboHinhThucTT, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(65, 65, 65)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblGiamGia)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(lblKhachCanTra)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))
                                    .addComponent(txtKhachThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(lblTienThua)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel31))
                                    .addComponent(lblTongTien))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblTongTien))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(lblGiamGia))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblKhachCanTra)
                            .addComponent(jLabel7))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel11))
                    .addComponent(txtKhachThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblTienThua)
                    .addComponent(jLabel31))
                .addGap(45, 45, 45)
                .addComponent(btnTinhTien)
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cboTrangThaiHoaDon))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(cboHinhThucTT))
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton12)
                .addGap(40, 40, 40))
        );

        jTabbedPane2.addTab("tab1", jPanel6);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("TẠO KHÁCH HÀNG");

        jLabel17.setText("Tên khách hàng : ");

        jLabel18.setText("Số điện thoại : ");

        jLabel19.setText("Địa chỉ :");

        jLabel20.setText("Ngày :");

        lblNgay1.setText("Ngày hôm nay");

        jLabel30.setText("Số HĐ :");

        lblSoHD1.setText("HD01");

        jButton1.setText("Tạo khách hàng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(lblNgay1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(18, 18, 18)
                                .addComponent(lblSoHD1))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel19)
                                    .addGap(61, 61, 61)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
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
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab2", jPanel1);

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
                        .addGap(753, 753, 753)
                        .addComponent(jLabel14)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Tạo hoá đơn", jPanel2);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel24.setText("Danh sách hoá đơn");

        jCheckBox1.setText("Trạng thái hoá đơn");

        jCheckBox2.setText("Mã hoá đơn");

        jCheckBox4.setText("Lập từ ngày");

        jCheckBox5.setText("Đến ngày :");

        jCheckBox6.setText("Tên khách hàng");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton5.setText("Tìm kiếm");

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
        ));
        jScrollPane5.setViewportView(tblThongTinKhachHang);

        tblThongTinHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hoá đơn", "Ngày lập ", "Tổng tiền", "Thanh toán"
            }
        ));
        jScrollPane6.setViewportView(tblThongTinHoaDon);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Danh sách hoá đơn đã lập");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Thông tin khách hàng");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Thông tin hoá đơn");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(363, 363, 363)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(435, 435, 435))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(545, 545, 545)
                        .addComponent(jLabel24))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox2))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox6)
                                    .addComponent(jCheckBox5))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField8)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(237, 237, 237)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(839, 839, 839)
                        .addComponent(jLabel25)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox4)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox2)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox6)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel25)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel26))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel27)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1787, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 933, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 101, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Danh sách hoá đơn", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1676, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
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
        fillHoadonCho();
        fillToSanPhamDatMuaTheoId();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnTinhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhTienActionPerformed
        tinhTien();
    }//GEN-LAST:event_btnTinhTienActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        thanhToanHoaDon();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        taoKhachHang();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThemDon;
    private javax.swing.JButton btnTinhTien;
    private javax.swing.JComboBox<String> cboHinhThucTT;
    private javax.swing.JComboBox<String> cboTrangThaiHoaDon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblKhachCanTra;
    private javax.swing.JLabel lblNgay;
    private javax.swing.JLabel lblNgay1;
    private javax.swing.JLabel lblSoHD;
    private javax.swing.JLabel lblSoHD1;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JTable tblHoaDonCho;
    private javax.swing.JTable tblThongTinDanhSachSanPham;
    private javax.swing.JTable tblThongTinHoaDon;
    private javax.swing.JTable tblThongTinKhachHang;
    private javax.swing.JTable tblThongTinSanPhamDatMua;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtKhachThanhToan;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
    
    private void fillToTableHoaDon() {
        modelHoaDon.setRowCount(0);
        try {
            int i = 0;
            String sql = "select IDHoaDon,NgayLapHoaDon,TongGiaTien,TrangThaiHoaDon from HoaDon";
            PreparedStatement pstm = XJdbc.getStmt(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int stt = i++;
                int idHoaDon = rs.getInt(1);
                String ngayLap = rs.getString(2);
                int tongTien = rs.getInt(3);
                int trangThai = rs.getInt(4);
                modelHoaDon.addRow(new Object[]{stt, idHoaDon, ngayLap, tongTien, trangThai});
            }
            rs.close();
            pstm.close();
        } catch (Exception e) {
        }
    }

    private void fillToTableKhachHang() {
        modelKhachHang.setRowCount(0);
        try {
            int i = 0;
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
                String a ;
                if(TrangThai == 0){
                    a = "Hết hàng";
                }else{
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

//validate
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
            } else {
                String soLuongNhap = helper.MsgBox.prompt(this, "Xin mời nhập số lượng ");
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
                String a ;
                if(trangThai == 1 ){
                  a = "Trả hàng";
                }else{
                  a = "Thanh toán"  ;
                }
                int thanhTien = donGiaa * soLuong;
                tongTien = tongTien += thanhTien;
                modelSanPhamDatMua.addRow(new Object[]{i, tenSP, soLuong, donGiaa, thanhTien, a});
            }
        } catch (Exception e) {
        }
    }

    private void TaoHoaDon() {
        txtTenKhachHang.setText("");
        txtSDT.setText("");
        lblTongTien.setText("");
        txtDiaChi.setText("");
        cboHinhThucTT.setSelectedIndex(0);
        cboTrangThaiHoaDon.setSelectedIndex(0);
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
        } catch (Exception e) {
        }
    }

    void fillHoadonCho() {
        try {
            modelHoaDonCho.setRowCount(0);
            String sql = "select IDHoaDon,NgayLapHoaDon from HoaDon where TrangThaiHoaDon != 1";
            PreparedStatement pstm = XJdbc.getStmt(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int idHoaDon = rs.getInt(1);
                String ngayLapHD = rs.getString(2);
                modelHoaDonCho.addRow(new Object[]{idHoaDon, ngayLapHD});
            }
        } catch (Exception e) {
        }

    }

    private void thanhToanHoaDon() {
        int hinhThucTT = cboHinhThucTT.getSelectedIndex() + 1;
        int trangThaiHD = cboTrangThaiHoaDon.getSelectedIndex();
        try {
            idHoaDon = Integer.valueOf(modelHoaDonCho.getValueAt(index, 0).toString());
            // insert hoa don
            JOptionPane.showMessageDialog(this, idHoaDon);
            if (cboTrangThaiHoaDon.getSelectedIndex() != 1) {
                JOptionPane.showMessageDialog(this, "Trạng thái hoá đơn phải hoàn thành");
            } else {
                String sql6 = "UPDATE HoaDon SET  TongGiaTien = ? ,HinhThucThanhToan = ? ,TrangThaiHoaDon = ? WHERE IDHoaDon = ?";
                PreparedStatement pstm6 = XJdbc.getStmt(sql6);
                pstm6.setInt(1, tongTien);
                pstm6.setInt(2, hinhThucTT);
                pstm6.setInt(3, trangThaiHD);
                pstm6.setInt(4, idHoaDon);
                int row2 = pstm6.executeUpdate();
                if (row2 > 0) {
                    JOptionPane.showMessageDialog(this, "Hoá đơn đã được thanh toán");
                } else {
                    JOptionPane.showMessageDialog(this, "chua tao dc ");
                }
                fillToTableHoaDon();
                fillToTableKhachHang();
                fillHoadonCho();
            }
        } catch (Exception e) {
        }
    }

    private void showDetail() {
        modelSanPhamDatMua.setRowCount(0);
        fillToSanPhamDatMuaTheoId();
        fillToKhachHang();
        lblSoHD.setText(modelHoaDonCho.getValueAt(index, 0).toString());
        lblSoHD1.setText(modelHoaDonCho.getValueAt(index, 0).toString());
        lblNgay.setText(modelHoaDonCho.getValueAt(index, 1).toString());
        lblNgay1.setText(modelHoaDonCho.getValueAt(index, 1).toString());
        tblHoaDonCho.setRowSelectionInterval(index, index);
    }

    private void updateSoLuong() {
        try {
            //validate
            int a = cboTrangThaiHoaDon.getSelectedIndex();
            if (a == 4) {
                int soLuong = 0;
                int idSP = 0;
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
                double donGia = Double.valueOf(modelSanPhamDatMua.getValueAt(indexSPDM, 3).toString()) ;
                String trangThai = modelSanPhamDatMua.getValueAt(indexSPDM, 4).toString() ;
                int c = 0;
                if(trangThai.equalsIgnoreCase("Thanh toán")){
                    c =  0; 
                }else if(trangThai.equalsIgnoreCase("Trả hàng")){
                    c = 1 ;
                }
                if (indexSPDM >= 0) {
                    PFrmHoaDonChiTiet_trangThai_soLuong f2 = new PFrmHoaDonChiTiet_trangThai_soLuong(tenSP, MaHD, idSP, soLuong, donGia, c);
                    f2.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "chưa chọn dòng nào");
                }
            } else if (a == 0 || a == 2 || a == 3) {
                int soLuong = Integer.valueOf(helper.MsgBox.prompt(this, "Xin mời nhập số lượng mới"));
                int idSP;
                String tenSP = modelSanPhamDatMua.getValueAt(indexSPDM, 1).toString();
                String sql = "select IDCTSP from ChiTietSanPham where TenChiTiet = ?";
                PreparedStatement pstm = XJdbc.getStmt(sql);
                pstm.setString(1, tenSP);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    idSP = rs.getInt(1);
                    if (soLuong > 0) {
                        String sql2 = "update HoaDonChiTiet set SoLuong = ? where IDHoaDon = ? and IDCTSP = ?";
                        PreparedStatement pstm2 = XJdbc.getStmt(sql2);
                        pstm2.setInt(1, soLuong);
                        pstm2.setInt(2, MaHD);
                        pstm2.setInt(3, idSP);
                        int row2 = pstm2.executeUpdate();
                        modelSanPhamDatMua.setRowCount(0);
                        fillToSanPhamDatMuaTheoId();
                        fillToTableHoaDon();
                        fillToTableKhachHang();
                    } else {
                        String sql3 = "DELETE FROM HoaDonChiTiet WHERE IDHoaDon = ? and IDCTSP = ?";
                        PreparedStatement pstm3 = XJdbc.getStmt(sql3);
                        pstm3.setInt(1, MaHD);
                        pstm3.setInt(2, idSP);
                        int row3 = pstm3.executeUpdate();
                        modelSanPhamDatMua.setRowCount(0);
                        fillToSanPhamDatMuaTheoId();
                        fillToTableHoaDon();
                        fillToTableKhachHang();
                    }
                }
            }
            modelSanPhamDatMua.setRowCount(0);
            fillToSanPhamDatMuaTheoId();
            fillToTableHoaDon();
            fillToTableKhachHang();
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tinhTien() {
        try {
            int tienKhachThanhToan = Integer.valueOf(txtKhachThanhToan.getText());
            int tongtien = Integer.valueOf(lblTongTien.getText());
            int tienKhachCanTra = Integer.valueOf(lblKhachCanTra.getText());
            int tienTraLai = tienKhachThanhToan - tienKhachCanTra;
            lblTienThua.setText(tienTraLai + "");
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
//            insert thong tin khach hang
            String tenKH = txtTenKhachHang.getText();
            String SDT = txtSDT.getText();
            String diaChi = txtDiaChi.getText();
            MaHD = Integer.valueOf(modelHoaDonCho.getValueAt(index, 0).toString());
            lblSoHD1.setText(MaHD + "");
            //validate 
            String phone = txtSDT.getText();
            Pattern s = Pattern.compile("^[0-9\\-\\+]{10}$");
            if (s.matcher(phone).find()) {

            } else {
                JOptionPane.showMessageDialog(this, "SDT không đúng định dạng", "Thông báo", JOptionPane.WARNING_MESSAGE);
                txtSDT.requestFocus();
                return;
            }
            String sql5 = "insert into KhachHang(HoTenKH, SDT, DiaChi) values(?, ?, ?)";
            PreparedStatement pstm5 = XJdbc.getStmt(sql5);
            pstm5.setString(1, tenKH);
            pstm5.setString(2, SDT);
            pstm5.setString(3, diaChi);
            int row = pstm5.executeUpdate();
//             lay id khach hang cuoi cung
            JOptionPane.showMessageDialog(this, MaHD);
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
                if (row2 > 0) {
                    JOptionPane.showMessageDialog(this, "Update thanh cng");
                }
            }
        } catch (Exception e) {
        }
        fillToTableHoaDon();
        fillToTableKhachHang();
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
        }
    }

}
