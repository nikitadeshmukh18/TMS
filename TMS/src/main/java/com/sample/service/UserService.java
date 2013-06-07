package com.sample.service;


import java.util.List;

import com.sample.dao.UserDao;
import com.sample.model.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserService {

    private UserDao userDao;

    public UserService() {
    }
    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUser(String username) {
        return userDao.getUser(username);
    }

    public void save(User user) {
        userDao.save(user);
    }

    public User getUserId(String name) {
        return userDao.getUserId(name);

    }

    public List<User> getConductors() {
        return userDao.getConductors();
    }

    public void remove(User user) {
        userDao.remove(user);
    }

    public User getUser(long id) {
        return userDao.getUser(id);
    }

    public void update(User user) {
        userDao.upadate(user);
    }

    public int getUserType(int id) {
        return userDao.getUserType(id);
    }
}
