package org.example;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal : ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");

        float annualInterest = scanner.nextFloat();
        float mothlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (Year) : ");

        byte years = scanner.nextByte();
        int monthlyPayment = years * MONTHS_IN_YEAR;

        double mortgage = principal * (mothlyInterest * (Math.pow(1 + mothlyInterest, monthlyPayment)) / (Math.pow(1 + mothlyInterest, monthlyPayment) - 1));
        String mortgareFormater = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("inteckning betalning: " + mortgareFormater);
    }
}