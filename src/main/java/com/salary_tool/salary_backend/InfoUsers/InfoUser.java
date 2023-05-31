package com.salary_tool.salary_backend.InfoUsers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salary_tool.salary_backend.salaryUsers.SalaryUser;
import jakarta.persistence.*;

import java.util.UUID;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name="user_info")
public class InfoUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    //@JsonIgnore
    @OneToOne(cascade=ALL,fetch = FetchType.LAZY)//, mappedBy="infoUser"
    @JoinColumn(name="data_id")
    //@JoinColumn(name="data_id", nullable=false)
    private SalaryUser salaryUser;
    //private UUID data_id;
    private String name;
    private String surname;
    private String mail;

    public InfoUser(){}


    public InfoUser( String name, String surname, String mail) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SalaryUser getSalaryUser() {
        return salaryUser;
    }

    public void setSalaryUser(SalaryUser salaryUser) {
        this.salaryUser = salaryUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "InfoUser{" +
                "id=" + id +
                ", salaryUser=" + salaryUser.getId() +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
