package com.danhheo.model;

import java.util.Date;

public class TotNghiep {
	private int id;
	private String soCmnd;
	private String maTruong;
	private String maNganh;
	private Date ngayTn;

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSoCmnd() {
		return soCmnd;
	}

	public void setSoCmnd(String soCmnd) {
		this.soCmnd = soCmnd;
	}

	public String getMaTruong() {
		return maTruong;
	}

	public void setMaTruong(String maTruong) {
		this.maTruong = maTruong;
	}

	public String getMaNganh() {
		return maNganh;
	}

	public void setMaNganh(String maNganh) {
		this.maNganh = maNganh;
	}

	public Date getNgayTn() {
		return ngayTn;
	}

	public void setNgayTn(Date ngayTn) {
		this.ngayTn = ngayTn;
	}
}