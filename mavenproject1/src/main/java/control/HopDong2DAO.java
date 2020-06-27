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
public class HopDong2DAO extends DAO {

    public HopDong2DAO() {
        super();
    }

    public boolean themHopDong(HopDong hopDong, NhaCungCap nhaCungCap, NhanVien nhanVien) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String idHopDong;
        String tenHopDong = "'" + hopDong.getTenHopDong() + "',";
        String ngayKi = "'" + hopDong.getNgayKi() + "',";
        String denNgay = "'" + hopDong.getDenNGay() + "',";
        String idNhanVien = "'" + hopDong.getNv().getIdNhanVien() + "',";

        String maNhanVien = "'" + nhanVien.getIdNhanVien() + "',";

        String ten = "N'" + nhaCungCap.getTen() + "',";
        String email = "N'" + nhaCungCap.getEmail() + "',";
        String sdt = "N'" + nhaCungCap.getSodienthoai() + "'";

        try {
            String sql2 = "insert into [NhaCungCap] (ten,email,sodienthoai)"
                    + " values (" + ten + email + sdt + ")";
            String sql="insert into nhacungcap (ten,email,sodienthoai) values ('a','b','c')";
            stm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            int maxId=stm.executeUpdate();
            if (maxId > 0) {
                ResultSet resultSet = stm.getGeneratedKeys();
                while (resultSet.next()) {
                    maxId = resultSet.getInt(1);
                    break;

                }
            }
            String idNhaCungCap="'" + maxId + "'";
            String sql3 = "insert into HopDong (tenHopDong,ngayKi,denNgay,idNhanVien,idNhaCungCap) "
                    + "values (" + tenHopDong +ngayKi+denNgay+idNhanVien+idNhaCungCap+ ")";

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
