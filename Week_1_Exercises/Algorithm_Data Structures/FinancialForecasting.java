/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week1;

/**
 *
 * @author shuva
 */


public class FinancialForecasting {

    // Method to calculate future value using recursion
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case: if years is 0, return the present value
        if (years == 0) {
            return presentValue;
        }

        // Recursive case: calculate future value for the remaining years
        double futureValue = presentValue * (1 + growthRate);
        return calculateFutureValue(futureValue, growthRate, years - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Example present value
        double growthRate = 0.05; // Example annual growth rate (5%)
        int years = 10; // Example number of years

        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("The future value after %d years is: %.2f\n", years, futureValue);
    }
}
