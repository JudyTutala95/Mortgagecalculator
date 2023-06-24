package org.jtutala;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {

        System.out.print("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        if (x % 5 == 0) {
            if (x % 3 == 0) {
                System.out.println("FizzBuzz");
            } else {
                System.out.println("Fizz");
            }
        } else if (x % 3 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(x);
        }
    }
}
