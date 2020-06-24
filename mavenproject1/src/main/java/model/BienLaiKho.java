/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Duong
 */
public class BienLaiKho {
    private int id;
    private String maBienLai;
    private String ngayLap;
    private int soLuong;
    private Kho kho;
    private int tongCong;

    public int getTongCong() {
        return tongCong;
    }

    public void setTongCong(int tongCong) {
        this.tongCong = tongCong;
    }
    
    public BienLaiKho() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaBienLai() {
        return maBienLai;
    }

    public void setMaBienLai(String maBienLai) {
        this.maBienLai = maBienLai;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

   

    public Kho getKho() {
        return kho;
    }

    public void setKho(Kho kho) {
        this.kho = kho;
    }

    
  
}
