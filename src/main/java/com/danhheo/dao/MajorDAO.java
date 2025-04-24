package com.danhheo.dao;

import com.danhheo.model.Major;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MajorDAO {
    private JdbcTemplate jdbcTemplate;

    public MajorDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Major> getAllMajors() {
        String sql = "SELECT * FROM NGANH";
        return jdbcTemplate.query(sql, new MajorRowMapper());
    }

    private static class MajorRowMapper implements RowMapper<Major> {
        @Override
        public Major mapRow(ResultSet rs, int rowNum) throws SQLException {
            Major major = new Major();
            major.setMaNganh(rs.getInt("MaNganh"));
            major.setTenNganh(rs.getString("TenNganh"));
            major.setLoaiNganh(rs.getString("LoaiNganh"));
            return major;
        }
    }
}