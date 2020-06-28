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
import model.*;

/**
 *
 * @author Duong
 */
public class NhaCungCap1DAO extends DAO {

    public NhaCungCap1DAO() {
        super();
    }
   
    public ArrayList<NhaCungCap> getAllNhaCungCap() {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "select *  from [NhaCungCap]";
        ArrayList<NhaCungCap> listNhaCC = new ArrayList<>();
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap();
                ncc.setId(rs.getInt("idNhaCungCap"));
                ncc.setTen(rs.getString("ten"));
                ncc.setSodienthoai(rs.getString("sodienthoai"));
                ncc.setEmail(rs.getString("email"));
                listNhaCC.add(ncc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } 
        return listNhaCC;
    }
    public boolean themNhaCungCap(NhaCungCap ncc) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        String ten = "N'" + ncc.getTen()+ "',";
        String email = "N'" + ncc.getEmail()+ "',";
        String sdt = "N'" + ncc.getSodienthoai()+ "'";
        
        
        String sql = "insert into [CuaHangHoaQua].[dbo].[NhaCungCap] (ten,email,sodienthoai)"
                + " values(" + ten + email + sdt +  ")";
        try {
            con.setAutoCommit(false);
            stm = con.prepareStatement(sql);
            stm.executeUpdate();
            con.commit();
            con.close();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                    System.out.println("roll back...NhaCungCapDAO");
                }
            } catch (SQLException ex2) {
                ex2.printStackTrace();
            }
            return false;
        } finally {
            try {
                stm.close();
                con.close();
            } catch (SQLException ex3) {
                //
                ex3.printStackTrace();
            }
        }
        return true;
    }
     public static void main(String[] args) {
        NhaCungCap1DAO nccDao = new NhaCungCap1DAO();
        NhaCungCap ncc = new NhaCungCap();
        ncc.setTen("Huyen");
        ncc.setEmail("àdasd");
        ncc.setSodienthoai("0909090645");
        //mhdao.themMatHang(hang);
        ArrayList<NhaCungCap> listNcc=nccDao.getAllNhaCungCap();
        System.out.println(listNcc.size());
    }
}