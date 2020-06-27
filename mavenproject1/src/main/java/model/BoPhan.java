/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author Duong
 */
public class BoPhan {
     private int id;
     private String ten;
     private CongTy congTy;

    public BoPhan() {
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

    public CongTy getCongTy() {
        return congTy;
    }

    public void setCongTy(CongTy congTy) {
        this.congTy = congTy;
    }
    
    @Override
    public String toString() {
        return getTen();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoPhan)) return false;
        BoPhan boPhan = (BoPhan) o;
        return getId() == boPhan.getId() &&
                Objects.equals(getTen(), boPhan.getTen()) &&
                Objects.equals(getCongTy(), boPhan.getCongTy());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTen(), getCongTy());
    }  
     
}
