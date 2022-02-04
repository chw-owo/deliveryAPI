package com.example.deliveryapi.exception;

public class MinOrderPriceException extends RuntimeException{
    private static final String MESSAGE = "가격은 100원 단위로 설정 가능합니다";
    public MinOrderPriceException () {
        super(MESSAGE);
    }
}
