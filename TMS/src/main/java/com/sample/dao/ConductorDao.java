package com.sample.dao;

import com.sample.model.Conductor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class ConductorDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveConductor(Conductor conductor){
        Session session = sessionFactory.getCurrentSession();
        System.out.print("-------------" + conductor.getName());
        session.save(conductor);
    }

    public List<Conductor> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Conductor");
        List<Conductor> conductors = query.list();
        return conductors;
    }

    public void remove(Conductor c) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(c);
    }

    public Conductor getConductor(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Conductor where id=?").setParameter(0,id);
        Conductor conductor = (Conductor) query.list().get(0);
        return  conductor;

    }

    public void update(Conductor conductor) {
        Session session = sessionFactory.getCurrentSession();
        session.update(conductor);
    }

    public void delayhandling(int bus_no,int bus_stop) throws ParseException {
        String sql="SELECT start_time,time_taken FROM searchtable  where bus_no=" + bus_no + " and stop_id="+bus_stop;
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createSQLQuery(sql);
        List<Object> rows = query.list();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        String d1 = null,d2 = null;


        for(Object r: rows){
            Object[] row = (Object[]) r;
            d1= row[0].toString();
            d2= row[1].toString();

        }

        System.out.println("d1:"+d1.toString());
        System.out.println("d2:"+d2.toString());


        StringTokenizer st = new StringTokenizer(d1, ":");
        StringTokenizer st1 = new StringTokenizer(d2, ":");
        int hr1=Integer.parseInt(st.nextToken());
        int min1=Integer.parseInt(st.nextToken());
        int hr2=Integer.parseInt(st1.nextToken());
        int min2=Integer.parseInt(st1.nextToken());

        int minf=0,hrf=0;
        minf=min1+min2;
        if(minf>59)
        {
            hr1=hr1+1;
            minf=minf-60;
        }
        hrf=hr1+hr2;

        System.out.println(hrf+":"+minf);

        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()) );
        StringTokenizer st3 = new StringTokenizer(sdf.format(cal.getTime()), ":");
        int hr3=Integer.parseInt(st3.nextToken());
        int min3=Integer.parseInt(st3.nextToken());

        minf=min3-minf;
        if(minf<0)
        {
            minf=minf+60;
            hrf=hr3-hrf;
            hrf=hrf-1;
        }
        else
            hrf=hr3-hrf;


        System.out.println(hrf+":"+minf);
        String str = null;

        if(hrf<10)
            str="0"+hrf;
        else
            str=str+hrf;
        if(minf<10)
            str=str+"0"+minf;
        else
             str=str+minf;

        str=str+"00";
        int temp=Integer.parseInt(str);
        System.out.println(str);
        System.out.println(temp);
        sql="select count(current_stop) from runningbuses where bus_no="+ bus_no ;
        query=session.createSQLQuery(sql);
        List<Integer> counts = (List<Integer>) query.list();
        Iterator it = counts.iterator();
        BigInteger bigInteger=(BigInteger) it.next();
        Integer integer=(Integer.parseInt( bigInteger.toString()));
        System.out.println("Count:"+integer);
        if(integer>0)//update
        {

            String sql1="delete from runningbuses where bus_no="+bus_no;
            Query query1=session.createSQLQuery(sql1);
            query1.executeUpdate();
        }


            String sql1="insert into runningbuses values("+bus_no+","+ bus_stop +","+temp+")";
            Query query1=session.createSQLQuery(sql1);
            query1.executeUpdate();



    }

    public void deleteRunningBus(int bus_no)
    {

        Session session=sessionFactory.getCurrentSession();
        String sql1="delete from runningbuses where bus_no="+bus_no;
        Query query1=session.createSQLQuery(sql1);
        query1.executeUpdate();
    }
}
