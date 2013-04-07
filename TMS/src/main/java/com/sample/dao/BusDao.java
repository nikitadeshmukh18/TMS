package com.sample.dao;

import com.sample.model.Bus;
import com.sample.model.BusRoute;
import com.sample.model.BusStop;
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


    public void saveBus(Bus bus) {
        Session session = sessionFactory.getCurrentSession();
        session.save(bus);


    }


    public List<Bus> searchDirectBus(String busSrc, String busDestination) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Bus where busSource='"+busSrc+"' and busDestination='"+busDestination+"'";
        System.out.println("hql="+hql);
        Query query = session.createQuery(hql);
        List<Bus> buses = query.list();
        return buses;
    }

    public List<Bus> getAllBuses() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Bus");
        List<Bus> bus = query.list();
        return bus;
    }

    public int getRouteNo(int busno)
    {
        System.out.print(busno);
        Session session=sessionFactory.getCurrentSession();
        System.out.print(busno);
        String hql="from Bus where Bus_No=" + busno;
        Query query=session.createQuery(hql);
        System.out.print("Query Created ");
        List<Bus> counts = (List<Bus>) query.list();
        System.out.print(counts.get(0).getRouteId());
        return counts.get(0).getRouteId();
    }



}
