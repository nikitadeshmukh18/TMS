package com.sample.model;


import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {

    @Id @GeneratedValue
    @Column(name = "User_Id" )
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Contact")
    private String contact;

    @Column(name = "User_Type")
    private String user_type;

    public User() {}

    public Long getId() {
        return id;
    }

    private void setId ( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String username ) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

}