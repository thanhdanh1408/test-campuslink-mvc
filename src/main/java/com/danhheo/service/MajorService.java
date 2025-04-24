package com.danhheo.service;

import com.danhheo.dao.MajorDAO;
import com.danhheo.model.Major;

import javax.sql.DataSource;
import java.util.List;

public class MajorService {
    private MajorDAO majorDAO;

    public MajorService(DataSource dataSource) {
        this.majorDAO = new MajorDAO(dataSource);
    }

    public List<Major> getAllMajors() {
        return majorDAO.getAllMajors();
    }
}