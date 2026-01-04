package com.bank.test;

import com.bank.SavingsAccount;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {

    private SavingsAccount account;

    @BeforeEach
    void setUp() {
        account = new SavingsAccount("SA-100", 1000);
    }

    @Test
    void deposit_shouldIncreaseBalance() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void withdraw_withSufficientBalance_shouldReturnTrue() {
        boolean result = account.withdraw(300);

        assertTrue(result);
        assertEquals(700, account.getBalance());
    }

    @Test
    void withdraw_withInsufficientBalance_shouldReturnFalse() {
        boolean result = account.withdraw(2000);

        assertFalse(result);
        assertEquals(1000, account.getBalance());
    }

    @Test
    void addInterest_shouldIncreaseBalanceByFivePercent() {
        account.addInterest();

        assertEquals(1050, account.getBalance(), 0.001);
    }
}
