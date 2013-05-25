package com.sample.dao;

import com.sample.model.Bus;
import com.sample.model.BusRoute;
import com.sample.model.RouteStops;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
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

    public List getRouteIds() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("select distinct Route_Id from Route");
        List<Integer> routeIds =  query.list();
        return routeIds;
    }

    public List<Integer> getAllStopsForRoute(int routeId) {

        Session session = sessionFactory.getCurrentSession();
        String hql = "select Stop_Id from Route where Route_Id="+routeId+" Order By Stop_Index";
        Query query = session.createSQLQuery(hql);
        List<Integer> haults = (List<Integer>) query.list();
        return haults;

    }

    public int getStopCount(int routeId)
    {
        Session session=sessionFactory.getCurrentSession();
        String sql="select count(Stop_Index) from Route where Route_Id=" + routeId ;
        Query query=session.createSQLQuery(sql);
        List<Integer> counts = (List<Integer>) query.list();
         Iterator it = counts.iterator();
        BigInteger total = (BigInteger) it.next();

        return total.intValue();

    }

    public int getStopForRoute(int routeId, int stop_index)
    {
        System.out.println("-----------Inside GetStop------------");
       try
       {

        Session session=sessionFactory.getCurrentSession();
        String sql="from BusRoute where routeId=" + routeId + " and stopIndex=" + stop_index ;
        Query query=session.createQuery(sql);
        List<BusRoute> counts = (List<BusRoute>) query.list();
        System.out.println(counts.get(0).getStopId());
        return counts.get(0).getStopId();
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }

        return 1;
    }

    public int getNewRouteID()
    {
        Session session=sessionFactory.getCurrentSession();
        String sql="select max(Route_Id)+1 from Route" ;
        Query query=session.createSQLQuery(sql);
        List<Integer> counts = (List<Integer>) query.list();
        Iterator it = counts.iterator();
        BigInteger total = (BigInteger) it.next();
        return total.intValue();

    }

    //List Of Stops To Be Added
    public void saveRoute(BusRoute busRoute) {
        Session session = sessionFactory.getCurrentSession();
        session.save(busRoute);


    }

    public void delete(BusRoute busRoute) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(busRoute);

    }


    public List<Integer> getStopIndicesForRoute(int routeId) {

        String h = "Select Stop_Id from Route where Route_Id="+routeId+" order by Stop_Index";
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createSQLQuery(h);
        List<Integer> i=q.list();

          return i;
    }


}

