package com.example.deliveryapi.dto;

import com.example.deliveryapi.model.Food;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantRequestDto {
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
}
