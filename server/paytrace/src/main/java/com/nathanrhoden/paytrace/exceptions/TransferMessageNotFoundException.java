package com.nathanrhoden.paytrace.exceptions;

import lombok.Getter;

@Getter
public class TransferMessageNotFoundException extends Exception {

    private final String errMsg = "Transfer Message not found";

    public TransferMessageNotFoundException() {

    }



}
