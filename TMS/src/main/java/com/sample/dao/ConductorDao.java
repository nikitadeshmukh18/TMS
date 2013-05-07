package com.sample.dao;

import com.sample.model.Conductor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
