package com.salary_tool.salary_backend;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name= "test_table1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name="id",
            nullable=false
    )
    private UUID id;
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

    public User(String name, String mail) {
        //this.id = id;
        this.name = name;
        this.mail = mail;
    }

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
