package com.sample.dao;

import com.sample.model.Bus;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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

    public List<Bus> getNonRunningBuses()
    {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createSQLQuery("select * from bus where bus_no not in (select bus_no from running)");
        List<Bus> busList=query.list();
        return busList;
    }


    public Bus getBus(int bus_no) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Bus where busNo=?").setParameter(0,bus_no);
        Bus bus = (Bus) query.list().get(0);
        return bus;

    }

    public void updateBus(Bus bus) {
        Session session = sessionFactory.getCurrentSession();
        session.update(bus);

    }

    public void delete(Bus bus) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(bus);
    }

    public int getRouteBusCount(int route)
    {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createSQLQuery("select count(bus_no) from Bus where route_id="+route);
        List<Integer> counts = (List<Integer>) query.list();
        Iterator it = counts.iterator();
        BigInteger total = (BigInteger) it.next();

        return total.intValue();

    }

    public List<Bus> getBusesByRoute(int route) {

        Session session = sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Bus where routeId="+route);
        //Query query = session.createSQLQuery("select Bus_No,Bus_Source,Bus_Destination from Bus where Route_Id="+route);
        List<Bus> bus = query.list();
        return bus;
    }

}
