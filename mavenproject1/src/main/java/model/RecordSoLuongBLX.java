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
public class RecordSoLuongBLX {
    private int soLuong;
    private int idBienLaiKho;

    public RecordSoLuongBLX() {
    }

    public RecordSoLuongBLX(int soLuong, int idBienLaiKho) {
        this.soLuong = soLuong;
        this.idBienLaiKho = idBienLaiKho;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getIdBienLaiKho() {
        return idBienLaiKho;
    }

    public void setIdBienLaiKho(int idBienLaiKho) {
        this.idBienLaiKho = idBienLaiKho;
    }
          
}
