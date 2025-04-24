package com.danhheo.service;

import com.danhheo.dao.JobDAO;
import com.danhheo.model.Job;

import javax.sql.DataSource;
import java.util.List;

public class JobService {
    private JobDAO jobDAO;

    public JobService(DataSource dataSource) {
        this.jobDAO = new JobDAO(dataSource);
    }

    public List<Job> getJobsByStudent(int soCMND) {
        return jobDAO.getJobsByStudent(soCMND);
    }
}