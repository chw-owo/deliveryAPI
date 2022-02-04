package com.example.deliveryapi.exception;

public class DeliveryFeeException extends RuntimeException{
        private static final String MESSAGE = "배달비는 500원 단위로 설정 가능합니다";
        public DeliveryFeeException () {
            super(MESSAGE);
        }
    }

