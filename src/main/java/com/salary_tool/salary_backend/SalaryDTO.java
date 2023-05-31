package com.salary_tool.salary_backend;

public class SalaryDTO {
    double salaryTotal;
    double seniorityPlus;
    double loyaltyPlus;
    double responsibilityPlus;
    double salaryFTE;
    double tenure;



    public double getSalaryTotal() {
        return salaryTotal;
    }

    public void setSalaryTotal(double salaryTotal) {
        this.salaryTotal = salaryTotal;
    }

    public double getSeniorityPlus() {
        return seniorityPlus;
    }

    public void setSeniorityPlus(double seniorityPlus) {
        this.seniorityPlus = seniorityPlus;
    }

    public double getLoyaltyPlus() {
        return loyaltyPlus;
    }

    public void setLoyaltyPlus(double loyaltyPlus) {
        this.loyaltyPlus = loyaltyPlus;
    }

    public double getResponsibilityPlus() {
        return responsibilityPlus;
    }

    public void setResponsibilityPlus(double responsibilityPlus) {
        this.responsibilityPlus = responsibilityPlus;
    }

    public double getSalaryFTE() {
        return salaryFTE;
    }

    public void setSalaryFTE(double salaryFTE) {
        this.salaryFTE = salaryFTE;
    }

    public double getTenure() {
        return tenure;
    }

    public void setTenure(double tenure) {
        this.tenure = tenure;
    }

}
