package com.danhheo.dao;

import com.danhheo.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAO {
    private JdbcTemplate jdbcTemplate;

    public StudentDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveStudent(Student student) {
        String sql = "INSERT INTO SINHVIEN (SoCMND, HoTen, Email, SoDT, DiaChi) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, student.getSoCMND(), student.getHoTen(), student.getEmail(),
                student.getSoDT(), student.getDiaChi());
    }

    public List<Student> searchStudents(String keyword) {
        String sql = "SELECT * FROM SINHVIEN WHERE HoTen LIKE ? OR SoCMND = ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + keyword + "%", keyword}, new StudentRowMapper());
    }

    private static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setSoCMND(rs.getInt("SoCMND"));
            student.setHoTen(rs.getString("HoTen"));
            student.setEmail(rs.getString("Email"));
            student.setSoDT(rs.getInt("SoDT"));
            student.setDiaChi(rs.getString("DiaChi"));
            return student;
        }
    }
}