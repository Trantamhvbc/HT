/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
public class NhaCungCap {
    private int id;
    private String ten;
    private String email;
    private String sodienthoai;

    public NhaCungCap() {
    }

    public NhaCungCap(int id, String ten, String email, String sodienthoai) {
        this.id = id;
        this.ten = ten;
        this.email = email;
        this.sodienthoai = sodienthoai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    
}
