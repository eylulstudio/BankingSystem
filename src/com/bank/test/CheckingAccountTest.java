package com.bank.test;

import com.bank.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckingAccountTest {

    private CheckingAccount checking;

    @BeforeEach
    void setUp() {
        checking = new CheckingAccount("CA1", 500, 300);
    }

    @Test
    void withdraw_withinBalance_shouldReturnTrue() {
        assertTrue(checking.withdraw(400));
        assertEquals(100, checking.getBalance());
    }

    @Test
    void withdraw_withinOverdraft_shouldReturnTrue() {
        assertTrue(checking.withdraw(700)); 
        assertEquals(-200, checking.getBalance());
    }

    @Test
    void withdraw_exceedOverdraft_shouldReturnFalse() {
        assertFalse(checking.withdraw(900));
        assertEquals(500, checking.getBalance());
    }

    @Test
    void deposit_shouldIncreaseBalance() {
        checking.deposit(200);
        assertEquals(700, checking.getBalance());
    }

    @Test
    void transfer_shouldWorkCorrectly() {
        SavingsAccount savings = new SavingsAccount("SA1", 1000);
        assertTrue(checking.transfer(savings, 600)); 
        assertEquals(-100, checking.getBalance());
        assertEquals(1600, savings.getBalance());
    }

}
