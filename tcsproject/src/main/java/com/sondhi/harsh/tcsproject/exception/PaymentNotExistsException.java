package com.sondhi.harsh.tcsproject.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PaymentNotExistsException extends RuntimeException{
    public PaymentNotExistsException(String message){
        super(message);
    }
}
