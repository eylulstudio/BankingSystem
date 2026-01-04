package com.bank.test;

import com.bank.Loan;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoanTest {

    private Loan loan;

    @BeforeEach
    void setUp() {
        loan = new Loan("L-100", 1000);
    }

    @Test
    void constructor_shouldApplyInterestRate() {
        assertEquals(1100, loan.getRemainingDebt(), 0.001);
    }

    @Test
    void pay_validAmount_shouldReduceRemainingDebt() {
        boolean result = loan.pay(300);

        assertTrue(result);
        assertEquals(800, loan.getRemainingDebt(), 0.001);
    }

    @Test
    void pay_amountGreaterThanDebt_shouldReturnFalse() {
        boolean result = loan.pay(2000);

        assertFalse(result);
        assertEquals(1100, loan.getRemainingDebt(), 0.001);
    }

    @Test
    void pay_negativeAmount_shouldReturnFalse() {
        boolean result = loan.pay(-100);

        assertFalse(result);
        assertEquals(1100, loan.getRemainingDebt(), 0.001);
    }
}
