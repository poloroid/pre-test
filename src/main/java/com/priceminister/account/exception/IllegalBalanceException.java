package com.priceminister.account.exception;


public class IllegalBalanceException extends Exception {

	private final Double balance;
    
    public IllegalBalanceException(Double illegalBalance) {
        balance = illegalBalance;
    }
    
    public String toString() {
        return "Illegal account balance: " + balance;
    }
}
