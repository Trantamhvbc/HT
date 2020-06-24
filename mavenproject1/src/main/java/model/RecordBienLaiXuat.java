/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duong
 */
package  model;

public class RecordBienLaiXuat {
    private BienLaiXuat bienLaiXuat;
    private SanPham sanPham;

    public RecordBienLaiXuat() {
    }

    public BienLaiXuat getBienLaiXuat() {
        return bienLaiXuat;
    }

    public void setBienLaiXuat(BienLaiXuat bienLaiXuat) {
        this.bienLaiXuat = bienLaiXuat;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
    
}
