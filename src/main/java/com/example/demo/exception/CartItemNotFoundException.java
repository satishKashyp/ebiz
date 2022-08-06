package com.example.demo.exception;

public class CartItemNotFoundException extends RuntimeException{
    public CartItemNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
