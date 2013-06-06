package com.sample.dao;

import com.sample.model.BusStop;
import com.sample.model.BusRoute;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.math.BigInteger;
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

    public void saveStop(BusStop stop) {
        Session session = sessionFactory.getCurrentSession();
        String sql="SELECT count(stop_id) FROM busstop b where Stop_name like '%" + stop.getStopName() +"%'";
        Query query=session.createSQLQuery(sql);
        List<Integer> counts = (List<Integer>) query.list();
        Iterator it = counts.iterator();
        BigInteger total = (BigInteger) it.next();
          int integer=Integer.parseInt(total.toString());
        if(integer>0)
            JOptionPane.showMessageDialog(null,"Stop Already Exist In Table");
        else
        {
        session.save(stop);
            JOptionPane.showMessageDialog(null,"Stop Created..!!");
        }
    }

    public List<BusStop> getRouteStops(int route_no) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from BusStop where stopId not in (select stopId from BusRoute where routeId="+ route_no +")");
        List<BusStop> busStops = query.list();
        return busStops;
    }

    public void update(BusStop stop) {
        Session session = sessionFactory.getCurrentSession();
        session.update(stop);
    }

    public void delete(BusStop stop) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(stop);

    }

    public int getId(String source) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select Stop_Id from BusStop where Stop_Name='"+source+"'";
        Query query = session.createSQLQuery(hql);
        int id = (Integer) query.list().get(0);
        return id;
    }
}
