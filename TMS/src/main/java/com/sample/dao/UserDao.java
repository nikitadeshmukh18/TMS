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

    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public User getUserId(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where name=?").setParameter(0,name);
        User user1 = (User) query.list().get(0);
        return  user1;
    }

    public List<User> getConductors() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where userType=?").setParameter(0,1);
        List<User> allUsers = query.list();
        return allUsers;
    }

    public void remove(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    public User getUser(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where id=?").setParameter(0,id);
        User user1 = (User) query.list().get(0);
        return  user1;
    }

    public void upadate(User user) {
        Session session = sessionFactory.getCurrentSession();
//        String hql = "Update USER set Name='"+user.getName()+ "' where User_Id="+user.getId();
//        System.out.println(hql);
//        Query query = session.createSQLQuery(hql);
//        query.executeUpdate();

        session.update(user);

    }

    public int getUserType(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("select User_Type from USER where User_Id="+id);
        if(query.list().size() > 0 ){
            int type = (Integer) query.list().get(0);
            return type;
        }
        return -1;
    }
}
