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
public class SearchDao {

    private List<BusStop> searchList;
    @Autowired
    private SessionFactory sessionFactory;


    public List<BusStop> getSearchList(String src,String destination) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select bus_no from searchtable where bus_src='"+src +"' and bus_destination='"+destination+"'");
        List<BusStop> busids = query.list();
        return busids;
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
