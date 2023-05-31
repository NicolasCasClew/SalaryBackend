package com.salary_tool.salary_backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SalaryInDTO {
    double expertise;
    double responsibility;
    double hoursPerWeek;
    @JsonProperty
    boolean isEmployee;
    double millis;

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
        return "SalaryInDTO{" +
                "expertise=" + expertise +
                ", responsibility=" + responsibility +
                ", hoursPerWeek=" + hoursPerWeek +
                ", isEmployee=" + isEmployee +
                ", millis=" + millis +
                '}';
    }
}
