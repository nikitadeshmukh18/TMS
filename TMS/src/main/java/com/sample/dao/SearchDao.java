package com.sample.dao;

import com.sample.model.BusStop;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SearchDao {

    private List<BusStop> searchList;
    @Autowired
    private SessionFactory sessionFactory;


    public List getSearchList(String stopname) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("select Route_Id from searchtable where Stop_Name= '"+stopname +"' order by Route_Id");
        List<Integer> routeIds =  query.list();
        return routeIds;

    }



}
