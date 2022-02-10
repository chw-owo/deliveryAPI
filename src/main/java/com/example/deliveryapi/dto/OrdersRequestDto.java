package com.example.deliveryapi.dto;

import com.example.deliveryapi.model.Orders_Foods;
import com.example.deliveryapi.model.Restaurant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersRequestDto {

    private Restaurant restaurantId;
    private Orders_Foods foods;


}
