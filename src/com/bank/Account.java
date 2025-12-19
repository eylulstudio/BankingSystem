package com.bank;

public abstract class Account implements Transferable {

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
    
    @Override
    public void transfer(Account target, double amount) {
        if (withdraw(amount)) {
            target.deposit(amount);
        }
    }


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
