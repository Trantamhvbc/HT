/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Duong
 */
package model;

import java.util.Objects;

public class NhanVien extends Nguoi{
    private int idNhanVien;
    private String vaiTro;
    private String userName;
    private String password;
    private BoPhan boPhan;
    private CuaHang cuaHang;

    public NhanVien() {
    }

     public NhanVien(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
   
    public NhanVien(int idNhanVien, String vaiTro, String userName, String password, BoPhan boPhan, CuaHang cuaHang) {
        this.idNhanVien = idNhanVien;
        this.vaiTro = vaiTro;
        this.userName = userName;
        this.password = password;
        this.boPhan = boPhan;
        this.cuaHang = cuaHang;
    }

    public NhanVien(int idNhanVien) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BoPhan getBoPhan() {
        return boPhan;
    }

    public void setBoPhan(BoPhan boPhan) {
        this.boPhan = boPhan;
    }

    public CuaHang getCuaHang() {
        return cuaHang;
    }

    public void setCuaHang(CuaHang cuaHang) {
        this.cuaHang = cuaHang;
    }
    
    @Override
    public String toString() {
        return "NhanVien{" + "idNhanVien=" + idNhanVien + ", vaiTro=" + vaiTro + ", userName=" + userName + ", password=" + password + ", boPhan=" + boPhan + ", cuaHang=" + cuaHang + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NhanVien)) return false;
        NhanVien nhanVien = (NhanVien) o;
        return getIdNhanVien() == nhanVien.getIdNhanVien() &&
                Objects.equals(getVaiTro(), nhanVien.getVaiTro()) &&
                Objects.equals(getUserName(), nhanVien.getUserName()) &&
                Objects.equals(getBoPhan(), nhanVien.getBoPhan()) &&
                Objects.equals(getCuaHang(), nhanVien.getCuaHang());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdNhanVien(), getVaiTro(), getUserName(), getBoPhan(), getCuaHang());
    }
    
}
