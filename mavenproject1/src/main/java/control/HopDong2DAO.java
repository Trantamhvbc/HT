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
import model.HopDong;
import model.NhaCungCap;
import model.NhanVien;

/**
 *
 * @author Duong
 */
public class HopDong2DAO extends DAO {

    public HopDong2DAO() {
        super();
    }

    public boolean themHopDong(HopDong hopDong, NhaCungCap nhaCungCap, NhanVien nhanVien ) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String idHopDong;
        System.out.println("HopDong" + hopDong);
        
        
        String tenHopDong = "'" + hopDong.getTenHopDong()+ "',";
        String ngayKi = "'" + hopDong.getNgayKi() + "',";
        String denNgay = "'" + hopDong.getDenNGay() + "',";
        String idNhanVien = "N'" + hopDong.getNv().getIdNhanVien() + "'";
        String idNhaCungCap;
        
        

        String maNhanVien = "'" + nhanVien.getIdNhanVien() + "',";

        
        String maNhaCungCap = "'" + nhaCungCap.getId() + "',";
        String ten = "'" + nhaCungCap.getTen()+ "',";
        String email = "'" + nhaCungCap.getEmail()+ "',";
        String sdt = "'" + nhaCungCap.getSodienthoai()+ "'";

        
        
        try {
            String sql2 = "insert into [NhaCungCap] (ten,email,sodienthoai)"
                    + " values("   +ten + email + sdt + ")";
            System.out.println(sql2);
            System.out.println(con);
            stm = con.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);
            int maxId=stm.executeUpdate();
            if(maxId>0){
                ResultSet resultSet=stm.getGeneratedKeys();
                while(resultSet.next()){
                    maxId=resultSet.getInt(1);
                   
                }
            }
            idNhaCungCap= "'" + (maxId) + "',";
            String sql = "insert into [HopDong] (idNhaCungCap,tenHopDong,ngayKi,denNgay,idNhanVien)"
                    + " values(" + idNhaCungCap + tenHopDong + ngayKi + denNgay + maNhanVien +  ")";
         
            stm = con.prepareStatement(sql);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                    System.out.println("roll back...HopDongDAO");
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
}
