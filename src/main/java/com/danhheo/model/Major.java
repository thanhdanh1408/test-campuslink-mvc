package com.danhheo.model;

public class Major {
    private int maNganh;
    private String tenNganh;
    private String loaiNganh;

    // Constructor
    public Major() {}

    public Major(int maNganh, String tenNganh, String loaiNganh) {
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.loaiNganh = loaiNganh;
    }

    // Getters and Setters
    public int getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(int maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getLoaiNganh() {
        return loaiNganh;
    }

    public void setLoaiNganh(String loaiNganh) {
        this.loaiNganh = loaiNganh;
    }
}