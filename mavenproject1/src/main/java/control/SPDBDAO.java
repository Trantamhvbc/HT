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
import model.MatHang;
import model.RecordSanPham;
import model.RecordSoLuongBLX;
import model.SanPham;

/**
 *
 * @author tuan2
 */
public class SPDBDAO extends DAO{

    public SPDBDAO() {
        super();
    }
    public  int getTongSoLuongSPDB(SanPham e, int hienco){
        String sql = "SELECT SUM(SPDB.soLuong)  FROM [SPDB] WHERE SPDB.idSanPham = ?";
        int res = hienco;
        try {
            
            PreparedStatement prstm = con.prepareStatement(sql);
            prstm.setInt(1, e.getIdSanPham());
            ResultSet result = prstm.executeQuery();
            while(result.next()){
                res -= result.getInt(1);
                return res;
            }
        } catch (SQLException ex) {
           
            Logger.getLogger(SPDBDAO.class.getName()).log(Level.SEVERE, null, ex);
            return hienco;
        }
        finally{
            return res;
        }
        
    }
    public ArrayList <RecordSanPham> getAllSanPhamTrenCuaHang(){
        ArrayList<RecordSanPham> res =  new ArrayList();
        String sql = "select MatHang.*,SanPham.*, BienLaiKho.soLuong from  [MatHang],[SanPham] ,\n" +
                "[BienLaiKho]  WHERE SanPham.idBienLaiKho = BienLaiKho.idBienLaiKho \n" +
                "and MatHang.idMatHang = SanPham.idMatHang";
         String sql2 = "select sum(tiLeThue) as tongSoLuongXuat, idBienLaiKho from BienLaiXuat group by idBienLaiKho";
        ArrayList<RecordSanPham> listMHTrongKho = new ArrayList<RecordSanPham>();
        
        try {
            PreparedStatement stm = con.prepareStatement(sql2);
            ResultSet rs2 = stm.executeQuery();
            ArrayList<RecordSoLuongBLX> listTongXuat = new ArrayList<>();
            while (rs2.next()) {
                RecordSoLuongBLX recordSoLuongBLX = new RecordSoLuongBLX();
                recordSoLuongBLX.setIdBienLaiKho(rs2.getInt("idBienLaiKho"));
                recordSoLuongBLX.setSoLuong(rs2.getInt("tongSoLuongXuat"));
                listTongXuat.add(recordSoLuongBLX);
            }
            PreparedStatement prstm = con.prepareStatement(sql);
            ResultSet result = prstm.executeQuery();
            while(result.next()){
               MatHang mh = new MatHang();
               mh.setIdMatHang(result.getInt("idMatHang"));
               mh.setMaMatHang(result.getString("maMatHang"));
               mh.setTenMatHang(result.getString("tenMatHang"));
               mh.setMoTa( result.getString("moTa"));
               mh.setDonViTinh( result.getString("donVi"));
               SanPham sp = new SanPham(mh);
               sp.setIdSanPham(result.getInt("idSanPham") );
               sp.setGia(result.getInt("gia"));
               sp.setHanSuDung(result.getString("hanSuDung"));
               //int hienco = result.getInt("soLuong");
               int hienco=0;
                int idBienLaiKho=result.getInt("idBienLaiKho");
                int tongXuat = 0;
                for (int i = 0; i < listTongXuat.size(); i++) {
                    int id = listTongXuat.get(i).getIdBienLaiKho();
                    if (idBienLaiKho ==id) {
                        hienco = listTongXuat.get(i).getSoLuong();
                        i = listTongXuat.size();
                    }
                }
               int tongHienCo = getTongSoLuongSPDB(sp, hienco) ;
               if(tongHienCo > 0){
                    //RecordSanPham rcsp = new RecordSanPham(sp, getTongSoLuongSPDB(sp, tongHienCo));
                    RecordSanPham rcsp = new RecordSanPham(sp, tongHienCo);
                    res.add(rcsp);
               }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SPDBDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            return res;
        }
                
    }
    public int insertRecorpSanPham(RecordSanPham rs,int idHoaDon){
        try {
            String sql = "INSERT INTO SPDB (idHoaDonBanHang,idSanPham,soLuong) VALUES (?,?,?)";
            
            PreparedStatement prstm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            prstm.setInt(1,idHoaDon );
            prstm.setInt(2, rs.getPham().getIdSanPham());
            prstm.setInt(3,rs.getSoLuong());
            int res = prstm.executeUpdate();
            if(res >0){
                ResultSet  result = prstm.getGeneratedKeys();
                while(result.next()){
                    return result.getInt(1);
                }
            }
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(SPDBDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    public static void main(String[] args) {
        ArrayList <RecordSanPham> arr = new SPDBDAO().getAllSanPhamTrenCuaHang();
        System.out.println(arr.size());
    }
    
}
