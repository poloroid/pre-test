package com.priceminister.account;


import static org.junit.Assert.*;

import com.priceminister.account.exception.IllegalBalanceException;
import org.junit.*;

import com.priceminister.account.implementation.*;
import org.junit.rules.ExpectedException;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {
    
    private Account customerAccount;
    private AccountRule rule;

    @Rule
    public final ExpectedException exception= ExpectedException.none();

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
        rule = new CustomerAccountRule();
    }

    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        assertNotNull(customerAccount.getBalance());
        assertEquals(new Double(0), customerAccount.getBalance());
    }

    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
        Double positiveAmount = 50d;
        customerAccount.add(positiveAmount);
        assertEquals(positiveAmount, customerAccount.getBalance());
    }

    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Test
    public void testWithdrawAndReportBalanceIllegalBalance() throws IllegalBalanceException {
        Double initialBalance = 10d;
        Double withdrawAmount = 20d;
        customerAccount.add(initialBalance);
        exception.expect(IllegalBalanceException.class);
        customerAccount.withdrawAndReportBalance(withdrawAmount, rule);
    }

    /**
     * Tests that a withdrawal debits the account balance for the proper amount,
     * and returns the correct amount
     */
    @Test
    public void testWithdrawDebitsAccount() throws IllegalBalanceException{
        Double initialBalance = 50d;
        Double withdrawAmount = 10d;
        Double expectedBalance = initialBalance - withdrawAmount;
        customerAccount.add(initialBalance);
        Double remainingBalance = customerAccount.withdrawAndReportBalance(withdrawAmount, rule);
        assertEquals(expectedBalance, remainingBalance);
        assertEquals(expectedBalance, customerAccount.getBalance());
    }
}
