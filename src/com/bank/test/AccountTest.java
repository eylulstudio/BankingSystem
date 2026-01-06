package com.bank.test;

import com.bank.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

    private SavingsAccount savings;
    private CheckingAccount checking;

    @BeforeEach
    void setUp() {
        savings = new SavingsAccount("SA1", 1000);
        checking = new CheckingAccount("CA1", 500, 300);
    }

    // ---------- Deposit ----------
    @Test
    void deposit_shouldIncreaseBalance() {
        savings.deposit(500);
        assertEquals(1500, savings.getBalance());
    }

    @Test
    void deposit_negativeAmount_shouldNotChangeBalance() {
        savings.deposit(-100);
        assertEquals(1000, savings.getBalance());
    }

    // ---------- Withdraw ----------
    @Test
    void withdraw_savingsSufficientBalance_shouldReturnTrue() {
        assertTrue(savings.withdraw(500));
        assertEquals(500, savings.getBalance());
    }

    @Test
    void withdraw_savingsInsufficientBalance_shouldReturnFalse() {
        assertFalse(savings.withdraw(1500));
        assertEquals(1000, savings.getBalance());
    }

    @Test
    void withdraw_checkingWithinOverdraft_shouldReturnTrue() {
        assertTrue(checking.withdraw(700)); 
        assertEquals(-200, checking.getBalance());
    }

    @Test
    void withdraw_checkingExceedOverdraft_shouldReturnFalse() {
        assertFalse(checking.withdraw(900));
        assertEquals(500, checking.getBalance());
    }

    // ---------- Transfer ----------
    @Test
    void transfer_sufficientBalance_shouldReturnTrue() {
        assertTrue(savings.transfer(checking, 400));
        assertEquals(600, savings.getBalance());
        assertEquals(900, checking.getBalance());
    }

    @Test
    void transfer_insufficientBalance_shouldReturnFalse() {
        assertFalse(savings.transfer(checking, 2000));
        assertEquals(1000, savings.getBalance());
        assertEquals(500, checking.getBalance());
    }

    @Test
    void transfer_shouldCreateTransactions() {
        savings.transfer(checking, 200);
        assertEquals(2, savings.getTransactions().size());
        assertEquals(2, checking.getTransactions().size()); 
    }

    // ---------- Loan ----------
    @Test
    void takeLoan_shouldIncreaseBalanceAndTransactions() {
        Loan loan = new Loan("L001", 500);
        savings.takeLoan(loan);
        assertEquals(1500, savings.getBalance(), 0.01); 
        assertEquals(2, savings.getTransactions().size());
        assertEquals(1, savings.getLoans().size());
    }

    @Test
    void payLoan_validAmount_shouldDecreaseDebtAndBalance() {
        Loan loan = new Loan("L002", 500);
        savings.takeLoan(loan);
        boolean paid = savings.payLoan("L002", 100);
        assertTrue(paid);
        assertEquals(450, loan.getRemainingDebt(), 0.01); 
        assertEquals(1000 + 500 - 100, savings.getBalance(), 0.01); 
    }

    @Test
    void payLoan_overAmount_shouldReturnFalse() {
        Loan loan = new Loan("L003", 500);
        savings.takeLoan(loan);
        boolean paid = savings.payLoan("L003", 2000); 
        assertFalse(paid);
    }

    @Test
    void payLoan_insufficientBalance_shouldReturnFalse() {
        Loan loan = new Loan("L004", 1000);
        savings.takeLoan(loan);
        boolean paid = savings.payLoan("L004", 2000); 
        assertFalse(paid);
    }

}
