package com.bank.test;

import com.bank.Bank;
import com.bank.Account;
import com.bank.SavingsAccount;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankTest {

    private Bank bank;
    private Account acc1;
    private Account acc2;

    @BeforeEach
    void setUp() {
        bank = new Bank("Test Bank");
        acc1 = new SavingsAccount("A-100", 1000);
        acc2 = new SavingsAccount("A-200", 500);

        bank.addAccount(acc1);
        bank.addAccount(acc2);
    }

    @Test
    void addAccount_shouldStoreAccounts() {
        Account found = bank.findAccount("A-100");

        assertNotNull(found);
        assertEquals("A-100", found.getAccountNumber());
    }

    @Test
    void findAccount_existingAccount_shouldReturnAccount() {
        Account found = bank.findAccount("A-200");

        assertNotNull(found);
        assertEquals(acc2, found);
    }

    @Test
    void findAccount_nonExistingAccount_shouldReturnNull() {
        Account found = bank.findAccount("X-999");

        assertNull(found);
    }

    @Test
    void getName_shouldReturnBankName() {
        assertEquals("Test Bank", bank.getName());
    }
}
