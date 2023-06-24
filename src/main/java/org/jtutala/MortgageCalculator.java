package org.jtutala;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        final int MIN_VALUE = 1000;
        final int MAX_VALUE = 1_000_000;

        int principal;
        float annualInterest;
        float mothlyInterest;
        byte years;
        int monthlyPayment;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal (1K - 1M): ");
            principal = scanner.nextInt();
            if (principal >= MIN_VALUE && principal <= MAX_VALUE) {
                break;
            }
            System.out.println("Enter a value between 1 000 and 1 000 000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();

            if (annualInterest > 0 && annualInterest <= 30) {
                mothlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value greater than 0 and less than or equal to 30");
        }


        while (true) {
            System.out.print("Period (Year) : ");
            years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                monthlyPayment = years * MONTHS_IN_YEAR;
                break;
            }

            System.out.println("Enter a value between 1 and 30");
        }


        double mortgage = principal * (mothlyInterest * (Math.pow(1 + mothlyInterest, monthlyPayment)) / (Math.pow(1 + mothlyInterest, monthlyPayment) - 1));
        String mortgareFormater = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + mortgareFormater);
    }
}
