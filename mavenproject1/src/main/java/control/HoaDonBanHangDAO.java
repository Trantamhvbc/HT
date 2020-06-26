/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static com.lowagie.text.pdf.PdfFileSpecification.url;
import static control.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.BienLaiKho;
import model.*;

/**
 *
 * @author Duong
 */
public class HoaDonBanHangDAO extends DAO {

    public HoaDonBanHangDAO() {
        super();
    }
    
    public int themHoaDonBanHang(HoaDonBanHang hdbh) {
        String soLuong = "'" + hdbh.getSoLuong() + "',";
        String ngay = "'" + hdbh.getNgay() + "',";
        String idSanPham = "'2005',";
        String soTien = "N'" + hdbh.getSoTien() + "',";
        String idNhanVien = "N'" + hdbh.getNv().getIdNhanVien() + "'";
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql2 = "insert into [HoaDonBanHang] (soLuong,ngay,idSanPham,soTien,idNhanVien) values "
                + " (" + soLuong + ngay +idSanPham + soTien + idNhanVien + ")";
        int idHoaDon = 0;
        try {
 
            PreparedStatement prstm = con.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);
            int res = prstm.executeUpdate   ();
            if(res >0){
               ResultSet  result = prstm.getGeneratedKeys();
               while(result.next()){
                   idHoaDon =  result.getInt(1);
                   
               }
            }
            else{
                return -1;
            }
            prstm.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
       SPDBDAO spDAO = new SPDBDAO();
       for(RecordSanPham i : hdbh.getListSanPhamSelected()){
           if( spDAO.insertRecorpSanPham(i, idHoaDon) == -1){
               return -1;
           }
           
       }
       return 1;
    }

    public void themHoaDonBanHang(HoaDonBanHang hdbh, PhieuThuChi phieuThuChi) {
        String loaiPhieu = "N'" + phieuThuChi.getLoaiPhieu() + "',";
        String soPhieu = "N'" + phieuThuChi.getSoPhieu() + "',";
        String ngayLap = "N'" + phieuThuChi.getNgayLap() + "',";
        String tenDoiTuong = "N'" + phieuThuChi.getTenDoiTuong() + "',";
        String lyDo = "N'" + phieuThuChi.getLyDo() + "',";
        String dienGiai = "N'" + phieuThuChi.getDienGiai() + "',";
        String idNhanVien = "N'" + phieuThuChi.getNv().getIdNhanVien() + "',";
        String soTien = "N'" + phieuThuChi.getSoTien() + "',";
        String chuyenKhoan = "N'" + phieuThuChi.getChuyenKhoan() + "'";

        String sql = "insert into [PhieuThuChi] (loaiPhieu,soPhieu,ngayLap,tenDoiTuong,lyDo,dienGiai"
                + ",idNhanVien,soTien,chuyenKhoan)"
                + " values(" + loaiPhieu + soPhieu + ngayLap + tenDoiTuong + lyDo + dienGiai + idNhanVien + soTien + chuyenKhoan + ")";

        String soLuong = "'" + hdbh.getSoLuong() + "',";
        String ngay = "'" + hdbh.getNgay() + "',";
        //String idSanPham = "'" + hdbh.getSp().getIdSanPham() + "',";
        soTien = "N'" + hdbh.getSoTien() + "',";
        idNhanVien = "N'" + hdbh.getNv().getIdNhanVien() + "'";
        PreparedStatement stm = null;
        ResultSet rs = null;

        String sql2 = "insert into [HoaDonBanHang] (soLuong,ngay,idSanPham,soTien,idNhanVien) values "
                + " values(" + soLuong + ngay  + soTien + idNhanVien + ")";
        try {
            stm = con.prepareStatement(sql);
            stm.executeUpdate();
            stm = con.prepareStatement(sql2);
            stm.executeUpdate();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }


    public ArrayList<HoaDonBanHang> getHoaDonBanHangs() {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "select *  from [HoaDonBanHang]";
        ArrayList<HoaDonBanHang> hoaDonBanHangs = new ArrayList<>();
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                HoaDonBanHang hoaDonBanHang = new HoaDonBanHang();
                hoaDonBanHang.setIdHoaDonBanHang(rs.getInt("idHoaDonBanHang"));
                hoaDonBanHang.setNgay(rs.getString("ngay"));
                NhanVien nv = new NhanVien();
                nv.setId(rs.getInt("idNhanVien"));
                SanPham sp = new SanPham();
                sp.setIdSanPham(rs.getInt("idSanPham"));
                hoaDonBanHang.setNv(nv);
                hoaDonBanHang.setSoLuong(rs.getInt("soLuong"));
                hoaDonBanHang.setSoTien(rs.getInt("soTien"));
                hoaDonBanHangs.add(hoaDonBanHang);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } 
        return hoaDonBanHangs;
    }
   
