/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Duong
 */
public class BienLaiNhap extends BienLaiKho{
    private int idBienLaiNhap;
    private HopDong hopDong;
    private PhieuThuChi phieuThuChi;
    private NhanVien nhanVien;

    public BienLaiNhap() {
    }
    public HopDong getHopDong() {
        return hopDong;
    }

    public int getIdBienLaiNhap() {
        return idBienLaiNhap;
    }

    public void setIdBienLaiNhap(int idBienLaiNhap) {
        this.idBienLaiNhap = idBienLaiNhap;
    }

    public void setHopDong(HopDong hopDong) {
        this.hopDong = hopDong;
    }
    public PhieuThuChi getPhieuThuChi() {
        return phieuThuChi;
    }

    public void setPhieuThuChi(PhieuThuChi phieuThuChi) {
        this.phieuThuChi = phieuThuChi;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
    
}
