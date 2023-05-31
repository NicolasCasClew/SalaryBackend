package com.salary_tool.salary_backend.salaryUsers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salary_tool.salary_backend.InfoUsers.InfoUser;
import jakarta.persistence.*;
import java.util.UUID;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name="user_data")
public class SalaryUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

//    @OneToOne(fetch = FetchType.LAZY, cascade =ALL)
//    //@JsonIgnore
//    @JoinColumn(name="info_id")//, nullable=false
//    private InfoUser infoUser ;

//    @Column(
//            name="expertise",
//            nullable=false
//    )
    private double expertise;
//    @Column(
//            name="responsibility",
//            nullable=false
//    )
    private double responsibility;
//    @Column(
//            name="tenure",
//            nullable=false
//    )

//    @Column(
//            name="hoursPerWeek",
//            nullable=false
//    )
    private double hoursPerWeek;
//    @Column(
//            name="isEmployee",
//            nullable=false
//    )
    private boolean isEmployee;
//    @Column(
//            name="startDate",
//            nullable=false
//    )
    private double startDate;




    public SalaryUser(){

    }
    public SalaryUser(double expertise, double responsibility, double hoursPerWeek, boolean isEmployee, double startDate) {
        this.expertise = expertise;
        this.responsibility = responsibility;
        this.hoursPerWeek = hoursPerWeek;
        this.isEmployee = isEmployee;
        this.startDate = startDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getExpertise() {
        return expertise;
    }

    public void setExpertise(double expertise) {
        this.expertise = expertise;
    }

    public double getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(double responsibility) {
        this.responsibility = responsibility;
    }


    public double getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(double hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    public double getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

//    public InfoUser getInfoUser() {
//        return infoUser;
//    }
//
//    public void setInfoUser(InfoUser infoUser) {
//        this.infoUser = infoUser;
//    }

    @Override
    public String toString() {
        return "SalaryUser{" +
                "id=" + id +
               // ", infoUser=" + infoUser.getId() +
                ", expertise=" + expertise +
                ", responsibility=" + responsibility +
                ", hoursPerWeek=" + hoursPerWeek +
                ", isEmployee=" + isEmployee +
                ", startDate=" + startDate +
                '}';
    }
}
