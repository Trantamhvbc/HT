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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MatHang;

/**
 *
 * @author Duong
 */
public class MatHangDAO extends DAO {

    public MatHangDAO() {
        super();
    }
    public MatHang getMatHang(int idMatHang){
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM MatHang WHERE idMatHang = '"+idMatHang+"'";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            MatHang res = new MatHang();
            while(rs.next()){
                res.setIdMatHang(idMatHang);
                res.setMaMatHang(rs.getString("maMatHang"));
                res.setDonViTinh(rs.getString("donVi"));
                res.setMoTa(rs.getString("moTa"));
                res.setTenMatHang(rs.getString("tenMatHang"));
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return new MatHang();
        
    }
    public ArrayList<MatHang> getAllMatHang() {
        System.out.println("dang get All Mat Hang");
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "select *  from [MatHang]";
        ArrayList<MatHang> listMatHang = new ArrayList<>();
        try {
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                MatHang mh = new MatHang();
                mh.setIdMatHang(rs.getInt(1));
                mh.setMaMatHang(rs.getString(2));
                mh.setTenMatHang(rs.getString(3));
                mh.setMoTa(rs.getString(4));
                mh.setDonViTinh(rs.getString(5));
                listMatHang.add(mh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return listMatHang;
    }
    public boolean themMatHang(MatHang hang) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        String ma = "N'" + hang.getMaMatHang() + "',";
        String ten = "N'" + hang.getTenMatHang() + "',";
        String donVi = "N'" + hang.getDonViTinh() + "',";
        String mota = "N'" + hang.getMoTa() + "'";
        String sql = "insert into [MatHang] (maMatHang,tenMatHang,donVi,moTa)"
                + " values(" + ma + ten + donVi + mota + ")";
        try {
            stm = con.prepareStatement(sql);
            stm.executeUpdate();
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                    System.out.println("roll back...MatHangDAO");
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
        MatHangDAO mhdao = new MatHangDAO();
        MatHang hang = new MatHang();
        hang.setMaMatHang("fasdf");
        hang.setMoTa("àdasd");
        hang.setTenMatHang("àdsaf");
        //mhdao.themMatHang(hang);
        ArrayList<MatHang> listMh=mhdao.getAllMatHang();
        System.out.println(listMh.size());
    }
}
