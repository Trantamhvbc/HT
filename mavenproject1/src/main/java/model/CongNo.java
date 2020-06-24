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
public class CongNo {
    private int idCongNo;
    private String maSoThue;
    private int soTienNo;
    private NhaCungCap cap;
    private PhieuThuChi phieuThuChi;

    public CongNo() {
    }

    public int getIdCongNo() {
        return idCongNo;
    }

    public void setIdCongNo(int idCongNo) {
        this.idCongNo = idCongNo;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public int getSoTienNo() {
        return soTienNo;
    }

    public void setSoTienNo(int soTienNo) {
        this.soTienNo = soTienNo;
    }

    public NhaCungCap getCap() {
        return cap;
    }

    public void setCap(NhaCungCap cap) {
        this.cap = cap;
    }

    public PhieuThuChi getPhieuThuChi() {
        return phieuThuChi;
    }

    public void setPhieuThuChi(PhieuThuChi phieuThuChi) {
        this.phieuThuChi = phieuThuChi;
    }
    
}
