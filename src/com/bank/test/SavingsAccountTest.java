package com.bank.test;

import com.bank.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {

    private SavingsAccount savings;

    @BeforeEach
    void setUp() {
        savings = new SavingsAccount("SA1", 1000);
    }

    @Test
    void withdraw_withinBalance_shouldReturnTrue() {
        assertTrue(savings.withdraw(500));
        assertEquals(500, savings.getBalance());
    }

    @Test
    void withdraw_exceedBalance_shouldReturnFalse() {
        assertFalse(savings.withdraw(1500));
        assertEquals(1000, savings.getBalance());
    }

    @Test
    void deposit_shouldIncreaseBalance() {
        savings.deposit(200);
        assertEquals(1200, savings.getBalance());
    }

    @Test
    void addInterest_shouldIncreaseBalance() {
        savings.addInterest(); // 
        assertEquals(1050, savings.getBalance(), 0.01);
    }

    @Test
    void transfer_shouldDecreaseBalanceCorrectly() {
        CheckingAccount checking = new CheckingAccount("CA1", 500, 300);
        assertTrue(savings.transfer(checking, 400));
        assertEquals(600, savings.getBalance());
        assertEquals(900, checking.getBalance());
    }

}
