package com.danhheo.service;

import com.danhheo.dao.SchoolDAO;
import com.danhheo.model.School;

import javax.sql.DataSource;
import java.util.List;

public class SchoolService {
    private SchoolDAO schoolDAO;

    public SchoolService(DataSource dataSource) {
        this.schoolDAO = new SchoolDAO(dataSource);
    }

    public List<School> getAllSchools() {
        return schoolDAO.getAllSchools();
    }
}