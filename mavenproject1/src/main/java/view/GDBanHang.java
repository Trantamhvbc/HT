/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.BienLaiKhoDAO;
import control.KhoDAO;
import control.NhanVienDAO;
import control.SanPhamDAO;
import control.XuatHangDAO;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.RecordSanPham;
import model.*;
import control.*;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Duong
 */
public class GDBanHang extends javax.swing.JFrame {

    /**
     * Creates new form GDBanHang
     */
    private ArrayList<RecordSanPham> listSanPham2 = new ArrayList<>();
    private Kho selectedKho;
    private NhanVien selectNV;
    private ArrayList<RecordSanPham> listSanPhamSelected = new ArrayList<>();
    private HoaDonBanHang hoadonDonBanHang = null;
    private int tienHang = 0;
    private int tongtien = 0;
    private GDNhanVienBanHang back;

    public GDBanHang() {
        initComponents();
        Kho kho = new Kho();
        kho.setId(1);
        loadSanPham(kho);
        loadKho();
        loadNV();
        jTextFieldSoHD.setText(createMatBienLai());
        hoadonDonBanHang = new HoaDonBanHang();
        loadSanPhamDaChon();
    }

    public GDBanHang(NhanVien e, int tongtien, GDNhanVienBanHang back) {
        initComponents();
        Kho kho = new Kho();
        kho.setId(1);
        loadSanPham(kho);
        loadKho();
        this.selectNV = e;
        this.back = back;
        this.tongtien = tongtien;
        loadNV();
        jTextFieldSoHD.setText(createMatBienLai());
        hoadonDonBanHang = new HoaDonBanHang();
        loadSanPhamDaChon();
        loadTongTien();
        loadChoseDay();

    }

    @Override
    protected void processWindowEvent(final WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            back.dangXuat();
            this.dispose();
        }
    }
