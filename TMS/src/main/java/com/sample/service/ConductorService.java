package com.sample.service;


import com.sample.dao.ConductorDao;
import com.sample.model.Conductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Service
@Transactional

public class ConductorService {

    private ConductorDao cdao;

    public ConductorService() {
    }

    @Autowired
    public ConductorService(ConductorDao cdao) {
        this.cdao = cdao;
    }

    public void saveConductor(Conductor conductor){

        cdao.saveConductor(conductor);
    }

    public List<Conductor> getAllconductors() {
        return cdao.getAll();
    }

    public void remove(Conductor c) {
        cdao.remove(c);
    }


    public Conductor getConductor(int id) {
         return cdao.getConductor(id);
    }

    public void update(Conductor conductor) {
        cdao.update(conductor);
    }

    public void delayhandling(int bus_no,int bus_stop) throws ParseException {
        cdao.delayhandling(bus_no,bus_stop);
    }

    public void deleteRunningBus(int bus_no)
    {
        cdao.deleteRunningBus(bus_no);
    }
}

