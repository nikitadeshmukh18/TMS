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

}
