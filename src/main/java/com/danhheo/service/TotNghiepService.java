package com.danhheo.service;

import com.danhheo.dao.TotNghiepDAO;
import com.danhheo.model.TotNghiep;
import java.sql.SQLException;
import java.util.List;

public class TotNghiepService {
    private TotNghiepDAO totNghiepDao;

    public TotNghiepService(TotNghiepDAO totNghiepDao) {
        this.totNghiepDao = totNghiepDao;
    }

    public void save(TotNghiep totNghiep) throws SQLException {
        totNghiepDao.save(totNghiep);
    }

    public List<Object[]> searchEmployment(String keyword) throws SQLException {
        return totNghiepDao.searchEmployment(keyword);
    }
}