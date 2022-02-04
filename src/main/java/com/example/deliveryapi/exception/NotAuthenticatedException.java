package com.example.deliveryapi.exception;

public class NotAuthenticatedException extends IllegalArgumentException{
    private static final String MESSAGE = "식당 등록 권한이 없습니다.";
    public NotAuthenticatedException () {
        super(MESSAGE);
    }
}