package com.bank;

public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
        this.interestRate = 0.05; // %5 faiz
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            transactions.add(new Transaction("Withdraw", amount));
            return true;
        }
        return false;
    }

    public void addInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        transactions.add(new Transaction("Interest", interest));
    }
}
