package com.danhheo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Student {
    @NotNull(message = "Số CMND không được để trống")
    private Integer soCMND;
    
    @NotBlank(message = "Họ tên không được để trống")
    private String hoTen;
    
    private String email;
    private Integer soDT;
    private String diaChi;

    // Constructor
    public Student() {}

    public Student(int soCMND, String hoTen, String email, Integer soDT, String diaChi) {
        this.soCMND = soCMND;
        this.hoTen = hoTen;
        this.email = email;
        this.soDT = soDT;
        this.diaChi = diaChi;
    }

    // Getters and Setters
    public Integer getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(Integer soCMND) {
        this.soCMND = soCMND;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSoDT() {
        return soDT;
    }

    public void setSoDT(Integer soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}