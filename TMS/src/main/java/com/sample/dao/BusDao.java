package com.sample.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BusDao {

    @Autowired
    private SessionFactory sessionFactory;


    public void saveBus(String busSource, String busDestination) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("insert into Bus (Bus_Source,Bus_Destination,Rout_Id) values('?','?',?").setParameter(0,busSource).setParameter(1,busDestination).setParameter(2,1);

    }
}
