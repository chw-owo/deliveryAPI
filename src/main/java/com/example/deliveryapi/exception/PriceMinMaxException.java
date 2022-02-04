package com.example.deliveryapi.exception;

public class PriceMinMaxException extends RuntimeException{
    private static final String MESSAGE = "가격 범위를 초과했습니다.";
    public PriceMinMaxException () {
        super(MESSAGE);
    }
}
