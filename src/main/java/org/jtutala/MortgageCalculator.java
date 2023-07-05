package org.jtutala;

public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;
    private int principal;
    private float annualInterest;
    private short years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        short numberOfPayments = getNumberOfPayments();
        float mothlyInterest = getMothlyInterest();

        return principal * (Math.pow(1 + mothlyInterest, numberOfPayments) -
                Math.pow(1 + mothlyInterest, numberOfPaymentsMade)) / (Math.pow(1 + mothlyInterest, numberOfPayments) - 1);
    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];

        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateBalance(month);

        return balances;
    }


    public double calculateMortgage() {
        short numberOfPayments = getNumberOfPayments();
        float mothlyInterest = getMothlyInterest();

        return principal * (mothlyInterest * (Math.pow(1 + mothlyInterest, numberOfPayments)) / (Math.pow(1 + mothlyInterest, numberOfPayments) - 1));
    }

    private float getMothlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private short getNumberOfPayments() {
        return (short) (years * MONTHS_IN_YEAR);
    }
}