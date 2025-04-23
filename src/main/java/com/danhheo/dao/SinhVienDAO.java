package com.danhheo.dao;

import com.danhheo.model.SinhVien;
import com.danhheo.model.TotNghiep;
import com.danhheo.model.Truong;
import com.danhheo.model.Nganh;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SinhVienDAO {
    private DataSource dataSource;

    public SinhVienDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(SinhVien sinhVien) throws SQLException {
        String sql = "INSERT INTO sinh_vien (so_cmnd, ho_ten, email, so_dt, dia_chi) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sinhVien.getSoCmnd());
            ps.setString(2, sinhVien.getHoTen());
            ps.setString(3, sinhVien.getEmail());
            ps.setString(4, sinhVien.getSoDt());
            ps.setString(5, sinhVien.getDiaChi());
            ps.executeUpdate();
        }
    }

    public List<SinhVien> search(String keyword) throws SQLException {
        List<SinhVien> result = new ArrayList<>();
        String sql = "SELECT * FROM sinh_vien WHERE so_cmnd LIKE ? OR ho_ten LIKE ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setSoCmnd(rs.getString("so_cmnd"));
                sv.setHoTen(rs.getString("ho_ten"));
                sv.setEmail(rs.getString("email"));
                sv.setSoDt(rs.getString("so_dt"));
                sv.setDiaChi(rs.getString("dia_chi"));
                result.add(sv);
            }
        }
        return result;
    }
}