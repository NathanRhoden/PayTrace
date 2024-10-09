package com.nathanrhoden.paytrace.exceptions;

public class BankAlreadyExistsExpection extends RuntimeException{

    public BankAlreadyExistsExpection(String message) {
        super(message);
    }
}
