package com.sample.service;

import com.sample.dao.BusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BusService {

    private BusDao busDao;

    public BusService() {

    }

    @Autowired
    public BusService(BusDao busDao) {
        this.busDao = busDao;
    }


}
