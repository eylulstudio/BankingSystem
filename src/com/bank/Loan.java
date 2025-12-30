package com.bank;

public class Loan {

    private String loanId;
    private double principal;          
    private double totalDebt;          
    private double remainingDebt;      

    private static final double INTEREST_RATE = 0.10; 

    public Loan(String loanId, double principal) {
        this.loanId = loanId;
        this.principal = principal;
        this.totalDebt = principal + (principal * INTEREST_RATE);
        this.remainingDebt = this.totalDebt;
    }

    public String getLoanId() {
        return loanId;
    }

    public double getPrincipal() {
        return principal;
    }

    public double getTotalDebt() {
        return totalDebt;
    }

    public double getRemainingDebt() {
        return remainingDebt;
    }

   
    public double calculateMonthlyPayment(int months) {
        if (months <= 0) {
            return 0;
        }
        return remainingDebt / months;
    }

   
    public boolean pay(double amount) {
        if (amount > 0 && amount <= remainingDebt) {
            remainingDebt -= amount;
            return true;
        }
        return false;
    }

    public boolean isPaidOff() {
        return remainingDebt == 0;
    }

    @Override
    public String toString() {
        return "Loan ID: " + loanId +
               " | Principal: " + principal +
               " | Total Debt: " + totalDebt +
               " | Remaining Debt: " + remainingDebt;
    }
}
