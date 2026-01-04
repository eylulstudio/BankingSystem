package com.bank.test;

import com.bank.CheckingAccount;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckingAccountTest {

    private CheckingAccount account;

    @BeforeEach
    void setUp() {
        account = new CheckingAccount("CA-200", 1000, 500);
    }

    @Test
    void withdraw_withinBalance_shouldReturnTrue() {
        boolean result = account.withdraw(400);

        assertTrue(result);
        assertEquals(600, account.getBalance());
    }

    @Test
    void withdraw_usingOverdraft_shouldAllowNegativeBalance() {
        boolean result = account.withdraw(1200);

        assertTrue(result);
        assertEquals(-200, account.getBalance());
    }

    @Test
    void withdraw_exceedingOverdraftLimit_shouldReturnFalse() {
        boolean result = account.withdraw(1600);

        assertFalse(result);
        assertEquals(1000, account.getBalance());
    }
}
