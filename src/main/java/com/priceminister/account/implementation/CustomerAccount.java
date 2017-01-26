package com.priceminister.account.implementation;

import com.priceminister.account.*;
import com.priceminister.account.exception.IllegalBalanceException;


public class CustomerAccount implements Account {

    private Double balance = 0d;

    public void add(Double addedAmount) {
            balance += addedAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public Double withdrawAndReportBalance(Double withdrawAmount, AccountRule rule)
    		throws IllegalBalanceException {
        Double resultingAccountBalance = balance-withdrawAmount;
            if (rule.withdrawPermitted(resultingAccountBalance)) {
                withdraw(withdrawAmount);
            } else {
                throw new IllegalBalanceException(resultingAccountBalance);
            }
            return balance;
    }

    private void withdraw(Double withdrawAmount) {
        balance -= withdrawAmount;
    }
}
