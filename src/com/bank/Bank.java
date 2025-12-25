package com.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private List<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public void printAllAccounts() {
        for (Account acc : accounts) {
            System.out.println(
                "Account: " + acc.getAccountNumber() +
                " | Balance: " + acc.getBalance()
            );
        }
    }

    public String getName() {
        return name;
    }
    
    
    public void printMonthlyReport(Account account) {
        System.out.println("=== Monthly Report ===");
        System.out.println("Account Number: " + account.getAccountNumber());

        for (Transaction t : account.getTransactions()) {
            System.out.println(t);
        }

        System.out.println("Current Balance: " + account.getBalance());
    }

}
