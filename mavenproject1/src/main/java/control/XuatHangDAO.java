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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import model.*;

/**
 *
 * @author Duong
 */
public class XuatHangDAO extends DAO {

    public XuatHangDAO() {
        super();
    }

    public ArrayList<RecordSanPham> loadSanPhamXuatKho(Kho kho) {
        ArrayList<Integer> listIdSp = new ArrayList<>();
        ArrayList<Integer> listConLai = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql2 = "select SanPham.idSanPham, (BienLaiKho.soLuong-SPDB.soLuong) as conLai  from [HoaDonBanHang] ,[SanPham],[SPDB] WHERE SanPham.idSanPham=SPDB.idSanPham and  BienLaiKho.idBienLaiKho=SanPham.idSanPham ";
        String sql = "   select * from [SanPham] sp inner join   [BienLaiKho] blk on sp.idBienLaiKho=blk.idBienLaiKho \n"
                + "               inner join  [BienLaiXuat] blx on sp.idBienLaiKho=blx.idBienLaiKho inner join [MatHang] mh on sp.idMatHang=mh.idMatHang where idKho=" + kho.getId();
        ArrayList<RecordSanPham> listSanPhamDX = new ArrayList<RecordSanPham>();
        try {
            stm = con.prepareStatement(sql2);
            rs = stm.executeQuery();
            while (rs.next()) {
                listIdSp.add(rs.getInt("idSanPham"));
                listConLai.add(rs.getInt("conLai"));
            }
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSp(rs.getString("maSp"));
                sp.setIdSanPham(rs.getInt("idSanPham"));
                RecordSanPham recordSanPham = new RecordSanPham();
                boolean check = false;
                for (int i = 0; i < listIdSp.size(); i++) {
                    if (sp.getIdSanPham() == listIdSp.get(i).intValue()) {
                        int conLai = listConLai.get(i);
                        recordSanPham.setSoLuong(conLai);
                        check = true;
                    }

                }
                sp.setTenMatHang(rs.getString("tenMatHang"));
                sp.setMaMatHang(rs.getString("maMatHang"));
                sp.setGia(rs.getInt("gia"));
                sp.setHanSuDung(rs.getString("hanSuDung"));
                sp.setIdMatHang(rs.getInt("idMatHang"));
                BienLaiKho blk = new BienLaiKho();
                int soLuong = rs.getInt("soLuong");
                blk.setId(rs.getInt("idBienLaiKho"));
                sp.setBienLaiKho(blk);
                sp.setDonViTinh(rs.getString("donVi"));
                recordSanPham.setPham(sp);
                if (!check) {
                    recordSanPham.setSoLuong(soLuong);
                }
                listSanPhamDX.add(recordSanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPhamDX;
    }

    public ArrayList<RecordSanPham> loadMatHangTrongKhoTheoKho(Kho kho) {
        System.out.println("a");
        PreparedStatement stm = null;
        ResultSet rs = null;
        ResultSet rs2 = null;

        String sql = "  select sp.maSp, sp.idSanPham,mh.tenMatHang,mh.maMatHang, sp.gia,sp.hanSuDung,sp.idMatHang,blk.idBienLaiKho,blk.soLuong,mh.donVi from [SanPham] sp inner join   [BienLaiKho] blk on sp.idBienLaiKho=blk.idBienLaiKho \n"
                + "  inner join  [BienLaiNhap] bln on sp.idBienLaiKho=bln.idBienLaiKho inner join [MatHang] mh on sp.idMatHang=mh.idMatHang where blk.soLuong>0 and idKho=" + kho.getId();
        String sql2 = "select sum(tiLeThue) as tongSoLuongXuat, idBienLaiKho from BienLaiXuat group by idBienLaiKho";
        ArrayList<RecordSanPham> listMHTrongKho = new ArrayList<RecordSanPham>();
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            stm = con.prepareStatement(sql2);
            rs2 = stm.executeQuery();
            ArrayList<RecordSoLuongBLX> listTongXuat = new ArrayList<>();
            while (rs2.next()) {
                RecordSoLuongBLX recordSoLuongBLX = new RecordSoLuongBLX();
                recordSoLuongBLX.setIdBienLaiKho(rs2.getInt("idBienLaiKho"));
                recordSoLuongBLX.setSoLuong(rs2.getInt("tongSoLuongXuat"));
                listTongXuat.add(recordSoLuongBLX);
            }
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSp(rs.getString("maSp"));
                sp.setIdSanPham(rs.getInt("idSanPham"));
                sp.setTenMatHang(rs.getString("tenMatHang"));
                sp.setMaMatHang(rs.getString("maMatHang"));
                sp.setGia(rs.getInt("gia"));
                sp.setHanSuDung(rs.getString("hanSuDung"));
                sp.setIdMatHang(rs.getInt("idMatHang"));
                BienLaiKho blk = new BienLaiKho();
                blk.setId(rs.getInt("idBienLaiKho"));
                int tongXuat = 0;
                for (int i = 0; i < listTongXuat.size(); i++) {
                    int id = listTongXuat.get(i).getIdBienLaiKho();
                    if (id == blk.getId()) {
                        tongXuat = listTongXuat.get(i).getSoLuong();
                        i = listTongXuat.size();
                    }
                }
                sp.setBienLaiKho(blk);
                int soLuong = rs.getInt("soLuong");
                sp.setDonViTinh(rs.getString("donVi"));
                RecordSanPham recordSanPham = new RecordSanPham();
                recordSanPham.setPham(sp);
                int conLai = 0;
                if (soLuong - tongXuat > 0) {
                    conLai = soLuong - tongXuat;
                    recordSanPham.setSoLuong(conLai);
                    listMHTrongKho.add(recordSanPham);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMHTrongKho;
    }
}
