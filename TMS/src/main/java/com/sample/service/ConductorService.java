package com.sample.service;


import com.sample.dao.ConductorDao;
import com.sample.model.Conductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
