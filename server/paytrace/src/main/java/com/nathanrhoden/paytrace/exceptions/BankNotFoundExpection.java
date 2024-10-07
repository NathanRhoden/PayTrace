package com.nathanrhoden.paytrace.exceptions;


public class BankNotFoundExpection extends RuntimeException {

    private String message;
    private Throwable throwable;

    public BankNotFoundExpection(String message, Throwable no_bank) {
        super(message);
    }


}
