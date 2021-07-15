package com.example.demo.Exception;

public class UnprocessableEntityException extends RuntimeException{

    public UnprocessableEntityException(String message) {
        super(message);
    }
}
