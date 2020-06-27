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
public class BienLaiXuat extends BienLaiKho{
    private int idBienLaiXuat;
    private int tiLeThue;
    private int tiLeLai;
    private int soLuong;
    private CuaHang cuaHang;
    private NhanVien nv;

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public CuaHang getCuaHang() {
        return cuaHang;
    }

    public void setCuaHang(CuaHang cuaHang) {
        this.cuaHang = cuaHang;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }
    
    public BienLaiXuat() {
        this.tiLeLai=0;
        this.tiLeThue=0;
    }

    public int getIdBienLaiXuat() {
        return idBienLaiXuat;
    }

    public void setIdBienLaiXuat(int idBienLaiXuat) {
        this.idBienLaiXuat = idBienLaiXuat;
    }

    public int getTiLeThue() {
        return tiLeThue;
    }

    public void setTiLeThue(int tiLeThue) {
        this.tiLeThue = tiLeThue;
    }

    public int getTiLeLai() {
        return tiLeLai;
    }

    public void setTiLeLai(int tiLeLai) {
        this.tiLeLai = tiLeLai;
    }
    
    
}
