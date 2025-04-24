package com.danhheo.model;

import java.util.Date;

public class Job {
    private int soCMND;
    private Date ngayVaoCongTy;
    private int maNganh;
    private String tenCongTy;
    private int thoiGianLamViec;

    // Constructor
    public Job() {}

    public Job(int soCMND, Date ngayVaoCongTy, int maNganh, String tenCongTy, int thoiGianLamViec) {
        this.soCMND = soCMND;
        this.ngayVaoCongTy = ngayVaoCongTy;
        this.maNganh = maNganh;
        this.tenCongTy = tenCongTy;
        this.thoiGianLamViec = thoiGianLamViec;
    }

    // Getters and Setters
    public int getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(int soCMND) {
        this.soCMND = soCMND;
    }

    public Date getNgayVaoCongTy() {
        return ngayVaoCongTy;
    }

    public void setNgayVaoCongTy(Date ngayVaoCongTy) {
        this.ngayVaoCongTy = ngayVaoCongTy;
    }

    public int getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(int maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public int getThoiGianLamViec() {
        return thoiGianLamViec;
    }

    public void setThoiGianLamViec(int thoiGianLamViec) {
        this.thoiGianLamViec = thoiGianLamViec;
    }
}