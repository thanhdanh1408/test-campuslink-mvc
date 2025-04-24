package com.danhheo.model;

public class School {
    private int maTruong;
    private String tenTruong;
    private String diaChi;
    private Integer soDT;

    // Constructor
    public School() {}

    public School(int maTruong, String tenTruong, String diaChi, Integer soDT) {
        this.maTruong = maTruong;
        this.tenTruong = tenTruong;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }

    // Getters and Setters
    public int getMaTruong() {
        return maTruong;
    }

    public void setMaTruong(int maTruong) {
        this.maTruong = maTruong;
    }

    public String getTenTruong() {
        return tenTruong;
    }

    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Integer getSoDT() {
        return soDT;
    }

    public void setSoDT(Integer soDT) {
        this.soDT = soDT;
    }
}