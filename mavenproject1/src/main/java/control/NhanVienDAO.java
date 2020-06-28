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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;
import model.*;

/**
 *
 * @author Duong
 */
public class NhanVienDAO extends DAO {
    private final NguoiDAO nguoiDAO;
    private final BoPhanDAO boPhanDAO;
    private final CuaHangDAO cuaHangDAO;
    
    public NhanVienDAO() {
        super();
        nguoiDAO = new NguoiDAO();
        boPhanDAO = new BoPhanDAO();
        cuaHangDAO = new CuaHangDAO();
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
    
     private NhanVien resultSet2NhanVien(ResultSet rs) throws SQLException {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setId(rs.getInt(7));
        nhanVien.setEmail(rs.getString(10));
        nhanVien.setNgaySinh(rs.getString(11));
        nhanVien.setGioiTinh(rs.getString(12));
        nhanVien.setHocVan(rs.getString(13));
        nhanVien.setDiaChi(rs.getString(14));
        nhanVien.setHoTen(rs.getString(15));
        nhanVien.setIdNhanVien(rs.getInt(1));
        nhanVien.setVaiTro(rs.getString(2));
        nhanVien.setUserName(rs.getString(3));
        nhanVien.setPassword(rs.getString(4));
        int idBoPhan = rs.getInt(5);
        int idCuaHang = rs.getInt(6);
        BoPhan boPhan = boPhanDAO.getBoPhanById(idBoPhan);
        CuaHang cuaHang = cuaHangDAO.getCuaHangById(idCuaHang);
        nhanVien.setBoPhan(boPhan);
        nhanVien.setCuaHang(cuaHang);
        return nhanVien;
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
    
    public List<NhanVien> getNhanVienByName(String name) {
        String sql = "select *  from [NhanVien] inner join [Nguoi] on NhanVien.idNhanVien=Nguoi.idNguoi "
                + "where Nguoi.hoTen like ?";
        PreparedStatement pre = null;
        ResultSet rs = null;
        List<NhanVien> listNV = new ArrayList<>();
        try {
            pre = getCon().prepareStatement(sql);
            pre.setString(1, "%"+name+"%");
            rs= pre.executeQuery();
            
            while (rs.next()) {
                NhanVien nhanVien = resultSet2NhanVien(rs);
                listNV.add(nhanVien);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return listNV;
    }
      
    public NhanVien getNhanVienById(int idNhanVien) {
        String sql = "select * from  [NhanVien]  inner join [Nguoi] on NhanVien.idNhanVien=Nguoi.idNguoi where idNhanVien = ?";
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            pre = getCon().prepareStatement(sql);
            pre.setInt(1, idNhanVien);
            rs = pre.executeQuery();
            if (rs.next()) {
                return resultSet2NhanVien(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insertNV(NhanVien nv) {
        PreparedStatement pre = null;
        try {
            String sql = "insert into NhanVien (vaiTro,username,[password],idBoPhan,idCuaHang,idNguoi) "
                    + "values (?,?,?,?,?,?)";
            pre = getCon().prepareStatement(sql);
            pre.setString(1, nv.getVaiTro());
            pre.setString(2, nv.getUserName());
            pre.setString(3, nv.getPassword());
            pre.setInt(4, nv.getBoPhan().getId());
            pre.setInt(5, nv.getCuaHang().getId());
            pre.setInt(6, nv.getId());
            return pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pre.close();
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return 0;
    }
   

    public int deleteNV(NhanVien nv) {
        PreparedStatement pre = null;
        int idNV = nv.getIdNhanVien();
        String sql = "delete from [NhanVien] WHERE idNhanVien = " + idNV + ";";
        try {
            pre = getCon().prepareStatement(sql);
            return pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pre.close();
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    public int updateVaiTroVaBoPhan(NhanVien nhanVien) {
        PreparedStatement preparedStmt = null;
        try {
            String query = "update [NhanVien] set vaiTro= ?, idBoPhan = ? where idNhanVien = ?";
            preparedStmt = getCon().prepareStatement(query);
            preparedStmt.setString(1, nhanVien.getVaiTro());
            preparedStmt.setInt(2, nhanVien.getBoPhan().getId());
            preparedStmt.setInt(3, nhanVien.getIdNhanVien());
            return preparedStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                preparedStmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
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

    
}
