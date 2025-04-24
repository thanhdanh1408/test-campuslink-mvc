package com.danhheo.dao;

import com.danhheo.model.Graduation;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GraduationDAO {
    private JdbcTemplate jdbcTemplate;

    public GraduationDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveGraduation(Graduation graduation) {
        String sql = "INSERT INTO TOT_NGHIEP (SoCMND, MaTruong, MaNganh, HeTN, NgayTN, LoaiTN) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, graduation.getSoCMND(), graduation.getMaTruong(), graduation.getMaNganh(),
                graduation.getHeTN(), graduation.getNgayTN(), graduation.getLoaiTN());
    }

    public List<Graduation> getGraduationsByStudent(int soCMND) {
        String sql = "SELECT * FROM TOT_NGHIEP WHERE SoCMND = ?";
        return jdbcTemplate.query(sql, new Object[]{soCMND}, (ResultSet rs, int rowNum) -> {
            Graduation graduation = new Graduation();
            graduation.setSoCMND(rs.getInt("SoCMND"));
            graduation.setMaTruong(rs.getInt("MaTruong"));
            graduation.setMaNganh(rs.getInt("MaNganh"));
            graduation.setHeTN(rs.getString("HeTN"));
            graduation.setNgayTN(rs.getDate("NgayTN"));
            graduation.setLoaiTN(rs.getString("LoaiTN"));
            return graduation;
        });
    }
}