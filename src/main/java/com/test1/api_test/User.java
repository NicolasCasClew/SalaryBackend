package com.test1.api_test;

import jakarta.persistence.*;

@Entity
@Table(name= "salary_data")
public class User {
    @Id
    @Column(
            name="id",
            nullable=false
    )
    private  String id;
    @Column(
            name="name",
            nullable=false
    )
    private String name;
    @Column(
            name="mail",
            nullable=false
    )
    private String mail;

    public User(String id, String name, String mail) {
        this.id = id;
        this.name = name;
        this.mail = mail;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
