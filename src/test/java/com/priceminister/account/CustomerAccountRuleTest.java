package com.priceminister.account;

import com.priceminister.account.implementation.CustomerAccountRule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by paulrenaudat on 16/01/2017.
 * Tests the customer account rule
 */
public class CustomerAccountRuleTest {

    private AccountRule rule;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        rule = new CustomerAccountRule();
    }


    /**
     * Tests that negative balance is not allowed.
     */
    @Test
    public void testNegativeBalanceReturnsFalse() {
        boolean negativeBalancePermitted = rule.withdrawPermitted(-10d);
        assertEquals(false, negativeBalancePermitted);
    }
}
