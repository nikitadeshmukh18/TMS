package com.sample.service;

import com.sample.dao.BusDao;
import com.sample.model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


    public void saveBus(Bus bus) {
        busDao.saveBus(bus);
    }

    public List<Bus> searchDirectBus(String busSrc, String busDestination) {
        return busDao.searchDirectBus(busSrc,busDestination);
    }
}
