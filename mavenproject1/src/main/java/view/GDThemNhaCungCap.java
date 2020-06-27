/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.HopDong2DAO;
import control.HopDongDAO;
import control.MatHangDAO;
import control.NhaCungCap1DAO;
import control.NhanVienDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.MatHang;
import model.NhaCungCap;
import model.NhanVien;
import model.HopDong;

/**
 *
 * @author User
 */
public class GDThemNhaCungCap extends javax.swing.JFrame {

    /**
     * Creates new form GDThemNhaCungCap
     */

    ArrayList<NhaCungCap> listNhaCungCap;
    private ArrayList<NhanVien> listNV;
    private NhanVien nvSelected;
       


    public GDThemNhaCungCap() {
        initComponents();
         loadNV();
        createNhaCungCap();
        addActionListenerButton(jButtonLuu);
    }
    void addActionListenerButton(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                NhaCungCap1DAO nccDao = new NhaCungCap1DAO();
                NhaCungCap ncc = new NhaCungCap();
                String ma = jTextFieldMa.getText();
                String ten = jTextFieldTen.getText();
                boolean check = true;
                if (ten.equals("")) {
                    check = false;
                    JOptionPane.showMessageDialog(jTextFieldTen, "Không được để trống tên nhà cung cấp!", "Warning", JOptionPane.WARNING_MESSAGE);
                    jTextFieldTen.requestFocus();
                }
                String email= jTextFieldEmail.getText();
                String sdt= jTextFieldSdt.getText();
                

                ncc.setTen(ten);
                ncc.setSodienthoai(sdt);
                ncc.setEmail(email);
                
                
//                ImageIcon icon = new ImageIcon(getClass().getResource("/imgCuaHangBanHoaQua/icons8_ok_48px.png"));
                if (check) {
                    nccDao.themNhaCungCap(ncc);
                    
                    
                    JOptionPane.showMessageDialog(button, "Đã thêm nhà cung cấp " + ma, "Thêm thành công", JOptionPane.INFORMATION_MESSAGE);
                    createNhaCungCap();
                }
            }

        });
    }

    int countDigit(int number) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count += 1;
        }
        return count;
    }

    void createNhaCungCap() {
        
        NhaCungCap1DAO nccDao = new NhaCungCap1DAO();       
        listNhaCungCap = nccDao.getAllNhaCungCap();
        int count = countDigit(listNhaCungCap.size() + 1);
        String maNCC = "DTE-";
        int rest = 7 - count;
        while (rest > 0) {
            maNCC += '0';
            rest--;
        }
        maNCC = maNCC + "" + listNhaCungCap.size();
        jTextFieldMa.setText(maNCC);
    }
   

    void addListenerText(JTextField field) {
        field.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                warn();
            }

            public void removeUpdate(DocumentEvent e) {
                warn();
            }

            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {

            }
        });
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                field.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    DecimalFormat df = new DecimalFormat("#,##0");
                    String s = df.format(new BigDecimal(field.getText()));
                    field.setText(s);
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(field, "Only numbers are allowed", "Warning", JOptionPane.WARNING_MESSAGE);
                    e2.printStackTrace();
                    field.setText("");
                }
            }
        });

        field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }   
    
    
    // tải dữ liệu nhân viên kho từ cơ sở dữ liệu
    void loadNV() {
        jComboBoxNhanVien.removeAllItems();
        NhanVienDAO nhanVienDAO = new NhanVienDAO();
        this.listNV = nhanVienDAO.getAllNVKho();
        nvSelected = listNV.get(0);
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (int i = 0; i < listNV.size(); i++) {
            model.addElement(listNV.get(i).getHoTen());
        }
        jComboBoxNhanVien.setModel(model);
        jComboBoxNhanVien.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JComboBox comboBoxTest = (JComboBox) e.getSource();
                int stt = comboBoxTest.getSelectedIndex();
                if (stt != -1) {
                    nvSelected = listNV.get(stt);
                }
            }
        });
    }
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldSdt = new javax.swing.JTextField();
        jTextFieldTen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonLuu = new javax.swing.JButton();
        jLabelMa = new javax.swing.JLabel();
        jTextFieldMa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldMaHD = new javax.swing.JTextField();
        jTextFieldTenHD = new javax.swing.JTextField();
        jTextFieldNgayKiHD = new javax.swing.JTextField();
        jTextFieldDenNgayHD = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButtonLuu2 = new javax.swing.JButton();
        jComboBoxNhanVien = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });

        jTextFieldSdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSdtActionPerformed(evt);
            }
        });

        jTextFieldTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTenActionPerformed(evt);
            }
        });

        jLabel1.setText("Tên");

        jLabel2.setText("Email");

        jLabel3.setText("Số điện thoại");

        jLabel4.setText("Nhà cung cấp");

        jButtonLuu.setText("Lưu nhà cung cấp");
        jButtonLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLuuActionPerformed(evt);
            }
        });

        jLabelMa.setText("Mã nhà cung cấp");

        jTextFieldMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMaActionPerformed(evt);
            }
        });

        jLabel5.setText("Hợp đồng");

        jLabel6.setText("Mã ");

        jLabel7.setText("Tên hợp đồng");

        jLabel8.setText("Ngày kí");

        jLabel9.setText("Đến ngày");

        jLabel10.setText("Nhân viên");

        jTextFieldMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMaHDActionPerformed(evt);
            }
        });

        jButtonLuu2.setText("Lưu hợp đồng");
        jButtonLuu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLuu2ActionPerformed(evt);
            }
        });

        jComboBoxNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabelMa)
                                    .addComponent(jLabel3))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldSdt)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldMa, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTextFieldEmail)
                                    .addComponent(jTextFieldTen))
                                .addGap(226, 226, 226))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jButtonLuu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonLuu2))
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addComponent(jTextFieldTenHD)
                                .addComponent(jTextFieldNgayKiHD)
                                .addComponent(jTextFieldDenNgayHD)))))
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMa)
                            .addComponent(jTextFieldMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldTenHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldNgayKiHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldDenNgayHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLuu)
                    .addComponent(jLabel11)
                    .addComponent(jButtonLuu2))
                .addContainerGap(187, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void jTextFieldSdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSdtActionPerformed

    private void jTextFieldTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTenActionPerformed

    private void jTextFieldMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMaActionPerformed

    private void jTextFieldMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMaHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMaHDActionPerformed

    private void jButtonLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLuuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLuuActionPerformed

    private void jButtonLuu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLuu2ActionPerformed
            HopDong2DAO dongDAO=new HopDong2DAO();
            HopDong hd=new HopDong();
            hd.setDenNGay(jTextFieldDenNgayHD.getText());
            hd.setNv(nvSelected);
            hd.setNgayKi(jTextFieldNgayKiHD.getText());
            hd.setTenHopDong(jTextFieldTenHD.getText());
            NhaCungCap ncc=new NhaCungCap();
            ncc.setEmail(jTextFieldEmail.getText());
            ncc.setSodienthoai(jTextFieldSdt.getText());
            ncc.setTen(jTextFieldTen.getText());
            dongDAO.themHopDong(hd,ncc,nvSelected);
            JOptionPane.showMessageDialog(null, "Thêm hợp đồng thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLuu2ActionPerformed

    /**
     * @param args the command line arguments
     */
   
     public static void main(String args[]) {
       
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
                new GDThemNhaCungCap().setVisible(true);

            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLuu;
    private javax.swing.JButton jButtonLuu2;
    private javax.swing.JComboBox<String> jComboBoxNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMa;
    private javax.swing.JTextField jTextFieldDenNgayHD;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldMa;
    private javax.swing.JTextField jTextFieldMaHD;
    private javax.swing.JTextField jTextFieldNgayKiHD;
    private javax.swing.JTextField jTextFieldSdt;
    private javax.swing.JTextField jTextFieldTen;
    private javax.swing.JTextField jTextFieldTenHD;
    // End of variables declaration//GEN-END:variables
    
}
    

    
