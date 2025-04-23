package com.danhheo.service;

import com.danhheo.dao.TruongDAO;
import com.danhheo.model.Truong;
import java.util.List;

public class TruongService {
    private TruongDAO truongDao;

    public TruongService(TruongDAO truongDao) {
        this.truongDao = truongDao;
    }

    public List<Truong> getAll() throws Exception {
        return truongDao.getAll();
    }
}