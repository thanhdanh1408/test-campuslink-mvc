package com.danhheo.service;

import com.danhheo.dao.NganhDAO;
import com.danhheo.model.Nganh;
import java.util.List;

public class NganhService {
    private NganhDAO nganhDao;

    public NganhService(NganhDAO nganhDao) {
        this.nganhDao = nganhDao;
    }

    public List<Nganh> getAll() throws Exception {
        return nganhDao.getAll();
    }
}