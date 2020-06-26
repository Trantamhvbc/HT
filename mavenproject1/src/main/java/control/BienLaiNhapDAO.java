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
import model.*;

/**
 *
 * @author Duong
 */
public class BienLaiNhapDAO extends DAO {

    public BienLaiNhapDAO() {
        super();
    }

    public ArrayList<BienLaiNhap> getAllBienLaiNhap() {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "select *  from [BienLaiNhap] inner join [BienLaiKho] on BienLaiNhap.idBienLaiKho=BienLaiKho.idBienLaiKho";
        ArrayList<BienLaiNhap> listBienLaiNhap = new ArrayList<>();
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                BienLaiNhap bienLaiNhap = new BienLaiNhap();
                bienLaiNhap.setIdBienLaiNhap(rs.getInt(1));
                bienLaiNhap.setId(rs.getInt(2));// set Id bien lai kho
                HopDong dong = new HopDong();
                dong.setId(rs.getInt(3));
                PhieuThuChi chi = new PhieuThuChi();
                chi.setIdPhieuThuChi(rs.getInt(4));
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getInt(5));
                ///////////////
                bienLaiNhap.setHopDong(dong);
                bienLaiNhap.setPhieuThuChi(chi);
                bienLaiNhap.setNhanVien(nhanVien);
                bienLaiNhap.setId(rs.getInt(6));
                bienLaiNhap.setMaBienLai(rs.getString(7));
                bienLaiNhap.setNgayLap(rs.getString(8));
                Kho k = new Kho();
                k.setId(rs.getInt(9));
                bienLaiNhap.setKho(k);
                bienLaiNhap.setSoLuong(rs.getInt(10));
                listBienLaiNhap.add(bienLaiNhap);
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
        return listBienLaiNhap;
    }

    public boolean themBienLaiNhapPhieuThuChi(BienLaiNhap bienLaiNhap, SanPham pham) {
        System.out.println(con);
        PreparedStatement stm = null;
        ResultSet rs = null;
        String idBienLaiNhap = "'" + bienLaiNhap.getIdBienLaiNhap() + "',";
        String idBienLaiKho;
        String idHopDong = "'" + bienLaiNhap.getHopDong().getId() + "',";
        String idNhanVien = "'" + bienLaiNhap.getNhanVien().getIdNhanVien() + "'";
        String idPhieuThuChi = "'" + bienLaiNhap.getPhieuThuChi().getIdPhieuThuChi() + "',";
        String maBienLaiKho = "N'" + bienLaiNhap.getMaBienLai() + "',";
        String ngayLap = "N'" + bienLaiNhap.getNgayLap() + "',";
        String soLuong = "N'" + bienLaiNhap.getSoLuong() + "',";
        String idKho = "N'" + bienLaiNhap.getKho().getId() + "',";
        String tongTien = "N'" + bienLaiNhap.getTongCong() + "'";
        ////////////////////////--------SanPham
        String idSanPham = "'" + pham.getGia() + "',";
        String maSanPham = "'" + pham.getMaSp() + "',";
        String hanSuDung = "'" + pham.getHanSuDung() + "',";
        String idMatHang = "'" + pham.getIdMatHang() + "'";
        String gia = "'" + pham.getGia() + "',";
        System.out.println("BienLaiNhapDAO " + pham.getIdMatHang());
        ////////////// // //
        try {

            String sql2 = "insert into [BienLaiKho] (maBienLaiKho,ngayLap,idKho,soLuong,tongCong)"

                    + " values(" + maBienLaiKho + ngayLap + idKho + soLuong + tongTien + ")";
            int maxId;
            stm = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            maxId = stm.executeUpdate();
            if (maxId > 0) {
                ResultSet resultSet = stm.getGeneratedKeys();
                while (resultSet.next()) {
                    maxId = resultSet.getInt(1);
                }
            }
            String sql3 = "select max(idBienLaiKho) as idBienLaiKho from [BienLaiKho]";
            stm = con.prepareStatement(sql3);
            rs = stm.executeQuery();
            maSanPham = "'" + (pham.getMaSp() + "" + maxId) + "',";
            idBienLaiKho = "'" + (maxId) + "',";
            sql3 = "select max(idPhieuThuChi) as idPhieuThuChi from [PhieuThuChi]";
            sql3 = "select max(idPhieuThuChi) as idPhieuThuChi from [PhieuThuChi]";
            stm = con.prepareStatement(sql3);
            rs = stm.executeQuery();
            maxId = 0;
            while (rs.next()) {
                maxId = rs.getInt("idPhieuThuChi");
            }
            idPhieuThuChi = "'" + (maxId) + "',";

            sql3 = "insert into [SanPham] (idBienLaiKho,maSp,gia,hanSuDung,idMatHang)"
                    + " values(" + idBienLaiKho + maSanPham + gia + hanSuDung + idMatHang + ")";
            String sql = "insert into [BienLaiNhap] (idBienLaiKho,idHopDong,idPhieuThuChi,idNhanVien)"
                    + " values(" + idBienLaiKho + idHopDong + idPhieuThuChi + idNhanVien + ")";
            System.out.println(sql);
            stm = con.prepareStatement(sql3);
            stm.executeUpdate();
            stm = con.prepareStatement(sql);
            stm.executeUpdate();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                    System.out.println("roll back...BienLaiNhapDAO");
                }
            } catch (SQLException ex2) {
                ex2.printStackTrace();
            }
            return false;
        }
        return true;
    }

    public boolean themBienLaiNhapCongNo(BienLaiNhap bienLaiNhap, SanPham pham) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String idBienLaiNhap = "'" + bienLaiNhap.getIdBienLaiNhap() + "',";
        String idBienLaiKho;
        String idHopDong = "'" + bienLaiNhap.getHopDong().getId() + "',";
        String idNhanVien = "'" + bienLaiNhap.getNhanVien().getIdNhanVien() + "'";
        String maBienLaiKho = "N'" + bienLaiNhap.getMaBienLai() + "',";
        String ngayLap = "N'" + bienLaiNhap.getNgayLap() + "',";
        String soLuong = "N'" + bienLaiNhap.getSoLuong() + "',";
        String idKho = "N'" + bienLaiNhap.getKho().getId() + "',";
        String tongTien = "N'" + bienLaiNhap.getTongCong() + "'";
        ////////////////////////--------SanPham
        String idSanPham = "'" + pham.getGia() + "',";
        String maSanPham = "'" + pham.getMaSp() + "',";
        String hanSuDung = "'" + pham.getHanSuDung() + "',";
        String idMatHang = "'" + pham.getIdMatHang() + "'";
        String gia = "'" + pham.getGia() + "',";
        System.out.println("BienLaiNhapDAO " + pham.getIdMatHang());
        ////////////// // //
        try {
            String sql2 = "insert into [BienLaiKho] (maBienLaiKho,ngayLap,idKho,soLuong,tongCong)"
                    + " values(" + maBienLaiKho + ngayLap + idKho + soLuong + tongTien + ")";
            stm = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            int maxId = 0;
            maxId = stm.executeUpdate();
            if (maxId > 0) {
                ResultSet resultSet = stm.getGeneratedKeys();
                while (resultSet.next()) {
                    maxId = resultSet.getInt(1);
                }
            }
            
            String sql3 = "select idBienLaiKho from [BienLaiKho]";
            stm = con.prepareStatement(sql3);
            rs = stm.executeQuery();
            maSanPham = "'" + (pham.getMaSp() + "" + maxId) + "',";
            idBienLaiKho = "'" + (maxId) + "',";
            System.out.println("maxID" + (maxId));
            sql3 = "insert into [SanPham] (idBienLaiKho,maSp,gia,hanSuDung,idMatHang)"
                    + " values(" + idBienLaiKho + maSanPham + gia + hanSuDung + idMatHang + ")";
            String sql = "insert into [BienLaiNhap] (idBienLaiKho,idHopDong,idNhanVien)"
                    + " values(" + idBienLaiKho + idHopDong + idNhanVien + ")";
            System.out.println(sql);
            stm = con.prepareStatement(sql3);
            stm.executeUpdate();
            stm = con.prepareStatement(sql);
            stm.executeUpdate();
            con.commit();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                    System.out.println("roll back...BienLaiNhapDAO");
                }
            } catch (SQLException ex2) {
                ex2.printStackTrace();
            }
            return false;
        } finally {
            try {
                stm.close();
            } catch (SQLException ex3) {
                //
                ex3.printStackTrace();
            }
        }
        return true;
    }

    public boolean themBienLaiNhapPhieuThuChi(BienLaiNhap bienLaiNhap) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String idBienLaiNhap = "'" + bienLaiNhap.getIdBienLaiNhap() + "',";
        String idBienLaiKho = "'" + bienLaiNhap.getId() + "',";//get id bien lai kho
        String idHopDong = "'" + bienLaiNhap.getHopDong().getId() + "',";
        String idPhieuThuChi = "'" + bienLaiNhap.getPhieuThuChi().getIdPhieuThuChi() + "',";
        String idNhanVien = "'" + bienLaiNhap.getNhanVien().getIdNhanVien() + "'";
        String maBienLaiKho = "N'" + bienLaiNhap.getMaBienLai() + "',";
        String ngayLap = "N'" + bienLaiNhap.getNgayLap() + "',";
        String soLuong = "N'" + bienLaiNhap.getSoLuong() + "',";
        String idKho = "N'" + bienLaiNhap.getKho().getId() + "',";
        String tongTien = "N'" + bienLaiNhap.getTongCong() + "'";

        String sql = "insert into [BienLaiNhap] (idBienLaiKho,idHopDong,idPhieuThuChi,idNhanVien)"
                + " values(" + idBienLaiKho + idHopDong + idPhieuThuChi + idNhanVien + ")";
        String sql2 = "insert into [BienLaiKho] (maBienLaiKho,ngayLap,idKho,soLuong,tongCong)"
                + " values(" + maBienLaiKho + ngayLap + idKho + soLuong + tongTien + ")";
        try {
            stm = con.prepareStatement(sql);
            stm.executeUpdate();
            stm = con.prepareStatement(sql2);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                    System.out.println("roll back...BienLaiNhapDAO");
                }
            } catch (SQLException ex2) {
                ex2.printStackTrace();
            }
            return false;
        } finally {
            try {
                stm.close();
            } catch (SQLException ex3) {
                //
                ex3.printStackTrace();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HopDong dong = new HopDong();
        dong.setId(1);
        NhanVien nhanVien = new NhanVien();
        nhanVien.setIdNhanVien(1);
        PhieuThuChi chi = new PhieuThuChi();
        BienLaiNhap bienLaiNhap = new BienLaiNhap();
        bienLaiNhap.setHopDong(dong);
        Kho k = new Kho();
        k.setId(1);
        bienLaiNhap.setKho(k);
        bienLaiNhap.setNhanVien(nhanVien);
        BienLaiNhapDAO aO = new BienLaiNhapDAO();
        aO.themBienLaiNhapCongNo(bienLaiNhap, new SanPham());
    }
}
