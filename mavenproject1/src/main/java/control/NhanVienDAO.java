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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author Duong
 */
public class NhanVienDAO extends DAO {

    public NhanVienDAO() {
        super();
    }
    public  NhanVien getNhanVienByAcount(NhanVien e){
        NhanVien res = new NhanVien();
        res.setPassword("");
        res.setUserName("");
        try {
            String sql = "select * from  [NhanVien]  inner join [Nguoi] on NhanVien.idNguoi=Nguoi.idNguoi where NhanVien.username = ? and password = ?";
            PreparedStatement prstm = con.prepareStatement(sql);
            prstm.setString(1,e.getUserName() );
            prstm.setString(2, e.getPassword());
            ResultSet rs = prstm.executeQuery();
            while (rs.next() ) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getInt("idNhanVien"));
                nhanVien.setEmail(rs.getString("email"));
                nhanVien.setNgaySinh(rs.getString("ngaySinh"));
                nhanVien.setGioiTinh(rs.getString("gioiTinh"));
                nhanVien.setHocVan(rs.getString("hocVan"));
                nhanVien.setDiaChi(rs.getString("diaChi"));
                nhanVien.setHoTen(rs.getString("hoTen"));
                nhanVien.setIdNhanVien(rs.getInt("idNhanVien"));
                nhanVien.setVaiTro(rs.getString("vaiTro"));
                nhanVien.setUserName(rs.getString("username"));
                nhanVien.setPassword(rs.getString("password"));
                BoPhan boPhan = new BoPhan();
                CuaHang cuaHang = new CuaHang();
                boPhan.setId(rs.getInt("idBoPhan"));
                cuaHang.setId(rs.getInt("idCuaHang"));
                nhanVien.setBoPhan(boPhan);
                nhanVien.setCuaHang(cuaHang);
                return nhanVien ;
            }
        }catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    } 
    
    public ArrayList<NhanVien> getAllNVBanHang(){
        PreparedStatement stm = null;
        ResultSet rs = null;

        String sql = " select * from  [NhanVien]  inner join [Nguoi] on NhanVien.idNguoi=Nguoi.idNguoi where vaiTro=N'Bán hàng'";
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getInt("idNhanVien"));
                nhanVien.setEmail(rs.getString("email"));
                nhanVien.setNgaySinh(rs.getString("ngaySinh"));
                nhanVien.setGioiTinh(rs.getString("gioiTinh"));
                nhanVien.setHocVan(rs.getString("hocVan"));
                nhanVien.setDiaChi(rs.getString("diaChi"));
                nhanVien.setHoTen(rs.getString("hoTen"));
                nhanVien.setIdNhanVien(rs.getInt("idNhanVien"));
                nhanVien.setVaiTro(rs.getString("vaiTro"));
                nhanVien.setUserName(rs.getString("username"));
                nhanVien.setPassword(rs.getString("password"));
                BoPhan boPhan = new BoPhan();
                CuaHang cuaHang = new CuaHang();
                boPhan.setId(rs.getInt("idBoPhan"));
                cuaHang.setId(rs.getInt("idCuaHang"));
                nhanVien.setBoPhan(boPhan);
                nhanVien.setCuaHang(cuaHang);
                listNhanVien.add(nhanVien);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                //
            }
        }
        return listNhanVien;
        
    }
    public ArrayList<NhanVien> getAllNVKeToan(){
        PreparedStatement stm = null;
        ResultSet rs = null;

        String sql = " select * from  [NhanVien]  inner join [Nguoi] on NhanVien.idNhanVien=Nguoi.idNguoi where vaiTro=N'Kế toán'";
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getInt("idNhanVien"));
                nhanVien.setEmail(rs.getString("email"));
                nhanVien.setNgaySinh(rs.getString("ngaySinh"));
                nhanVien.setGioiTinh(rs.getString("gioiTinh"));
                nhanVien.setHocVan(rs.getString("hocVan"));
                nhanVien.setDiaChi(rs.getString("diaChi"));
                nhanVien.setHoTen(rs.getString("hoTen"));
                nhanVien.setIdNhanVien(rs.getInt("idNhanVien"));
                nhanVien.setVaiTro(rs.getString("vaiTro"));
                nhanVien.setUserName(rs.getString("username"));
                nhanVien.setPassword(rs.getString("password"));
                BoPhan boPhan = new BoPhan();
                CuaHang cuaHang = new CuaHang();
                boPhan.setId(rs.getInt("idBoPhan"));
                cuaHang.setId(rs.getInt("idCuaHang"));
                nhanVien.setBoPhan(boPhan);
                nhanVien.setCuaHang(cuaHang);
                listNhanVien.add(nhanVien);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                //
            }
        }
        return listNhanVien;
        
    }
    public ArrayList<NhanVien> getAllNVKho(){
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = " select * from  [NhanVien]  inner join [Nguoi] on NhanVien.idNguoi=Nguoi.idNguoi where vaiTro=N'Quản lí kho'";
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getInt("idNhanVien"));
                nhanVien.setEmail(rs.getString("email"));
                nhanVien.setNgaySinh(rs.getString("ngaySinh"));
                nhanVien.setGioiTinh(rs.getString("gioiTinh"));
                nhanVien.setHocVan(rs.getString("hocVan"));
                nhanVien.setDiaChi(rs.getString("diaChi"));
                nhanVien.setHoTen(rs.getString("hoTen"));
                nhanVien.setIdNhanVien(rs.getInt("idNhanVien"));
                nhanVien.setVaiTro(rs.getString("vaiTro"));
                nhanVien.setUserName(rs.getString("username"));
                nhanVien.setPassword(rs.getString("password"));
                BoPhan boPhan = new BoPhan();
                CuaHang cuaHang = new CuaHang();
                boPhan.setId(rs.getInt("idBoPhan"));
                cuaHang.setId(rs.getInt("idCuaHang"));
                nhanVien.setBoPhan(boPhan);
                nhanVien.setCuaHang(cuaHang);
                listNhanVien.add(nhanVien);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                //
            }
        }
        return listNhanVien;
        
    }
    public ArrayList<NhanVien> getAllNhanVien() {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "select *  from [NhanVien] inner join [Nguoi] on NhanVien.idNhanVien=Nguoi.idNguoi";
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getInt("idNhanVien"));
                nhanVien.setEmail(rs.getString("email"));
                nhanVien.setNgaySinh(rs.getString("ngaySinh"));
                nhanVien.setGioiTinh(rs.getString("gioiTinh"));
                nhanVien.setHocVan(rs.getString("hocVan"));
                nhanVien.setDiaChi(rs.getString("diaChi"));
                nhanVien.setHoTen(rs.getString("hoTen"));
                nhanVien.setIdNhanVien(rs.getInt("idNhanVien"));
                nhanVien.setVaiTro(rs.getString("vaiTro"));
                nhanVien.setUserName(rs.getString("username"));
                nhanVien.setPassword(rs.getString("password"));
                nhanVien.setVaiTro(rs.getString("vaiTro"));
                BoPhan boPhan = new BoPhan();
                CuaHang cuaHang = new CuaHang();
                boPhan.setId(rs.getInt("idBoPhan"));
                cuaHang.setId(rs.getInt("idCuaHang"));
                nhanVien.setBoPhan(boPhan);
                nhanVien.setCuaHang(cuaHang);
                listNhanVien.add(nhanVien);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stm.close();
            } catch (SQLException ex) {
                //
            }
        }
        return listNhanVien;
    }
//    public static void main(String[] args) {
//        NhanVien e =  new NhanVien();
//        e.setUserName("xuan");
//        e.setPassword("1");
//        NhanVien out = new NhanVienDAO().getNhanVienByAcount(e);
//        System.out.println(out.getHoTen());
//    }
}
