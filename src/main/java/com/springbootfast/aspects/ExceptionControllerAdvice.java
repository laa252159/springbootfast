package com.springbootfast.aspects;

import com.springbootfast.exceptions.NotEnoughMoneyException;
import com.springbootfast.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler(Exception e){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not enough money to make the payment. " + e.getMessage());
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
