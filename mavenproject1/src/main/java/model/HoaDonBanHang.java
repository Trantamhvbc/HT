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

import java.util.ArrayList;

public class HoaDonBanHang {
    private int idHoaDonBanHang;
    private int soLuong;
    private String ngay;
    private ArrayList<RecordSanPham> listSanPham;
    private int soTien;
    private NhanVien nv;

    public HoaDonBanHang() {
        listSanPham = new ArrayList<>();
    }
    public void  addRecordSanPham(RecordSanPham e){
        this.listSanPham.add(e);
    }
    public ArrayList<RecordSanPham> getListSanPham() {
        return listSanPham;
    }

    public void setListSanPham(ArrayList<RecordSanPham> listSanPham) {
        this.listSanPham = listSanPham;
    }
    

    public int getIdHoaDonBanHang() {
        return idHoaDonBanHang;
    }

    public void setIdHoaDonBanHang(int idHoaDonBanHang) {
        this.idHoaDonBanHang = idHoaDonBanHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
    
    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }
    
}
