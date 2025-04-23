package com.danhheo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.danhheo.model.Truong;

public class TruongDAO {
    private DataSource dataSource;

    public TruongDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Truong> getAll() throws Exception {
        List<Truong> truongs = new ArrayList<>();
        String sql = "SELECT * FROM truong";
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Truong truong = new Truong();
                truong.setMaTruong(rs.getString("ma_truong"));
                truong.setTenTruong(rs.getString("ten_truong"));
                truong.setDiaChi(rs.getString("dia_chi"));
                truongs.add(truong);
            }
        }
        return truongs;
    }
}
