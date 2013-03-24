package com.sample.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BusDao {

    @Autowired
    private SessionFactory sessionFactory;


}
