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
public class HopDong {
    private int id;
    private String ngayKi;
    private  String tenHopDong;
    private String tuNgay;
    private String denNGay;
    private NhanVien nv;
    private NhaCungCap ncc;

    public NhaCungCap getNcc() {
        return ncc;
    }

    public void setNcc(NhaCungCap ncc) {
        this.ncc = ncc;
    }

    public String getTenHopDong() {
        return tenHopDong;
    }

    public void setTenHopDong(String tenHopDong) {
        this.tenHopDong = tenHopDong;
    }

    public HopDong() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgayKi() {
        return ngayKi;
    }

    public void setNgayKi(String ngayKi) {
        this.ngayKi = ngayKi;
    }

    public String getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(String tuNgay) {
        this.tuNgay = tuNgay;
    }

    public String getDenNGay() {
        return denNGay;
    }

    public void setDenNGay(String denNGay) {
        this.denNGay = denNGay;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }
    
}
