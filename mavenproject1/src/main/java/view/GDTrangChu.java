/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Duong
 */
public class GDTrangChu extends javax.swing.JFrame {

    /**
     * Creates new form GDTrangChu
     */
    public GDTrangChu() {
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

        jPanel1 = new javax.swing.JPanel();
        jButtonXuatHang = new javax.swing.JButton();
        jButtonNhapHang = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButtonTonQuy = new javax.swing.JButton();
        jButtonCongNo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButtonBanLe = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButtonXuatHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonXuatHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuaHangBanHoaQua/icons8_export_16px.png"))); // NOI18N
        jButtonXuatHang.setText("Xuất hàng");
        jButtonXuatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXuatHangActionPerformed(evt);
            }
        });

        jButtonNhapHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuaHangBanHoaQua/icons8_import_16px.png"))); // NOI18N
        jButtonNhapHang.setText("Nhập hàng");
        jButtonNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNhapHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNhapHang)
                .addGap(18, 18, 18)
                .addComponent(jButtonXuatHang)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNhapHang)
                    .addComponent(jButtonXuatHang))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuaHangBanHoaQua/icons8_shop_54px_1.png"))); // NOI18N
        jLabel1.setText("TRANG CHỦ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setText("Nhân viên");

        jButton5.setText("Đăng xuất");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(93, 93, 93)
                .addComponent(jButton5)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jButton5))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jButtonTonQuy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonTonQuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuaHangBanHoaQua/icons8_gold_pot_16px.png"))); // NOI18N
        jButtonTonQuy.setText("Tồn quỹ");
        jButtonTonQuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTonQuyActionPerformed(evt);
            }
        });

        jButtonCongNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonCongNo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuaHangBanHoaQua/icons8_gold_bars_16px.png"))); // NOI18N
        jButtonCongNo.setText("Công nợ");
        jButtonCongNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCongNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonCongNo)
                .addGap(18, 18, 18)
                .addComponent(jButtonTonQuy)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCongNo)
                    .addComponent(jButtonTonQuy))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButtonBanLe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonBanLe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuaHangBanHoaQua/icons8_shopping_16px.png"))); // NOI18N
        jButtonBanLe.setText("Bán lẻ");
        jButtonBanLe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBanLeActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuaHangBanHoaQua/icons8_agreement_18px_2.png"))); // NOI18N
        jButton1.setText("Hợp đồng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonBanLe, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButtonBanLe});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButtonBanLe))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButtonBanLe});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCongNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCongNoActionPerformed
        GDCongNoFrm dCongNoFrm = new GDCongNoFrm();
        dCongNoFrm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        dCongNoFrm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JFrame frame = (JFrame) e.getSource();

                int result = JOptionPane.showConfirmDialog(
                        frame,
                        "Có phải bạn muốn đóng cửa sổ này?",
                        "Exit Application",
                        JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }
        });
        dCongNoFrm.pack();
        dCongNoFrm.setLocationRelativeTo(null);
        dCongNoFrm.setVisible(true);
    }//GEN-LAST:event_jButtonCongNoActionPerformed

    private void jButtonNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNhapHangActionPerformed

        GDNhapHangFrm dNhapHangFrm = new GDNhapHangFrm();
        dNhapHangFrm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        dNhapHangFrm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JFrame frame = (JFrame) e.getSource();

                int result = JOptionPane.showConfirmDialog(
                        frame,
                        "Có phải bạn muốn đóng cửa sổ này?",
                        "Exit Application",
                        JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }
        });
        dNhapHangFrm.pack();
        dNhapHangFrm.setLocationRelativeTo(null);
        dNhapHangFrm.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNhapHangActionPerformed

    private void jButtonXuatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXuatHangActionPerformed
        GDXuatHangFrm dXuatHangFrm = new GDXuatHangFrm();
        dXuatHangFrm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        dXuatHangFrm.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JFrame frame = (JFrame) e.getSource();

                int result = JOptionPane.showConfirmDialog(
                        frame,
                        "Có phải bạn muốn đóng cửa sổ này?",
                        "Exit Application",
                        JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }
        });
        dXuatHangFrm.pack();
        dXuatHangFrm.setLocationRelativeTo(null);
        dXuatHangFrm.setVisible(true);
    }//GEN-LAST:event_jButtonXuatHangActionPerformed

    private void jButtonTonQuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTonQuyActionPerformed
        GDTonQuy dTonQuy = new GDTonQuy();
        dTonQuy.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        dTonQuy.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JFrame frame = (JFrame) e.getSource();

                int result = JOptionPane.showConfirmDialog(
                        frame,
                        "Có phải bạn muốn đóng cửa sổ này?",
                        "Exit Application",
                        JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }
        });
        dTonQuy.pack();
        dTonQuy.setLocationRelativeTo(null);
        dTonQuy.setVisible(true);
    }//GEN-LAST:event_jButtonTonQuyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        GDThemNhaCungCap dThemNhaCungCap = new GDThemNhaCungCap();
        dThemNhaCungCap.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        dThemNhaCungCap.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JFrame frame = (JFrame) e.getSource();

                int result = JOptionPane.showConfirmDialog(
                        frame,
                        "Có phải bạn muốn đóng cửa sổ này?",
                        "Exit Application",
                        JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
            }
        });
        dThemNhaCungCap.pack();
        dThemNhaCungCap.setLocationRelativeTo(null);
        dThemNhaCungCap.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonBanLeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBanLeActionPerformed
//        GDBanHang dQLPhieuThuChi = new GDBanHang();
//        dQLPhieuThuChi.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        dQLPhieuThuChi.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                JFrame frame = (JFrame) e.getSource();
//
//                int result = JOptionPane.showConfirmDialog(
//                    frame,
//                    "Có phải bạn muốn đóng cửa sổ này?",
//                    "Exit Application",
//                    JOptionPane.YES_NO_OPTION);
//
//                if (result == JOptionPane.YES_OPTION) {
//                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                }
//            }
//        });
//        dQLPhieuThuChi.pack();
//        dQLPhieuThuChi.setLocationRelativeTo(null);
//        dQLPhieuThuChi.setVisible(true);
    }//GEN-LAST:event_jButtonBanLeActionPerformed

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
            java.util.logging.Logger.getLogger(GDTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GDTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GDTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GDTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                new GDTrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonBanLe;
    private javax.swing.JButton jButtonCongNo;
    private javax.swing.JButton jButtonNhapHang;
    private javax.swing.JButton jButtonTonQuy;
    private javax.swing.JButton jButtonXuatHang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
