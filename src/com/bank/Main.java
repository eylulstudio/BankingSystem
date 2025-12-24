package com.bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("My Bank");

        SavingsAccount savings = new SavingsAccount("SA001", 1000);
        CheckingAccount checking = new CheckingAccount("CA001", 500, 300);

        bank.addAccount(savings);
        bank.addAccount(checking);

        System.out.println("=== Welcome to My Bank ===");

        boolean running = true;

        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1 - Deposit");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Transfer");
            System.out.println("4 - View Transactions");
            System.out.println("5 - View Balances");
            System.out.println("0 - Exit");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    savings.deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (savings.withdraw(withdrawAmount)) {
                        System.out.println("Withdraw successful.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;

                case 3:
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    savings.transfer(checking, transferAmount);
                    System.out.println("Transfer completed.");
                    break;

                case 4:
                    System.out.println("\n--- Savings Account Transactions ---");
                    savings.printTransactions();
                    break;

                case 5:
                    System.out.println("\n--- Account Balances ---");
                    bank.printAllAccounts();
                    break;

                case 0:
                    running = false;
                    System.out.println("Thank you for using My Bank.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
