package com.sample.dao;

import com.sample.model.Bus;
import com.sample.model.BusRoute;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RouteDao {

    private Bus bus;
    private BusRoute busRoute;

    @Autowired
    private SessionFactory sessionFactory;

    public List<BusRoute> getBusRoute(Bus busNo){

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Bus where busNo=?").setParameter(0,busNo);
        bus = (Bus) query.list().get(0);
        int routeId = bus.getRouteId();
        query = session.createQuery("from BusRoute where routeId=?").setParameter(0,routeId);
        List<BusRoute> route = (List<BusRoute>) query.list();

        return route;
    }



}

