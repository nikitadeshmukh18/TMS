package com.sample.dao;


import com.sample.model.Login;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

    @Autowired
    private SessionFactory sessionFactory;

    public int getId(String username) {
         Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Login where username=?").setParameter(0,username);
        Login loginModel = (Login)query.list().get(0);
        return loginModel.getId();

    }

    public boolean isValidUser(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Login where username=?").setParameter(0,username);
        Login loginModel = (Login)query.list().get(0);

        if (password.equals(loginModel.getPassword())) return true;

        return false;


    }
}
