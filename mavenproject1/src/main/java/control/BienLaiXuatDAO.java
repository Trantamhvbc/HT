/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static control.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.BienLaiNhap;
import model.SanPham;
import model.BienLaiXuat;

/**
 *
 * @author Duong
 */
public class BienLaiXuatDAO extends DAO {

    public BienLaiXuatDAO() {
        super();
    }

    public boolean themBienLaiXuat(BienLaiXuat bienLaiXuat, SanPham pham) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        System.out.println("BienLaiXuat" + bienLaiXuat);
        String idBienLaiXuat = "'" + bienLaiXuat.getIdBienLaiXuat() + "',";
        String tiLeThue = "'" + bienLaiXuat.getTiLeThue() + "',";// day la so luong xuat
        String tiLeLai = "'" + bienLaiXuat.getTiLeLai() + "'";
        String idCuaHang = "'" + bienLaiXuat.getCuaHang().getId() + "',";
        String idNhanVien = "'" + bienLaiXuat.getNv().getIdNhanVien()+ "',";
        String idBienLaiKho="'" + bienLaiXuat.getId()+ "',";
        String maBienLaiKho = "'" + bienLaiXuat.getMaBienLai() + "',";
        String ngayLap = "N'" + bienLaiXuat.getNgayLap() + "',";
        String soLuong = "'" + bienLaiXuat.getSoLuong() + "',";
        String idKho = "N'" + bienLaiXuat.getKho().getId() + "',";
        String tongTien = "N'" + bienLaiXuat.getTongCong() + "'";
        ////////////////////////--------SanPham
        String idSanPham = "'" + pham.getGia() + "',";
        String maSanPham = "'" + pham.getMaSp() + "',";
        String hanSuDung = "'" + pham.getHanSuDung() + "',";
        String idMatHang = "'" + pham.getIdMatHang() + "'";
        String gia = "'" + pham.getGia() + "',";
        System.out.println("BienLaiNhapDAO " + pham.getIdMatHang());
        ////////////// // //
        try {
           
            String sql = "insert into [BienLaiXuat] (idBienLaiKho,tiLeThue,idCuaHang,idNhanVien,tiLeLai)"
                    + " values(" + idBienLaiKho + soLuong + idCuaHang + idNhanVien + tiLeLai + ")";
            
            System.out.println(sql);
            stm = con.prepareStatement(sql);
            stm.executeUpdate();
          
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
        return true;
    }
}
