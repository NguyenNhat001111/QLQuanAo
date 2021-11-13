package giaoDien;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Panel;

public class FrmHome extends javax.swing.JFrame {

    /**
     * Creates new form FrmHome
     */
    int index = 0;
    Color mauMeNuChinh = new Color(51, 153, 254);
    Color mauMeNuPhu = new Color(51, 204, 153);
    public FrmHome() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.init();
        execute();
    }

    private void execute() {
        ImageIcon iconStaff = new ImageIcon("D:\\DAM1\\src\\menu\\user.png");
        ImageIcon iconSetting = new ImageIcon("D:\\DAM1\\src\\menu\\setting.png");
        ImageIcon iconDatabase = new ImageIcon("D:\\DAM1\\src\\menu\\database.png");
        ImageIcon iconMessage = new ImageIcon("D:\\DAM1\\src\\menu\\message.png");
        ImageIcon iconSubMenu = new ImageIcon("D:\\DAM1\\src\\menu\\subMenu.png");
        ImageIcon iconNext = new ImageIcon("D:\\DAM1\\src\\menu\\next.png");
        //Tạo Menu Quản Lý quan ao
        MenuItem menuQuan = new MenuItem(mauMeNuPhu, iconSubMenu, "\tQuản lý sản phẩm", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new PFrmQLSanPham());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new PFrmQLSanPham());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });
        MenuItem menuAo = new MenuItem(mauMeNuPhu, iconSubMenu, "\tÁo", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {

                } else {
                    index = 1;

                }
            }
        });

        //Tạo Menu Thanh toan
        MenuItem menuhoadon = new MenuItem(mauMeNuPhu, iconNext, "\tHóa Đơn", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new PFrmHoaDon());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new PFrmHoaDon());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });
        MenuItem menuThongke = new MenuItem(mauMeNuPhu, iconNext, "\tThống Kê", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new PFrmThongKe());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new PFrmThongKe());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });
        MenuItem menuDoanhThu = new MenuItem(mauMeNuPhu, iconNext, "\tDoanh Thu", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {

                } else {
                    index = 1;

                }
            }
        });

        //Tạo Menu taikhoan
        MenuItem menuThongtin = new MenuItem(mauMeNuPhu, iconNext, "\tThông tin", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new Taikhoan());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new Taikhoan());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });
        MenuItem menuĐoimk = new MenuItem(mauMeNuPhu, iconNext, "\tĐổi mật khẩu", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new Doimk());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new Doimk());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });

        //Tạo Menu quẩn lý tài khoản cho Admin 
        MenuItem menuHome = new MenuItem(mauMeNuChinh, iconStaff, "Trang Chủ", null);
        MenuItem menuQLSanpham = new MenuItem(mauMeNuChinh, iconSetting, "Sản Phẩm", null, menuQuan, menuAo);
        MenuItem menuThanhtoan = new MenuItem(mauMeNuChinh, iconDatabase, "Thanh Toán", null, menuhoadon, menuThongke, menuDoanhThu);
        MenuItem menutaikhoan = new MenuItem(mauMeNuChinh, iconDatabase, "Tài Khoản", null, menuThongtin, menuĐoimk);
        MenuItem menuDangxuat = new MenuItem(mauMeNuChinh, iconNext, "Đăng Xuất", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!helper.MsgBox.confirm(null, "Bạn có muốn đăng xuất?")) {
                    return;
                }
                helper.Auth.clear();
                new JFrmLogin(null, true).setVisible(true);   
               
            }
        });
        //Tạo Menu quẩn lý tài khoản cho Admin 
        MenuItem menuQuanLyTaiKhoan = new MenuItem(mauMeNuChinh, iconDatabase, "Quản Lý Tài Khoản", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new QuanLyTK());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new QuanLyTK());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });

        addMenu(menuHome, menuQLSanpham, menuThanhtoan, menutaikhoan, menuQuanLyTaiKhoan, menuDangxuat);
    }

    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelBody = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMenu.setBackground(new java.awt.Color(255, 204, 204));
        panelMenu.setPreferredSize(new java.awt.Dimension(250, 486));

        jScrollPane1.setBorder(null);

        menus.setBackground(new java.awt.Color(255, 255, 204));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("Quản lý Bán quần áo");

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setToolTipText("quản lý");
        panelBody.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1188, 797));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
    private void init() {
        new JFrmLogin(this, true).setVisible(true);    
    }
}
