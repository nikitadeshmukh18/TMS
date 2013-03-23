package com.sample.dao;

import com.sample.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    private List<User> allUsers;
    private User user;

    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User");
        List<User> allUsers = query.list();
        return allUsers;
    }

    public User getUser(String username) {
        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("from User where User_Id in (Select User_Id from Login where username=?)").setParameter(0,username);
        Query query = session.createQuery("from User");
        User user1 = (User) query.list().get(0);
        return user1;
    }
}
