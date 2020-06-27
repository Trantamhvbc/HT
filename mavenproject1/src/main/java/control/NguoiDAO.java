/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Nguoi;
import model.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Poly
 */
public class NguoiDAO extends DAO {

    public NguoiDAO() {
        super();
    }

    public static void main(String[] args) {
        Nguoi nguoi = new Nguoi();
        nguoi.setHoTen("TEst");
        nguoi.setDiaChi("TEst");
        nguoi.setEmail("TEst");
        nguoi.setGioiTinh("TEst");
        nguoi.setHocVan("TEst");
        nguoi.setNgaySinh("TEst");
        nguoi.setSoDienThoai("TEst");
        NguoiDAO nguoiDAO = new NguoiDAO();
        int kq = nguoiDAO.insertNguoi(nguoi);
        System.out.println(kq);
    }

    public int insertNguoi(Nguoi nguoi) {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "insert into [CuaHangHoaQua].[dbo].Nguoi (email,ngaySinh,gioiTinh,hocVan,diaChi,hoTen) values(?,?,?,?,?,?);" +
                    "SELECT SCOPE_IDENTITY()";
            preparedStatement = getCon().prepareStatement(sql);
            preparedStatement.setString(1, nguoi.getEmail());
            preparedStatement.setString(2, nguoi.getNgaySinh());
            preparedStatement.setString(3, nguoi.getGioiTinh());
            preparedStatement.setString(4, nguoi.getHocVan());
            preparedStatement.setString(5, nguoi.getDiaChi());
            preparedStatement.setString(6, nguoi.getHoTen());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            int idNguoi = -1;
            if (rs.next()) {
                idNguoi = rs.getInt(1);
            }
            return idNguoi;
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }
    public int updateNguoi(Nguoi nguoi) {
        PreparedStatement preparedStmt = null;
        try {
            String query = "update [CuaHangHoaQua].[dbo].Nguoi set email= ? , ngaySinh = ? , gioiTinh = ? , hocVan = ? , diaChi =?, hoTen = ? where idNguoi = ?";
            preparedStmt = getCon().prepareStatement(query);
            preparedStmt.setString(1, nguoi.getEmail());
            preparedStmt.setString(2, nguoi.getNgaySinh());
            preparedStmt.setString(3, nguoi.getGioiTinh());
            preparedStmt.setString(4, nguoi.getHocVan());
            preparedStmt.setString(5, nguoi.getDiaChi());
            preparedStmt.setString(6, nguoi.getHoTen());
            preparedStmt.setInt(7, nguoi.getId());
            return preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int getNguoiById(Nguoi nguoi) {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "insert into [CuaHangHoaQua].[dbo].Nguoi (id, email,ngaySinh,gioiTinh,hocVan,diaChi,hoTen) values(?,?,?,?,?,?);" +
                    "SELECT SCOPE_IDENTITY()";
            preparedStatement = getCon().prepareStatement(sql);
            preparedStatement.setString(1, nguoi.getEmail());
            preparedStatement.setString(2, nguoi.getNgaySinh());
            preparedStatement.setString(3, nguoi.getGioiTinh());
            preparedStatement.setString(4, nguoi.getHocVan());
            preparedStatement.setString(5, nguoi.getDiaChi());
            preparedStatement.setString(6, nguoi.getHoTen());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            int idNguoi = -1;
            if (rs.next()) {
                idNguoi = rs.getInt(1);
            }
            return idNguoi;
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }


}
