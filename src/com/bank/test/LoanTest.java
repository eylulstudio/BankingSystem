package com.bank.test;

import com.bank.Loan;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoanTest {

    private Loan loan;

    @BeforeEach
    void setUp() {
        loan = new Loan("L001", 500); 
    }

    @Test
    void getLoanId_shouldReturnCorrectId() {
        assertEquals("L001", loan.getLoanId());
    }

    @Test
    void getPrincipal_shouldReturnCorrectAmount() {
        assertEquals(500, loan.getPrincipal());
    }

    @Test
    void getRemainingDebt_shouldIncludeInterest() {
        assertEquals(550, loan.getRemainingDebt(), 0.01); 
    }

    @Test
    void pay_validAmount_shouldReduceRemainingDebt() {
        boolean paid = loan.pay(100);
        assertTrue(paid);
        assertEquals(450, loan.getRemainingDebt(), 0.01);
    }

    @Test
    void pay_exceedingAmount_shouldReturnFalse() {
        boolean paid = loan.pay(600); 
        assertFalse(paid);
        assertEquals(550, loan.getRemainingDebt(), 0.01);
    }

    @Test
    void pay_negativeAmount_shouldReturnFalse() {
        boolean paid = loan.pay(-100);
        assertFalse(paid);
        assertEquals(550, loan.getRemainingDebt(), 0.01);
    }

    @Test
    void pay_zeroAmount_shouldReturnFalse() {
        boolean paid = loan.pay(0);
        assertFalse(paid);
        assertEquals(550, loan.getRemainingDebt(), 0.01);
    }

}
