/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.BoPhanDAO;
import java.util.List;

import control.NguoiDAO;
import control.NhanVienDAO;
import model.BoPhan;
import model.Nguoi;
import model.NhanVien;

import javax.swing.*;

/**
 *
 * @author Poly
 */
public class EditNhanVien extends javax.swing.JFrame {
    private NhanVien nhanVien;
    private List<BoPhan> allBoPhan;
    private BoPhanDAO boPhanDAO;
    private NhanVienDAO nhanVienDAO;
    private NguoiDAO nguoiDAO;
    /**
     * Creates new form EditNhanVien
     */
    public EditNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
        boPhanDAO = new BoPhanDAO();
        nhanVienDAO = new NhanVienDAO();
        nguoiDAO = new NguoiDAO();
        allBoPhan = boPhanDAO.getAllBoPhan();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonGroup1 = new ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        radioNam = new javax.swing.JRadioButton();
        radioNu = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        txtHocvan = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtVaiTro = new javax.swing.JTextField();
        cbxBoPhan = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnXacNhan = new javax.swing.JButton();
        buttonGroup1.add(radioNam);
        buttonGroup1.add(radioNu);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel12.setText("Địa Chỉ");

        jLabel14.setText("Giới tính");

        radioNam.setText("Nam");
        radioNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNamActionPerformed(evt);
            }
        });

        radioNu.setText("Nữ");

        jLabel15.setText("Học Vấn");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel1.setText("Email");

        jLabel10.setText("Họ tên");

        jLabel11.setText("Ngày sinh");

        jLabel3.setText("Vai Trò");

        jLabel4.setText("Bộ Phận");

        txtVaiTro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVaiTroActionPerformed(evt);
            }
        });


        jLabel2.setText("Sửa Nhân Viên");

        btnXacNhan.setText("Xác Nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        fillData();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtVaiTro)
                    .addComponent(cbxBoPhan, 0, 179, Short.MAX_VALUE))
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel1)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtEmail)
                        .addComponent(txtHoTen)
                        .addComponent(txtNgaySinh)
                        .addComponent(txtDiaChi)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(radioNam)
                            .addGap(66, 66, 66)
                            .addComponent(radioNu)
                            .addGap(16, 16, 16)))
                    .addComponent(txtHocvan, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(btnXacNhan)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtHocvan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(radioNam)
                            .addComponent(radioNu)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(cbxBoPhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(btnXacNhan)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fillData() {
        txtHoTen.setText(nhanVien.getHoTen());
        txtDiaChi.setText(nhanVien.getDiaChi());
        txtNgaySinh.setText(nhanVien.getNgaySinh());
        txtEmail.setText(nhanVien.getEmail());
        txtHocvan.setText(nhanVien.getHocVan());
        txtVaiTro.setText(nhanVien.getVaiTro());
        allBoPhan.forEach(boPhan -> cbxBoPhan.addItem(boPhan));
        cbxBoPhan.setSelectedItem(nhanVien.getBoPhan());

        if (nhanVien.getGioiTinh().equals("Male")) {
            radioNam.setSelected(true);
        } else {
            radioNu.setSelected(true);
        }
    }

    private void radioNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNamActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtVaiTroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVaiTroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVaiTroActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        // TODO add your handling code here:
        Nguoi nguoi = new Nguoi();
        nguoi.setEmail(txtEmail.getText());
        nguoi.setHoTen(txtHoTen.getText());
        nguoi.setSoDienThoai("");
        nguoi.setNgaySinh(txtNgaySinh.getText());

        boolean namSelected = radioNam.isSelected();
        if (namSelected) {
            nguoi.setGioiTinh("Male");
        } else {
            nguoi.setGioiTinh("Female");
        }
        nguoi.setDiaChi(txtDiaChi.getText());

        nguoi.setHocVan(txtHocvan.getText());
        nguoi.setId(nhanVien.getId());

        nguoiDAO.updateNguoi(nguoi);

        NhanVien nhanVien = this.nhanVien;

        nhanVien.setVaiTro(txtVaiTro.getText());
        int selectedIndex = cbxBoPhan.getSelectedIndex();
        BoPhan boPhan = allBoPhan.get(selectedIndex);
        nhanVien.setBoPhan(boPhan);
        nhanVienDAO.updateVaiTroVaBoPhan(nhanVien);
        this.setVisible(false);
        (new GDQuanLyNhanVien()).setVisible(true);
    }//GEN-LAST:event_btnXacNhanActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(EditNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // TODO: Truyền Nhân viên cần sửa vào đây
                new EditNhanVien(new NhanVienDAO().getNhanVienById(1)).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JComboBox<BoPhan> cbxBoPhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton radioNam;
    private javax.swing.JRadioButton radioNu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtHocvan;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtVaiTro;
    private javax.swing.ButtonGroup buttonGroup1;
    // End of variables declaration//GEN-END:variables
}