//thÃªm sá»± kiá»‡n Ã´ nháº­p Ä‘Æ¡n giÃ¡ Ä‘á»‹nh dáº¡ng money
    //thÃªm sá»± kiá»‡n Ã´ nháº­p Ä‘Æ¡n giÃ¡ Ä‘á»‹nh dáº¡ng money

    void tinhTongCong() {
        jLabel7.setText(dinhDangTien(tienHang));
    }

    int countDigit(int number) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count += 1;
        }
        return count;
    }

    void loadNV() {
        jLabel12.setText(this.selectNV.getHoTen());

    }

    String createMatBienLai() {
        HoaDonBanHangDAO aO = new HoaDonBanHangDAO();
        ArrayList<HoaDonBanHang> hoaDonBanHangs = aO.getHoaDonBanHangs();
        int count = countDigit(hoaDonBanHangs.size() + 1);
        String maBH = "BH-";
        int rest = 7 - count;
        while (rest > 0) {
            maBH += '0';
            rest--;
        }
        maBH = maBH + "" + hoaDonBanHangs.size();
        return maBH;
    }

    String dinhDangTien(int number) {
        DecimalFormat df = new DecimalFormat("#,##0");
        String s = df.format(new BigDecimal(number));
        return s;
    }

    void loadSanPham() {
        DefaultTableModel defaultTableModel = new DefaultTableModel(new String[]{"", "Mã Sản Phẩm", "Tiền Mặt Hàng", "số lượng", "1", "?", "?"}, 0);
        defaultTableModel.setRowCount(0);
        jTableSanPham.setModel(defaultTableModel);
        jTableSanPham.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTableSanPham.getColumnModel().getColumn(3).setPreferredWidth(10);
        jTableSanPham.getColumnModel().getColumn(5).setPreferredWidth(10);
        jTableSanPham.getColumnModel().getColumn(6).setPreferredWidth(15);
        JTableHeader header = jTableSanPham.getTableHeader();
        header.setResizingAllowed(false);
        jTableSanPham.setFocusable(false);
        jTableSanPham.setDefaultRenderer(String.class, new VisitorRenderer());
        jTableSanPham.setRowMargin(3);
        jTableSanPham.setRowSelectionAllowed(true);
        jTableSanPham.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableSanPham.setSelectionForeground(new Color(204, 255, 255));
        int stt = 0;
        for (int i = 0; i < listSanPham2.size(); i++) {
            RecordSanPham recordSanPham = listSanPham2.get(i);
            SanPham sp = recordSanPham.getPham();
            int soLuong = recordSanPham.getSoLuong();
            defaultTableModel.addRow(new Object[]{stt, sp.getMaMatHang(), sp.getTenMatHang(), sp.getGia(), sp.getHanSuDung(), sp.getDonViTinh(), soLuong});
            stt++;
        }

        defaultTableModel.fireTableDataChanged();
    }

    void loadSanPham(Kho kho) {
        SPDBDAO spdao = new SPDBDAO();
        listSanPham2 = spdao.getAllSanPhamTrenCuaHang();
        DefaultTableModel defaultTableModel = new DefaultTableModel(new String[]{"", "Mặt hàng", "1", "2", "3", "4", "5"}, 0);
        defaultTableModel.setRowCount(0);
        jTableSanPham.setModel(defaultTableModel);
        jTableSanPham.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTableSanPham.getColumnModel().getColumn(3).setPreferredWidth(10);
        jTableSanPham.getColumnModel().getColumn(5).setPreferredWidth(10);
        jTableSanPham.getColumnModel().getColumn(6).setPreferredWidth(15);
        JTableHeader header = jTableSanPham.getTableHeader();
        header.setResizingAllowed(false);
        jTableSanPham.setFocusable(false);
        jTableSanPham.setDefaultRenderer(String.class, new VisitorRenderer());
        jTableSanPham.setRowMargin(3);
        jTableSanPham.setRowSelectionAllowed(true);
        jTableSanPham.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableSanPham.setSelectionForeground(new Color(204, 255, 255));
        int stt = 0;
        for (int i = 0; i < listSanPham2.size(); i++) {
            RecordSanPham recordSanPham = listSanPham2.get(i);
            SanPham sp = recordSanPham.getPham();
            int soLuong = recordSanPham.getSoLuong();
            defaultTableModel.addRow(new Object[]{stt, sp.getMaMatHang(), sp.getTenMatHang(), sp.getGia(), sp.getHanSuDung(), sp.getDonViTinh(), soLuong});
            stt++;
        }

        defaultTableModel.fireTableDataChanged();
    }

    void loadSanPhamDaChon() {
        DefaultTableModel defaultTableModel = new DefaultTableModel(new String[]{"", "Mã mặt hàng", "tên mặt hàng", "Số Lượng", "đơn vị", "giá", "Thành Tiền"}, 0);
        defaultTableModel.setRowCount(0);
        jTableSpDaChon.setModel(defaultTableModel);
        jTableSpDaChon.getColumnModel().getColumn(0).setPreferredWidth(5);
        jTableSpDaChon.getColumnModel().getColumn(3).setPreferredWidth(10);
        jTableSpDaChon.getColumnModel().getColumn(5).setPreferredWidth(10);
        jTableSpDaChon.getColumnModel().getColumn(6).setPreferredWidth(15);
        JTableHeader header = jTableSpDaChon.getTableHeader();
        header.setResizingAllowed(false);
        jTableSpDaChon.setFocusable(false);
        jTableSpDaChon.setDefaultRenderer(String.class, new VisitorRenderer());
        jTableSpDaChon.setRowMargin(3);
        jTableSpDaChon.setRowSelectionAllowed(true);
        jTableSpDaChon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableSpDaChon.setSelectionForeground(new Color(204, 255, 255));
        int stt = 0;
        this.tienHang = 0;

        for (int i = 0; i < hoadonDonBanHang.getListSanPhamSelected().size(); i++) {
            RecordSanPham recordSanPham = hoadonDonBanHang.getListSanPhamSelected().get(i);
            tiLeCK = listTiLeCK.get(i);
            SanPham sp = recordSanPham.getPham();
            int soLuong = recordSanPham.getSoLuong();
            int thanhTien = recordSanPham.getSoLuong() * sp.getGia();
            tienHang += thanhTien;
            defaultTableModel.addRow(new Object[]{stt, sp.getMaMatHang(), sp.getTenMatHang(), soLuong, sp.getDonViTinh(), sp.getGia(), dinhDangTien(thanhTien)});
            stt++;
        }

        defaultTableModel.fireTableDataChanged();
    }

    void loadKho() {
        jComboBoxKho.removeAllItems();
        KhoDAO khoDAO = new KhoDAO();
        ArrayList<Kho> listKho = khoDAO.getAllKho();
        selectedKho = listKho.get(0);
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (int i = 0; i < listKho.size(); i++) {
            model.addElement("Cửa Hàng Tại " + listKho.get(i).getDiaChi());
        }
        jComboBoxKho.setModel(model);
        jComboBoxKho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JComboBox comboBoxTest = (JComboBox) e.getSource();
                int stt = comboBoxTest.getSelectedIndex();
                if (stt >= 0) {
                    selectedKho = listKho.get(stt);
                    loadSanPham(selectedKho);
                }
            }
        });
    }

    public void loadChoseDay() {
        Date date = new Date();
        jDateChooserNgayLap.setDate(date);
    }

    public class VisitorRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (hasFocus) {
                setBorder(new LineBorder(Color.BLACK));
            }
            return this;
        }
    }

    boolean check2RecordSp(RecordSanPham rsp1, RecordSanPham rsp2) {
        if (rsp1.getPham().getIdSanPham() == rsp2.getPham().getIdSanPham()) {
            return true;
        }
        return false;
    }

    public void addTongTien(int tienHang) {
        this.tongtien += tienHang;
        loadTongTien();
    }

    void loadTongTien() {
        jLabel14.setText(this.tongtien + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSanPham = new javax.swing.JTable();
        jButtonThem = new javax.swing.JButton();
        jComboBoxKho = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jSpinnerSoLuong = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jDateChooserNgayLap = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldSoHD = new javax.swing.JTextField();
        jTextFieldDienGiai = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSpDaChon = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldGhiChu = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButtonThanhToan = new javax.swing.JButton();
        jButtonXoaDong = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuaHangBanHoaQua/icons8_checkout_48px_1.png"))); // NOI18N
        jLabel2.setText("Hóa đơn bán hàng");

        jLabel13.setText("Tổng Tiền Bán Của Nhân Viên");

        jLabel14.setText("0");

        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel15.setText("VND");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(85, 85, 85)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jLabel1))
        );

        jTableSanPham.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "", "Mã hàng", "Tên hàng", "Giá bán lẻ", "ĐVT", "Hạn sử dụng"
            }
        ));
        jScrollPane1.setViewportView(jTableSanPham);

        jButtonThem.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonThem.setText("Thêm");
        jButtonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(jButtonThem, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButtonThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jComboBoxKho.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxKho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Kho");

        jLabel3.setText("Số Lượng");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setText("Ngày lập");

        jDateChooserNgayLap.setDateFormatString("dd/MM/yyy\n\n");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Số HĐ");

        jTextFieldSoHD.setEditable(false);
        jTextFieldSoHD.setBackground(new java.awt.Color(204, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setText("Diễn giải");

        jLabel9.setText("Nhân viên");

        jTableSpDaChon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hàng", "Tên mặt hàng", "Số lượng", "ĐVT", "Đơn giá", "CK%", "Tiền giảm", "Thành tiền"
            }
        ));
        jScrollPane2.setViewportView(jTableSpDaChon);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setText("Ghi chú");

        jTextFieldGhiChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGhiChuActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Tổng cộng");

        jButtonThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuaHangBanHoaQua/icons8_cash_18px.png"))); // NOI18N
        jButtonThanhToan.setText("Thanh toán");
        jButtonThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThanhToanActionPerformed(evt);
            }
        });

        jButtonXoaDong.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonXoaDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgCuaHangBanHoaQua/icons8_delete_18px.png"))); // NOI18N
        jButtonXoaDong.setText("Xóa");
        jButtonXoaDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaDongActionPerformed(evt);
            }
        });

        jLabel7.setText("  ");

        jLabel11.setText("VND");

        jLabel12.setText("jLabel12");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButtonThanhToan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonXoaDong, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel19)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(16, 16, 16)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(jTextFieldDienGiai)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(15, 15, 15)
                                .addComponent(jDateChooserNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jTextFieldSoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextFieldSoHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooserNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDienGiai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonThanhToan)
                    .addComponent(jButtonXoaDong)
                    .addComponent(jLabel19)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11))
                .addGap(113, 113, 113)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jDateChooserNgayLap, jTextFieldDienGiai, jTextFieldGhiChu, jTextFieldSoHD});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinnerSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(jComboBoxKho, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jSpinnerSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBoxKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private int tiLeCK;
    ArrayList<Integer> listTiLeCK = new ArrayList<>();
    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed

        int row = jTableSanPham.getSelectedRow();
        boolean check = true;
        int soLuong = (Integer) jSpinnerSoLuong.getValue();
        if (row == -1) {
            check = false;
            JOptionPane.showMessageDialog(null, "loi", "cảnh báo mặt hàng", JOptionPane.WARNING_MESSAGE);
        } else if (soLuong > listSanPham2.get(row).getSoLuong()) {
            check = false;
            JOptionPane.showMessageDialog(null, "2", "3", JOptionPane.WARNING_MESSAGE);
        } else {
            RecordSanPham recordSanPham = listSanPham2.get(row);
            int soLuongBD = recordSanPham.getSoLuong();
            SanPham sp = recordSanPham.getPham();
            recordSanPham.setSoLuong(soLuongBD - soLuong);
            listSanPham2.set(row, recordSanPham);
            recordSanPham = new RecordSanPham();
            recordSanPham.setPham(sp);
            recordSanPham.setSoLuong(soLuong);
            hoadonDonBanHang.add(recordSanPham);
            listTiLeCK.add(tiLeCK);
            loadSanPhamDaChon();
            loadSanPham();
            jLabel7.setText(dinhDangTien(tienHang));
        }

    }//GEN-LAST:event_jButtonThemActionPerformed

    private void jButtonXoaDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaDongActionPerformed
        int row = jTableSpDaChon.getSelectedRow();
        boolean check = true;
        if (row == -1) {
            check = false;
            JOptionPane.showMessageDialog(null, "chá»�n dÃ²ng cáº§n xÃ³a", "cáº£nh bÃ¡o chá»�n dÃ²ng xÃ³a", JOptionPane.WARNING_MESSAGE);
        } else {
            RecordSanPham rsp = hoadonDonBanHang.remove(row);
            for (int i = 0; i < listSanPham2.size(); i++) {
                RecordSanPham rsp2 = listSanPham2.get(i);
                int sl = rsp2.getSoLuong();
                if (check2RecordSp(rsp, rsp2)) {
                    rsp2.setSoLuong(sl + rsp.getSoLuong());
                }
            }
            loadSanPham();
            loadSanPhamDaChon();
        }
    }//GEN-LAST:event_jButtonXoaDongActionPerformed

    private void jButtonThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThanhToanActionPerformed
        String ngayLap = ((JTextField) jDateChooserNgayLap.getDateEditor().getUiComponent()).getText();
        String soPhieu = jTextFieldSoHD.getText();
        boolean check = true;
        if (ngayLap.equals("")) {
            check = false;
            JOptionPane.showMessageDialog(null, "??", "cảnh báo ngày nhập", JOptionPane.WARNING_MESSAGE);
        } else if (hoadonDonBanHang.getListSanPhamSelected().size() > 0) {

            hoadonDonBanHang.setNgay(ngayLap);
            hoadonDonBanHang.setNv(selectNV);
            hoadonDonBanHang.setSoLuong(tinhSoLuong());
            hoadonDonBanHang.setSoTien(tienHang);

            PhieuThuChi phieuThuChi = new PhieuThuChi();
            phieuThuChi.setNgayLap(ngayLap);
            phieuThuChi.setDienGiai(jTextFieldDienGiai.getText());
            phieuThuChi.setLoaiPhieu("Phiếu bán hàng");
            phieuThuChi.setLyDo(jTextFieldGhiChu.getText());
            phieuThuChi.setNv(selectNV);
            phieuThuChi.setTenDoiTuong("Khách hàng");
            phieuThuChi.setSoPhieu(soPhieu);
            GDXacNhanBanHang dXacNhanBanHang = new GDXacNhanBanHang(tienHang, hoadonDonBanHang, phieuThuChi, this);
            dXacNhanBanHang.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            dXacNhanBanHang.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {

                    JFrame frame = (JFrame) e.getSource();
                    int result = JOptionPane.showConfirmDialog(
                            frame,
                            "gggac ",
                            "Exit Application",
                            JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {

                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        loadSanPham(selectedKho);
                        hoadonDonBanHang = new HoaDonBanHang();

                        loadSanPhamDaChon();
                        jLabel7.setText(0 + "");
                    }
                }
            });
            dXacNhanBanHang.pack();
            dXacNhanBanHang.setLocationRelativeTo(null);
            dXacNhanBanHang.setVisible(true);
        }
    }//GEN-LAST:event_jButtonThanhToanActionPerformed

    private void jTextFieldGhiChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGhiChuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGhiChuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.back.setTongTien(tongtien);
        this.back.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    int tinhSoLuong() {
        int number = 0;
        for (int i = 0; i < hoadonDonBanHang.getListSanPhamSelected().size(); i++) {
            number += hoadonDonBanHang.getListSanPhamSelected().get(i).getSoLuong();
        }
        return number;
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonThanhToan;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonXoaDong;
    private javax.swing.JComboBox<String> jComboBoxKho;
    private com.toedter.calendar.JDateChooser jDateChooserNgayLap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinnerSoLuong;
    private javax.swing.JTable jTableSanPham;
    private javax.swing.JTable jTableSpDaChon;
    private javax.swing.JTextField jTextFieldDienGiai;
    private javax.swing.JTextField jTextFieldGhiChu;
    private javax.swing.JTextField jTextFieldSoHD;
    // End of variables declaration//GEN-END:variables
}
