package com.sample.dao;


import com.sample.model.Login;
import com.sample.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginDao {

    @Autowired
    private SessionFactory sessionFactory;

    public int getId(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Login where username=?").setParameter(0, username);
        Login loginModel = (Login) query.list().get(0);
        return loginModel.getId();

    }

    public boolean isValidUser(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
        Login loginModel = null;
        try {
            Query query = session.createQuery("from Login where username=?").setParameter(0, username);
            loginModel = (Login) query.list().get(0);
        } catch (IndexOutOfBoundsException exception) {
            return false;
        }
        if (password.equals(loginModel.getPassword())) return true;

        return false;


    }

}
