package com.example.deliveryapi.dto;

import com.example.deliveryapi.model.Orders_Foods;
import com.example.deliveryapi.model.Restaurant;
import com.sun.tools.javac.util.List;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class OrdersResponseDto {

    private Restaurant restaurantId;
//    private String RestaurantName;
//    private int deliveryFee;
    private int totalPrice;
    private List<Orders_Foods> foods;
}
