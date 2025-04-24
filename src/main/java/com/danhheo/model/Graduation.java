package com.danhheo.model;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class Graduation {
    @NotNull(message = "Số CMND không được để trống")
    private Integer soCMND;
    
    @NotNull(message = "Mã trường không được để trống")
    private Integer maTruong;
    
    @NotNull(message = "Mã ngành không được để trống")
    private Integer maNganh;
    
    private String heTN;
    private Date ngayTN;
    private String loaiTN;

    // Constructor
    public Graduation() {}

    public Graduation(Integer soCMND, Integer maTruong, Integer maNganh, String heTN, Date ngayTN, String loaiTN) {
        this.soCMND = soCMND;
        this.maTruong = maTruong;
        this.maNganh = maNganh;
        this.heTN = heTN;
        this.ngayTN = ngayTN;
        this.loaiTN = loaiTN;
    }

    // Getters and Setters
    public Integer getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(Integer soCMND) {
        this.soCMND = soCMND;
    }

    public Integer getMaTruong() {
        return maTruong;
    }

    public void setMaTruong(Integer maTruong) {
        this.maTruong = maTruong;
    }

    public Integer getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(Integer maNganh) {
        this.maNganh = maNganh;
    }

    public String getHeTN() {
        return heTN;
    }

    public void setHeTN(String heTN) {
        this.heTN = heTN;
    }

    public Date getNgayTN() {
        return ngayTN;
    }

    public void setNgayTN(Date ngayTN) {
        this.ngayTN = ngayTN;
    }

    public String getLoaiTN() {
        return loaiTN;
    }

    public void setLoaiTN(String loaiTN) {
        this.loaiTN = loaiTN;
    }
}