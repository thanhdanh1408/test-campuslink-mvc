package com.danhheo.dao;

import com.danhheo.model.Nganh;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class NganhDAO {
    private DataSource dataSource;

    public NganhDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Nganh> getAll() throws Exception {
        List<Nganh> nganhs = new ArrayList<>();
        String sql = "SELECT * FROM nganh";
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Nganh nganh = new Nganh();
                nganh.setMaNganh(rs.getString("ma_nganh"));
                nganh.setTenNganh(rs.getString("ten_nganh"));
                nganhs.add(nganh);
            }
        }
        return nganhs;
    }
}