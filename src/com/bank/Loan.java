package com.bank;

public class Loan {

    private String loanId;
    private double principal;
    private double remainingDebt;

    private static final double INTEREST_RATE = 0.10;

    public Loan(String loanId, double principal) {
        this.loanId = loanId;
        this.principal = principal;
        this.remainingDebt = principal + (principal * INTEREST_RATE);
    }

    public String getLoanId() {
        return loanId;
    }

    public double getPrincipal() {
        return principal;
    }

    public double getRemainingDebt() {
        return remainingDebt;
    }

    public boolean pay(double amount) {
        if (amount > 0 && amount <= remainingDebt) {
            remainingDebt -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Loan ID: " + loanId +
               " | Remaining Debt: " + remainingDebt;
    }
}
