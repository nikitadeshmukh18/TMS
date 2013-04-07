package com.sample.service;

import com.sample.dao.BusDao;
import com.sample.model.Bus;
import com.sample.model.BusStop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
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

    public List<Bus> getAllBuses() {
        return busDao.getAllBuses();
    }

    public int getRouteNo(int busno)
    {
        int cnt=busDao.getRouteNo(busno);
        return cnt;
    }


}
