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

    // Para yatırma
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
        }
    }

    // Para çekme (polymorphism için abstract)
    public abstract boolean withdraw(double amount);

    // Transfer işlemi
    @Override
    public boolean transfer(Account target, double amount) {
        if (withdraw(amount)) {
            target.deposit(amount);
            transactions.add(new Transaction("Transfer Out", amount));
            target.transactions.add(new Transaction("Transfer In", amount));
            return true;
        }
        return false;
    }

    // Kredi alma
    public void takeLoan(Loan loan) {
        loans.add(loan);
        deposit(loan.getPrincipal());
        transactions.add(new Transaction("Loan Taken", loan.getPrincipal()));
    }

    // Kredi ödeme
    public boolean payLoan(String loanId, double amount) {
        for (Loan loan : loans) {
            if (loan.getLoanId().equals(loanId)) {

                if (amount > balance) {
                    return false;
                }

                boolean paid = loan.pay(amount);
                if (paid) {
                    balance -= amount;
                    transactions.add(new Transaction("Loan Payment", amount));
                }

                return paid;
            }
        }
        return false;
    }

    // Loan listeleme
    public void printLoans() {
        if (loans.isEmpty()) {
            System.out.println("No active loans.");
            return;
        }

        for (Loan loan : loans) {
            System.out.println(loan);
        }
    }

    // Transaction listeleme
    public void printTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions.");
            return;
        }

        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
    
    protected void setBalance(double balance) {
        this.balance = balance;
    }
    
    public List<Loan> getLoans() {
        return loans;
    }

}
