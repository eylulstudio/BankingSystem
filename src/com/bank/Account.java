package com.bank;

public abstract class Account {

    protected String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public abstract boolean withdraw(double amount);

    public double getBalance() {
        return balance;
    }
    
    protected void setBalance(double balance) {
    	this.balance=balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
