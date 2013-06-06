package com.sample.dao;

import com.sample.model.Bus;
import com.sample.model.BusRoute;
import com.sample.model.RouteStops;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.*;
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


    public void deleteRouteStop(int route,int stopIndex)
    {
      String sql="DELETE FROM Route WHERE (route_id,stop_index) in (("+route +","+ stopIndex + "))";


        Session session=sessionFactory.getCurrentSession();
         Query query=session.createSQLQuery(sql);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);




        String sql1="UPDATE ROUTE SET STOP_INDEX=STOP_INDEX-1 WHERE STOP_INDEX >"  + stopIndex + " and route_id="+route;
        Query query1=session.createSQLQuery(sql1);
        query1.executeUpdate();

        JOptionPane.showMessageDialog(null, "Stop Deleted " );

    }

    public int getRouteStopIndexCount(int route)
    {

        Session session=sessionFactory.getCurrentSession();
        String sql="select max(stop_index) from Route where route_id="+ route ;
        Query query=session.createSQLQuery(sql);
       List<Integer> counts = (List<Integer>) query.list();
        Iterator it = counts.iterator();
        Integer integer=(Integer)it.next();

        return integer;


    }

    public void insertStopInRoute(int route,int stopindex,int bus_stop,String stop_time)
    {


       Session session=sessionFactory.getCurrentSession();


        int maxstopid=getRouteStopIndexCount(route);

        for(int i=maxstopid;i>=stopindex;i--)
        {


            String sql1="UPDATE ROUTE SET STOP_INDEX="+(i+1) + " WHERE STOP_INDEX="  + i + " and route_id="+route;
            Query query1=session.createSQLQuery(sql1);
            query1.executeUpdate();


        }
        BusRoute busRoute1=new BusRoute();
        busRoute1.setRouteId(route);
        busRoute1.setStopIndex(stopindex);
        busRoute1.setStopId(bus_stop);
        busRoute1.setTimeTaken(stop_time);
        session.save(busRoute1);



    }


    public int getStopIndex(int id, Integer rId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select Stop_Index from Route where Stop_Id="+id+ " and Route_Id="+rId;
        Query query = session.createSQLQuery(hql);
        if (query.list().size() > 0 ){
            int i = (Integer) query.list().get(0);
            return i;
        }
        else
            return  -1;
    }

    public List getStopsAfter(int sourceId, int rId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select Stop_Id from Route where Stop_Index >"+sourceId+" and Route_Id="+rId;;
        Query query = session.createSQLQuery(hql);
        List<Integer> stopIds =  query.list();
        return stopIds;
    }
}

