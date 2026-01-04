package com.bank.test;

import com.bank.Account;
import com.bank.SavingsAccount;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

    private Account from;
    private Account to;

    @BeforeEach
    void setUp() {
        from = new SavingsAccount("A-1", 1000);
        to = new SavingsAccount("A-2", 500);
    }

    @Test
    void deposit_shouldIncreaseBalance() {
        from.deposit(300);

        assertEquals(1300, from.getBalance());
    }

    @Test
    void transfer_withSufficientBalance_shouldReturnTrue() {
        boolean result = from.transfer(to, 400);

        assertTrue(result);
        assertEquals(600, from.getBalance());
        assertEquals(900, to.getBalance());
    }

    @Test
    void transfer_withInsufficientBalance_shouldReturnFalse() {
        boolean result = from.transfer(to, 2000);

        assertFalse(result);
        assertEquals(1000, from.getBalance());
        assertEquals(500, to.getBalance());
    }

    @Test
    void transfer_shouldCreateTransactions() {
        from.transfer(to, 200);

        assertEquals(2, from.getTransactions().size());
        assertEquals(2, to.getTransactions().size());
    }

}
