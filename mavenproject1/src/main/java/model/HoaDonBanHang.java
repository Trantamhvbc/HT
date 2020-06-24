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
    private ArrayList < RecordSanPham> listSanPhamSelected;
    private int soTien;
    private NhanVien nv;

    public HoaDonBanHang() {
       this.listSanPhamSelected = new ArrayList<>();
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
    public void add(RecordSanPham e){
        this.listSanPhamSelected.add(e);
    }

    public ArrayList<RecordSanPham> getListSanPhamSelected() {
        return listSanPhamSelected;
    }

    public void setListSanPhamSelected(ArrayList<RecordSanPham> listSanPhamSelected) {
        this.listSanPhamSelected = listSanPhamSelected;
    }
    public RecordSanPham remove(int row){
        return this.listSanPhamSelected.remove(row);
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
