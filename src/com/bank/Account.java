package com.bank;

import java.util.ArrayList;
import java.util.List;
public abstract class Account implements Transferable {

    protected String accountNumber;
    private double balance;
    
    protected List<Transaction> transactions;
    protected List<Loan> loans;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
        }
    }

    public abstract boolean withdraw(double amount);

    @Override
    public void transfer(Account target, double amount) {
        if (withdraw(amount)) {
            transactions.add(new Transaction("Transfer Out", amount));

            target.deposit(amount);
            target.transactions.add(new Transaction("Transfer In", amount));
        }
    }

    public void printTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public void printLoans() {
        if (loans.isEmpty()) {
            System.out.println("No active loans.");
            return;
        }

        for (Loan loan : loans) {
            System.out.println("Remaining debt: " + loan.getRemainingDebt());
        }
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public java.util.List<Transaction> getTransactions() {
        return transactions;
    }

}
