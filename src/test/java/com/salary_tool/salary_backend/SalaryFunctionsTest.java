package com.salary_tool.salary_backend;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SalaryFunctionsTest {
    @Test
    void hoursPerWeekShouldReturnFullSalaryFor40Hours() {
        double expected = 28500;
        Double actual = ReflectionTestUtils.invokeMethod(
                SalaryFunctions.class, "hourPerWeekCalculator", 28500.0, 40.0);
        assertEquals(expected, actual);
    }
    @Test
    void hoursPerWeekShouldReturn0At0Hours() {
        double expected = 0;
        Double actual = ReflectionTestUtils.invokeMethod(
                SalaryFunctions.class, "hourPerWeekCalculator", 28500.0, 0.0);

        assertEquals(expected, actual);
    }
    @Test
    void hoursPerWeekNegative40Hours() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ReflectionTestUtils.invokeMethod(
                    SalaryFunctions.class, "hourPerWeekCalculator", 28500.0, -40.0);
        });
        assertEquals("Hours per week cannot be negative", exception.getMessage());
    }
    @Test
    void timeReturns1TenureWhenMillis0() {
        double expected = 0;
        Double actual = ReflectionTestUtils.invokeMethod(
                SalaryFunctions.class, "time", 0.0);
        assertEquals(expected, actual);
    }
    @Test
    void timeReturns3TenureWhenMillisX() {
        double expected = 3;
        Double actual = ReflectionTestUtils.invokeMethod(
                SalaryFunctions.class, "time", 1808318041976.0);
        assertEquals(expected, actual);
    }
    @Test
    void loyaltyBonus0Before3Years() {
        double expected = 0;
        Double actual = ReflectionTestUtils.invokeMethod( //use a for to loop from 1 to 3
                SalaryFunctions.class, "loyalty", 2.0);
        assertEquals(expected, actual);
    }
    @Test
    void loyaltyBonus0After3Years() {
        double expected = 0.06;
        Double actual = ReflectionTestUtils.invokeMethod( //use a for to loop from 1 to 3
                SalaryFunctions.class, "loyalty", 5.0);
        assertEquals(expected, actual);
    }

    @Test
    void allPossibleSeniorityInputs() {
        double[] expected = {-9500.0,7125.0,23750.0,40375.0};
        for (int i=0; i<4; i++ ) {
            Double actual = ReflectionTestUtils.invokeMethod(
                    SalaryFunctions.class, "seniorityPlusCalculator", 38000.0,(double)i);
            assertEquals(expected[i], actual);
        }
    }
    @Test
    void allPossibleResponsibilityInputs() {
        double[] expected = {0.0,19000.0,38000.0,40375.0};
        for (int i=0; i<3; i++ ) {
            Double actual = ReflectionTestUtils.invokeMethod(
                    SalaryFunctions.class, "responsibilityPlusCalculator", i+1.0,38000.0);
            assertEquals(expected[i], actual);
        }
    }
    @Test
    void loyaltyWithTenureLessThan3(){
        double expected = 0;
        Double actual = ReflectionTestUtils.invokeMethod(
                SalaryFunctions.class, "loyalty", 2.0);
        assertEquals(expected, actual);
    }
    @Test
    void loyaltyWithTenureMoreThan3(){
        double expected = 0.06;
        Double actual = ReflectionTestUtils.invokeMethod(
                SalaryFunctions.class, "loyalty", 5.0);
        assertEquals(expected, actual);
    }
    @Test
    void contractorBonusWhenEmployee(){
        double expected = 285000;
        Double actual = ReflectionTestUtils.invokeMethod(
                SalaryFunctions.class, "contractorBonus", 285000.0, true);
        assertEquals(expected, actual);
    }
    @Test
    void contractorBonusWhenContractor(){
        double expected = 313500;
        Double actual = ReflectionTestUtils.invokeMethod(
                SalaryFunctions.class, "contractorBonus", 285000.0, false);
        assertEquals(expected, actual);
    }
    @Test
    void totalSalarySumsAllWhenEmployee(){
        double expected = 10000;
        Double actual = ReflectionTestUtils.invokeMethod(
                SalaryFunctions.class, "totalSalaryCalculator", 1000.0,2000.0,3000.0,4000.0, true);
        assertEquals(expected, actual);
    }
    @Test
    void totalSalarySumsAllWhenContractor(){
        double expected = 11000;
        Double actual = ReflectionTestUtils.invokeMethod(
                SalaryFunctions.class, "totalSalaryCalculator", 1000.0,2000.0,3000.0,4000.0, false);
        assertEquals(expected, actual);
    }
    @Test
    void loyaltyPlusCalculatorMultiplication(){
        double expected = 11400;
        Double actual = ReflectionTestUtils.invokeMethod(
                SalaryFunctions.class, "loyaltyPlusCalculator", 0.3,38000.0);
        assertEquals(expected, actual);
    }
    @Test
    void round5HalfUp(){
        double expected = 10.0;
        Double actual = ReflectionTestUtils.invokeMethod(
                SalaryFunctions.class, "round", 9.5);
        assertEquals(expected, actual);
    }
    @Test
    void roundDot4HalfUp(){
        double expected = 9.0;
        Double actual = ReflectionTestUtils.invokeMethod(
                SalaryFunctions.class, "round", 9.4);
        assertEquals(expected, actual);
    }
    @Test
    void roundDot5Down(){
        double expected = 10.0;
        Double actual = ReflectionTestUtils.invokeMethod(
                SalaryFunctions.class, "roundLow", 10.5);
        assertEquals(expected, actual);
    }
    @Test
    void roundDot6Down(){
        double expected = 10.0;
        Double actual = ReflectionTestUtils.invokeMethod(
                SalaryFunctions.class, "roundLow", 10.6);
        assertEquals(expected, actual);
    }
}