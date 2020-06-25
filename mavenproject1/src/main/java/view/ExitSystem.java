/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.NhanVien;

/**
 *
 * @author tuan2
 */
public class ExitSystem  extends JFrame {
    public ExitSystem(NhanVien nv){
        exitSystem(nv);
    }
    private void exitSystem(NhanVien nv){
        JPanel panel;
        panel =  (JPanel) getContentPane();;
        int n = JOptionPane.showConfirmDialog(
               panel, 
               nv.getHoTen() +" Có Xác Nhận Là Đã Nhận Đúng Với Số Tiền Từ Nhân Viên Và Cho Phép Nhân Viên Đăng Xuất?", 
               "Alert", 
               JOptionPane.YES_NO_OPTION);
        if(n == JOptionPane.YES_OPTION)
            System.exit(0);
    }
}
