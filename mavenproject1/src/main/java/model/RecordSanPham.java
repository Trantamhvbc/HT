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
public class RecordSanPham {
    private SanPham pham;
    private int SoLuong;
    private int chietKhau;

    public RecordSanPham() {
    }

    public int getChietKhau() {
        return chietKhau;
    }

    public void setChietKhau(int chietKhau) {
        this.chietKhau = chietKhau;
    }
    
    public SanPham getPham() {
        return pham;
    }

    public void setPham(SanPham pham) {
        this.pham = pham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
}