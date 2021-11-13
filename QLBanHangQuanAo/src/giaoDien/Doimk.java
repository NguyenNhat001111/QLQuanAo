package giaoDien;

public class Doimk extends javax.swing.JPanel {

    public Doimk() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paldoimk = new javax.swing.JPanel();
        lblDoiMK = new javax.swing.JLabel();
        lblMKC = new javax.swing.JLabel();
        lblMKM = new javax.swing.JLabel();
        lblNLMKM = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        txtMKC = new javax.swing.JTextField();
        txtMKM = new javax.swing.JTextField();
        txtNLMKM = new javax.swing.JTextField();

        lblDoiMK.setText("Đổi mật khẩu ");

        lblMKC.setText("Mật khẩu cũ ");

        lblMKM.setText("Mật khẩu mới");

        lblNLMKM.setText("Nhập lại mật khẩu mới ");

        btnLuu.setText("Lưu");

        btnThoat.setText("Thoát ");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paldoimkLayout = new javax.swing.GroupLayout(paldoimk);
        paldoimk.setLayout(paldoimkLayout);
        paldoimkLayout.setHorizontalGroup(
            paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paldoimkLayout.createSequentialGroup()
                .addGroup(paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paldoimkLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(lblDoiMK))
                    .addGroup(paldoimkLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMKC)
                            .addComponent(lblMKM)
                            .addComponent(lblNLMKM))
                        .addGap(40, 40, 40)
                        .addGroup(paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNLMKM, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMKC, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMKM, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(paldoimkLayout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(btnThoat)))
                .addContainerGap(728, Short.MAX_VALUE))
        );
        paldoimkLayout.setVerticalGroup(
            paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paldoimkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDoiMK)
                .addGap(18, 18, 18)
                .addGroup(paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMKC, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMKC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMKM)
                    .addComponent(txtMKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNLMKM)
                    .addComponent(txtNLMKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(paldoimkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnThoat))
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paldoimk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 397, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paldoimk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 257, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel lblDoiMK;
    private javax.swing.JLabel lblMKC;
    private javax.swing.JLabel lblMKM;
    private javax.swing.JLabel lblNLMKM;
    private javax.swing.JPanel paldoimk;
    private javax.swing.JTextField txtMKC;
    private javax.swing.JTextField txtMKM;
    private javax.swing.JTextField txtNLMKM;
    // End of variables declaration//GEN-END:variables

    private void dispose() {
        System.exit(0);
    }
}
