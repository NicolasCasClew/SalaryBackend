package com.salary_tool.salary_backend.salaryUsers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDataInDTO {
    String name;
    String surname;
    String mail;
    double expertise;
    double responsibility;
    double hoursPerWeek;
    @JsonProperty
    boolean isEmployee;
    double millis;

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

    public double getMillis() {
        return millis;
    }

    public void setMillis(double millis) {
        this.millis = millis;
    }

    @Override
    public String toString() {
        return "UserDataInDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", expertise=" + expertise +
                ", responsibility=" + responsibility +
                ", hoursPerWeek=" + hoursPerWeek +
                ", isEmployee=" + isEmployee +
                ", millis=" + millis +
                '}';
    }
}
