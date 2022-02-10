package com.example.deliveryapi.dto;

import com.example.deliveryapi.model.Orders_Foods;
import com.example.deliveryapi.model.Restaurant;
import com.sun.tools.javac.util.List;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class OrdersRequestDto {

    private Long restaurantId;
    //private Long foods;
//    private Restaurant restaurantId;
    private Orders_Foods foods;


}
