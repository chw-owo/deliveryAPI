package com.example.deliveryapi.model;

import com.example.deliveryapi.dto.RestaurantRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Restaurant {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable=false)
    private String name;

    @Min(0)
    @Max(100000)
    @Column
    private int minOrderPrice;

    @Min(0)
    @Max(10000)
    @Column
    private int deliveryFee;

    public Restaurant(String name, int minOrderPrice, int deliveryFee) {

        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }
    public void update(RestaurantRequestDto requestDto) {

        this.name = requestDto.getName();
        this.minOrderPrice = requestDto.getMinOrderPrice();
        this.deliveryFee = requestDto.getDeliveryFee();
    }
    public Restaurant(RestaurantRequestDto requestDto) {

        this.name = requestDto.getName();
        this.minOrderPrice = requestDto.getMinOrderPrice();
        this.deliveryFee = requestDto.getDeliveryFee();
    }


}
