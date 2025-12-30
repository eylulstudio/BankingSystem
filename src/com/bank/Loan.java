package com.bank;

public class Loan {

    private double principal;
    private double interestRate;
    private double remainingDebt;

    public Loan(double principal, double interestRate) {
        this.principal = principal;
        this.interestRate = interestRate;
        this.remainingDebt = principal + (principal * interestRate);
    }

    public double getRemainingDebt() {
        return remainingDebt;
    }

    public double calculateMonthlyPayment(int months) {
        if (months <= 0) return 0;
        return remainingDebt / months;
    }

    public void pay(double amount) {
        if (amount > 0 && amount <= remainingDebt) {
            remainingDebt -= amount;
        }
    }
}
