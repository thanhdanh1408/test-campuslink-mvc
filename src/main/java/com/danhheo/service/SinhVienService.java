package com.danhheo.service;

import com.danhheo.dao.SinhVienDAO;
import com.danhheo.model.SinhVien;
import java.sql.SQLException;
import java.util.List;

public class SinhVienService {
    private SinhVienDAO sinhVienDao;

    public SinhVienService(SinhVienDAO sinhVienDao) {
        this.sinhVienDao = sinhVienDao;
    }

    public void save(SinhVien sinhVien) throws SQLException {
        sinhVienDao.save(sinhVien);
    }

    public List<SinhVien> search(String keyword) throws SQLException {
        return sinhVienDao.search(keyword);
    }
}