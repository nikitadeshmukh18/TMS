package com.sample.service;

import com.sample.dao.LoginDao;
import com.sample.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class LoginService {



    private LoginDao loginDao;

    public LoginService() {
    }

    @Autowired
    public LoginService(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    public long getId(String username){
        return loginDao.getId(username);

    }

    public boolean isValidUser(String username , String password){
        return loginDao.isValidUser(username,password );
    }

    public void saveCredentials(Login loginCredentials) {
        loginDao.saveLoginCredentials(loginCredentials);
    }

    public void remove(Login user) {
        loginDao.remove(user);
    }

    public Login getUser(long id) {
        return loginDao.getUser(id);
    }

    public void updateUserCredentials(Login credentials) {
        loginDao.updateUserCredentials(credentials);
    }
}
