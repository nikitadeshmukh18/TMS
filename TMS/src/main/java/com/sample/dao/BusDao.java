package com.sample.dao;

import com.sample.model.Bus;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

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

    public int getRouteNoForBus(int busNo)
    {
        Session session=sessionFactory.getCurrentSession();
        String hql="from Bus where Bus_No=" + busNo;
        Query query=session.createQuery(hql);
        List<Bus> counts = (List<Bus>) query.list();
        return counts.get(0).getRouteId();
    }


    public Bus getBus(int bus_no) {
        System.out.println("This is sample Bus");
        Bus bus = new Bus();
        bus.setBusNo(100);
        bus.setRouteId(1);
        bus.setStartTime("00");
        bus.setBusSource("abc");
        bus.setBusDestination("defg");
        return bus;

    }

    public void updateBus(Bus bus) {
        Session session = sessionFactory.getCurrentSession();
        session.update(bus);

    }
}
