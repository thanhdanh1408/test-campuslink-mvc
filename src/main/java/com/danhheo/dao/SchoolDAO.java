package com.danhheo.dao;

import com.danhheo.model.School;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SchoolDAO {
    private JdbcTemplate jdbcTemplate;

    public SchoolDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<School> getAllSchools() {
        String sql = "SELECT * FROM TRUONG";
        return jdbcTemplate.query(sql, new SchoolRowMapper());
    }

    private static class SchoolRowMapper implements RowMapper<School> {
        @Override
        public School mapRow(ResultSet rs, int rowNum) throws SQLException {
            School school = new School();
            school.setMaTruong(rs.getInt("MaTruong"));
            school.setTenTruong(rs.getString("TenTruong"));
            school.setDiaChi(rs.getString("DiaChi"));
            school.setSoDT(rs.getInt("SoDT"));
            return school;
        }
    }
}