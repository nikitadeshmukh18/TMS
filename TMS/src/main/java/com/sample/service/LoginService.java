package com.sample.service;

import com.sample.dao.LoginDao;
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

    public int getId(String username){
        return loginDao.getId(username);

    }

    public boolean isValidUser(String username , String password){
        return loginDao.isValidUser(username,password );
    }

}
