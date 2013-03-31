package com.sample.dao;

import com.sample.model.BusStop;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public class BusStopDao {

    private List<BusStop> busStops;
    @Autowired
    private SessionFactory sessionFactory;


    public List<BusStop> getAllStops() {

      Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from BusStop");
        List<BusStop> busStops = query.list();
        return busStops;
    }

    public String getStopWith(Integer stopId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select Stop_Name from BusStop where Stop_Id="+stopId;
        Query query = session.createSQLQuery(hql);
        String name = (String) query.list().get(0);
        return name;
    }

    public void saveBus(BusStop stop) {
        Session session = sessionFactory.getCurrentSession();
        session.save(stop);
    }
}
