package com.bank.test;

import com.bank.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankTest {

    private Bank bank;
    private SavingsAccount savings;
    private CheckingAccount checking;

    @BeforeEach
    void setUp() {
        bank = new Bank("My Bank");
        savings = new SavingsAccount("SA1", 1000);
        checking = new CheckingAccount("CA1", 500, 300);
        bank.addAccount(savings);
        bank.addAccount(checking);
    }

    @Test
    void findAccount_existingAccount_shouldReturnAccount() {
        assertEquals(savings, bank.findAccount("SA1"));
        assertEquals(checking, bank.findAccount("CA1"));
    }

    @Test
    void findAccount_nonExistingAccount_shouldReturnNull() {
        assertNull(bank.findAccount("XYZ"));
    }

    @Test
    void printAllAccounts_shouldShowBalances() {
        // sadece metod çalışıyor mu testi, konsola yazdırıyor
        bank.printAllAccounts();
    }

    @Test
    void printMonthlyReport_shouldRunWithoutError() {
        bank.printMonthlyReport(savings);
    }

}
