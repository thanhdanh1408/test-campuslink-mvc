package com.danhheo.service;

import com.danhheo.dao.GraduationDAO;
import com.danhheo.model.Graduation;

import javax.sql.DataSource;
import java.util.List;

public class GraduationService {
    private GraduationDAO graduationDAO;

    public GraduationService(DataSource dataSource) {
        this.graduationDAO = new GraduationDAO(dataSource);
    }

    public void saveGraduation(Graduation graduation) {
        graduationDAO.saveGraduation(graduation);
    }

    public List<Graduation> getGraduationsByStudent(int soCMND) {
        return graduationDAO.getGraduationsByStudent(soCMND);
    }
}