package com.sample.service;

import com.sample.dao.BusStopDao;
import com.sample.model.BusStop;
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
        busStopDao.saveStop(stop);
    }

    public String getStopWith(Integer stopId) {
        return busStopDao.getStopWith(stopId);
    }

    public List<BusStop> getRouteStops(int Route_no) {
        return busStopDao.getRouteStops(Route_no);
    }

    public void update(BusStop stop) {
        busStopDao.update(stop);
    }
}
