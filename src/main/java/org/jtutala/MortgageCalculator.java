package org.jtutala;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    /**
     * A static method can only access static data members and static methods of another class or same class
     */
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        int principal = (int) readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 0, 30);
        byte years = (byte) readNumber("Period (Year) : ", 1, 30);

        printMortgage(principal, annualInterest, years);

        printPaymentSchedule(principal, annualInterest, years);
    }

    private static void printMortgage(int principal, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormat = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mothly Payments: " + mortgageFormat);
    }

    private static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualInterest, years, month);
            String balanceFormater = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(balanceFormater);

        }
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;

        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateBalance(int principal, float annualInterest, byte years, short numberOfPaymentsMade) {
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        float mothlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        return principal * (Math.pow(1 + mothlyInterest, numberOfPayments) -
                Math.pow(1 + mothlyInterest, numberOfPaymentsMade)) / (Math.pow(1 + mothlyInterest, numberOfPayments) - 1);
    }

    public static double calculateMortgage(int principal, float annualInterest, byte years) {
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        float mothlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        return principal * (mothlyInterest * (Math.pow(1 + mothlyInterest, numberOfPayments)) / (Math.pow(1 + mothlyInterest, numberOfPayments) - 1));
    }
}