    public int searchRecordSanPham(ArrayList<RecordSanPham> arr, int key){
        int c = 0;
        for(RecordSanPham i : arr){
            if(i.getPham().getIdMatHang()== key) return c;
            c++ ;
        }
        return arr.size();
    }
     public ArrayList<HoaDonBanHang> getHoaDonBanHangAndSPDB() {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT HoaDonBanHang.idHoaDonBanHang,SPDB.idSanPham,MatHang.idMatHang FROM [CuaHangHoaQua2].dbo.[HoaDonBanHang],[CuaHangHoaQua2].dbo.[SanPham], [CuaHangHoaQua2].dbo.SPDB,[CuaHangHoaQua2].dbo.[MatHang]\n" +
"WHERE SPDB.idHoaDonBanHang = HoaDonBanHang.idHoaDonBanHang AND SPDB.idSanPham = SanPham.idSanPham AND MatHang.idMatHang = SanPham.idMatHang ORDER BY HoaDonBanHang.idHoaDonBanHang";
        ArrayList<HoaDonBanHang> hoaDonBanHangs = new ArrayList<>();
        int i_size = 0;
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            int c = 0;
            while (rs.next()) {
                int idHoaDonBanHang = rs.getInt("idHoaDonBanHang");
                int idSPDB = rs.getInt("idSanPham");
                int idMatHang = rs.getInt("idMatHang");
                if(i_size == 0 || hoaDonBanHangs.get(i_size-1).getIdHoaDonBanHang() != idHoaDonBanHang){
                   HoaDonBanHang e = new HoaDonBanHang();
                   e.setIdHoaDonBanHang(idHoaDonBanHang);
                   SanPham sp = new SanPham();
                   sp.setIdSanPham(idSPDB);
                   sp.setIdMatHang(idMatHang);
                   RecordSanPham rcsp = new RecordSanPham();
                   rcsp.setPham(sp);
                   e.add(rcsp);
                   hoaDonBanHangs.add(e);
                   i_size++;
                }
                else{
                    
                    int index = searchRecordSanPham(hoaDonBanHangs.get(i_size-1).getListSanPhamSelected(), idMatHang);
                    if( index == hoaDonBanHangs.get(i_size-1).getListSanPhamSelected().size() ){
                        SanPham sp = new SanPham();
                        sp.setIdSanPham(idSPDB);
                        sp.setIdMatHang(idMatHang);
                        RecordSanPham rcsp = new RecordSanPham();
                        rcsp.setPham(sp);
                        hoaDonBanHangs.get(i_size-1).add(rcsp);
                    }
                }
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return hoaDonBanHangs;
    }
     public static void main(String[] args) {
        ArrayList<HoaDonBanHang> h = new HoaDonBanHangDAO().getHoaDonBanHangAndSPDB();
         System.out.println("H size "+h.size());
         
         System.err.println(h.get(0).getListSanPhamSelected().size());
    }
}
