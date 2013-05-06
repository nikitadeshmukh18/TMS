package com.sample.dao;

import com.sample.model.Conductor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ConductorDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveConductor(Conductor conductor){
        Session session = sessionFactory.getCurrentSession();
        System.out.print("-------------" + conductor.getName());
        session.save(conductor);
    }

}
