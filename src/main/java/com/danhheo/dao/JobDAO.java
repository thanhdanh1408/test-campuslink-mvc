package com.danhheo.dao;

import com.danhheo.model.Job;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JobDAO {
    private JdbcTemplate jdbcTemplate;

    public JobDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Job> getJobsByStudent(int soCMND) {
        String sql = "SELECT * FROM CONG_VIEC WHERE SoCMND = ?";
        return jdbcTemplate.query(sql, new Object[]{soCMND}, (ResultSet rs, int rowNum) -> {
            Job job = new Job();
            job.setSoCMND(rs.getInt("SoCMND"));
            job.setNgayVaoCongTy(rs.getDate("NgayVaoCongTy"));
            job.setMaNganh(rs.getInt("MaNganh"));
            job.setTenCongTy(rs.getString("TenCongTy"));
            job.setThoiGianLamViec(rs.getInt("ThoiGianLamViec"));
            return job;
        });
    }
}