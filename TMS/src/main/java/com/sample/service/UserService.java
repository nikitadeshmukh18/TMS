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

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUser(String username) {
        return userDao.getUser(username);
    }

}
