package com.example.deliveryapi.dto;

import com.example.deliveryapi.model.Restaurant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodRequestDto {
    private String name;
    private int price;

}