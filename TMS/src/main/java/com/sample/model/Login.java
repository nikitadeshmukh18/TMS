package com.sample.model;

import javax.persistence.*;

@Entity
@Table(name = "Login")
public class Login {

    @Id @GeneratedValue

    @Column(name = "User_Id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
