package com.salary_tool.salary_backend;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SalaryFunctions {
    static final double baseIncome=38000;
    static final double juniorModal= 0.75; //percentage %
    static final double maxSeniorityModal=1.5; //percentage  %
    static final double responsibilityModal = 1.5; //percentage %
    static final double seniorityLevels= 4;
    //static final double seniorityGrowth =0.25; //percentage %
    static final double tenurityModal = 0.03; //percentage %
    //static final double growthModal = 0.0172519; //percentage %
    //static final double contractorModal = 0.1; //percentage %
    //static double baseSalary = 38000;
    //static double seniorityPlus;
    //static double loyaltyPlus;
    //static double responsibilityPlus;  //
    //static double seniority; //Expertise
    //static double loyaltyBonus; // 0
    //static double responsibility; //0-4
    //static double tenure;  //0-4
    //static double hourPerWeek;
    //static boolean isEmployee;
    //static double salaryTotal;

    public static SalaryDTO calculateSalary(SalaryInDTO numbers){
        double baseSalary = baseIncome;
        // 0=expertise(seniority)    1=responsibility   3=hours   4=employee(0-no/1-yes)   5=date(ms)
       //List<Double> resultsFinal = new ArrayList<Double>();

        double seniority=numbers.getExpertise();
        double responsibility=numbers.getResponsibility();
        double hourPerWeek=numbers.getHoursPerWeek();
        boolean isEmployee= numbers.isEmployee();
        double tenure= time(numbers.getMillis());
        double loyaltyBonus= loyalty(tenure);
        double loyaltyPlus= loyaltyPlusCalculator(loyaltyBonus, baseSalary);
        double seniorityPlus= seniorityPlusCalculator(baseSalary, seniority);
        double responsibilityPlus = responsibilityPlusCalculator(responsibility, baseSalary);
        double salaryTotal= totalSalaryCalculator(loyaltyPlus, baseSalary,seniorityPlus,responsibilityPlus, isEmployee);

        //for(int i =0 ; i< tenure; i++){
            //baseSalary = oneYearBaseSalary(baseSalary);
            //seniority= oneYearSeniority(seniority);
       // }
        //loyaltyBonus = loyalty(tenure);
        //seniorityPlus = seniorityPlusCalculator(baseSalary, seniority);
        //loyaltyPlus = loyaltyPlusCalculator(loyaltyBonus, baseSalary);
        //responsibilityPlus = responsibilityPlusCalculator(responsibility, baseSalary);
        //salaryTotal = totalSalaryCalculator(loyaltyPlus, baseSalary,seniorityPlus,responsibilityPlus);
        //salaryTotal = contractorBonus(salaryTotal, isEmployee);
        SalaryDTO salaryDTO = new SalaryDTO();
        salaryDTO.setSalaryTotal(round(hourPerWeekCalculator(salaryTotal, hourPerWeek)));
        salaryDTO.setSeniorityPlus(round(hourPerWeekCalculator(seniorityPlus, hourPerWeek)));
        salaryDTO.setLoyaltyPlus(round(hourPerWeekCalculator(loyaltyPlus, hourPerWeek)));
        salaryDTO.setResponsibilityPlus(round(hourPerWeekCalculator(responsibilityPlus, hourPerWeek)));
        salaryDTO.setSalaryFTE(round(salaryTotal));
        salaryDTO.setTenure(tenure);
        return salaryDTO;
        // 1=SalaryTotal   2=SeniorityPlus   3= loyaltyPlus   4=responsibilityPlus  5=SalaryTotal(FTE)  6=Year in the company

    }

    private static double time( double millis){
        double tenure;
        if(millis==0){
            tenure =0;
        }else {
            Date dateToday = new Date();
            Date dateSelected = new Date((long) millis);
            long diffInMillies = Math.abs(dateToday.getTime() - dateSelected.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            tenure = roundLow((diff / 365.24));

        }
        return tenure;
    }

    private static double hourPerWeekCalculator( double money, double hoursPerWeek) {
        if (hoursPerWeek < 0){
            throw new IllegalArgumentException("Hours per week cannot be negative");
        }

        return money*(hoursPerWeek/40.0);
    }

    private static double totalSalaryCalculator(double loyaltyPlus, double baseSalary, double seniorityPlus, double responsibilityPlus, boolean isEmployee) {

            return contractorBonus((baseSalary + seniorityPlus + loyaltyPlus + responsibilityPlus), isEmployee);
    }

//    private static double oneYearBaseSalary(double baseSalary) {
//
//        baseSalary = baseSalary*(1+ growthModal);
//    return baseSalary;
//    }

    private static double contractorBonus(double salaryTotal, boolean isEmployee ){
        if(!isEmployee){
            salaryTotal+=(0.1*salaryTotal);
        }
        return salaryTotal;
    }

    private static double loyalty(double tenure) {
        return Math.max(0, ((tenure - 3) *  tenurityModal));
    }

//    private static double oneYearSeniority(double seniority){
//
//        if(seniority>=4){
//            seniority=4;
//        } else if (seniority+seniorityGrowth>=4) {
//            seniority=4;
//        }else{
//            seniority+=seniorityGrowth;
//        }
//        return seniority;
//    }

    private static double loyaltyPlusCalculator(double loyaltyBonus, double baseSalary){
        return (baseSalary*loyaltyBonus);
    }

    private static double responsibilityPlusCalculator(double responsibility, double baseSalary){

        return ((responsibility-1)*(baseSalary*responsibilityModal/3));
    }


    private static double seniorityPlusCalculator(double baseSalary, double seniority){
        return ((baseSalary*juniorModal)-baseSalary)+(((baseSalary*(1-juniorModal+maxSeniorityModal))/seniorityLevels)*seniority);
    }
    private static double round(double value) {
        int places=0;
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    private static double roundLow(double value) {
        int places=0;
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.DOWN);
        return bd.doubleValue();
    }


}
