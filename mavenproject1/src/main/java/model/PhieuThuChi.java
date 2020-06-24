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
public class PhieuThuChi {
    private int idPhieuThuChi;
    private String loaiPhieu;
    private String soPhieu;
    private String ngayLap;
    private String tenDoiTuong ;
    private String lyDo;
    private String dienGiai;
    private NhanVien nv;
    private int soTien;
    private String chuyenKhoan;

    public PhieuThuChi() {
    }

    public int getIdPhieuThuChi() {
        return idPhieuThuChi;
    }

    public void setIdPhieuThuChi(int idPhieuThuChi) {
        this.idPhieuThuChi = idPhieuThuChi;
    }

    public String getLoaiPhieu() {
        return loaiPhieu;
    }

    public void setLoaiPhieu(String loaiPhieu) {
        this.loaiPhieu = loaiPhieu;
    }

    public String getSoPhieu() {
        return soPhieu;
    }

    public void setSoPhieu(String soPhieu) {
        this.soPhieu = soPhieu;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getTenDoiTuong() {
        return tenDoiTuong;
    }

    public void setTenDoiTuong(String tenDoiTuong) {
        this.tenDoiTuong = tenDoiTuong;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getDienGiai() {
        return dienGiai;
    }

    public void setDienGiai(String dienGiai) {
        this.dienGiai = dienGiai;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public String getChuyenKhoan() {
        return chuyenKhoan;
    }

    public void setChuyenKhoan(String chuyenKhoan) {
        this.chuyenKhoan = chuyenKhoan;
    }
    
}
