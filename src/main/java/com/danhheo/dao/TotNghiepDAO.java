package com.danhheo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.danhheo.model.TotNghiep;

public class TotNghiepDAO {
    private DataSource dataSource;

    public TotNghiepDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(TotNghiep totNghiep) throws SQLException {
        String sql = "INSERT INTO tot_nghiep (so_cmnd, ma_truong, ma_nganh, ngay_tn) VALUES (?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, totNghiep.getSoCmnd());
            ps.setString(2, totNghiep.getMaTruong());
            ps.setString(3, totNghiep.getMaNganh());
            ps.setDate(4, new java.sql.Date(totNghiep.getNgayTn().getTime()));
            ps.executeUpdate();
        }
    }

    public List<Object[]> searchEmployment(String keyword) throws SQLException {
        List<Object[]> result = new ArrayList<>();
        String sql = "SELECT sv.so_cmnd, sv.ho_ten, tn.ma_nganh, tn.ma_truong, vl.ma_nganh AS ma_nganh_vl, " +
                     "ct.ten_cong_ty, vl.thoi_gian_lam_viec " +
                     "FROM sinh_vien sv " +
                     "LEFT JOIN tot_nghiep tn ON sv.so_cmnd = tn.so_cmnd " +
                     "LEFT JOIN viec_lam vl ON sv.so_cmnd = vl.so_cmnd " +
                     "LEFT JOIN cong_ty ct ON vl.ma_cong_ty = ct.ma_cong_ty " +
                     "WHERE sv.so_cmnd LIKE ? OR sv.ho_ten LIKE ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object[] row = new Object[7];
                row[0] = rs.getString("so_cmnd");
                row[1] = rs.getString("ho_ten");
                row[2] = rs.getString("ma_nganh");
                row[3] = rs.getString("ma_truong");
                row[4] = rs.getString("ma_nganh_vl");
                row[5] = rs.getString("ten_cong_ty");
                row[6] = rs.getString("thoi_gian_lam_viec");
                result.add(row);
            }
        }
        return result;
    }
}
