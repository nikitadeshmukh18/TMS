package com.sample.service;

import com.sample.dao.BusStopDao;
import com.sample.model.BusStop;
import com.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BusStopService {

    private BusStopDao busStopDao;

    public BusStopService() {


    }

    @Autowired

    public BusStopService(BusStopDao busStopDao) {
        this.busStopDao = busStopDao;
    }

    public List<BusStop> getAllStops() {
        return busStopDao.getAllStops();
    }

    public void saveStop(BusStop stop){
        busStopDao.saveBus(stop);
    }

    public String getStopWith(Integer stopId) {
        return busStopDao.getStopWith(stopId);
    }
}
