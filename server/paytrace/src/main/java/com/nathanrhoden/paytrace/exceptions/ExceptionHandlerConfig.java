package com.nathanrhoden.paytrace.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandlerConfig {

    @org.springframework.web.bind.annotation.ExceptionHandler(BankAlreadyExistsExpection.class)
    public ResponseEntity<String> bankAlreadyExistsHandler(BankAlreadyExistsExpection exception) {

        System.err.println("Bank already exists" + exception.getMessage());

        String responseMessage = "Error: The bank already exists";

        return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(BankNotFoundExpection.class)
    public ResponseEntity<String> bankNotFoundHandler(BankNotFoundExpection exception) {

        System.err.println("Bank not Found" + exception.getMessage());

        String responseMessage = "Error: The bank is not found";

        return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(TransferMessageNotFoundException.class)
    public ResponseEntity<String> transferMessageNotFoundHandler(TransferMessageNotFoundException exception) {

        System.err.println("Transfer message not Found" + exception.getMessage());

        String responseMessage = "Error: The transfer message was not found";

        return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
    }

}
