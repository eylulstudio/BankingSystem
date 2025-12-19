package com.bank;

public class CheckingAccount extends Account {

    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= getBalance() + overdraftLimit) {
            setBalance(getBalance() - amount);
            transactions.add(new Transaction("Withdraw", amount));
            return true;
        }
        return false;
    }
}
