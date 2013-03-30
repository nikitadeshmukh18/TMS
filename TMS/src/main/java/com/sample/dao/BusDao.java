package com.sample.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class BusDao {

    @Autowired
    private SessionFactory sessionFactory;


    public void saveBus(String busSource, String busDestination) {
        Session session = sessionFactory.getCurrentSession();
        List busDetails = new ArrayList();
        busDetails.add(busSource);
        busDetails.add(busDestination);
        busDetails.add(1);
//        Query query = session.createQuery("insert into Bus (Bus_Source,Bus_Destination,Rout_Id) values('?','?',?)").setParameterList("busDetails",busDetails);

    }
}
