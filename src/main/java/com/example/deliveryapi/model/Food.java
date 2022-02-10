package com.example.deliveryapi.model;


import com.example.deliveryapi.dto.FoodRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Food {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Restaurant_ID", nullable = false)
    private Restaurant restaurantId;

    @Column(nullable=false)
    private String name;

    @Min(100)
    @Max(1000000)
    @Column(nullable=false)
    private int price;

    public Food(String name, Restaurant restaurantId, int price) {

        this.name = name;
        this.restaurantId = restaurantId;
        this.price = price;
    }

    public void update(FoodRequestDto requestDto, Restaurant restaurantId) {

        this.name = requestDto.getName();
        this.restaurantId = restaurantId;
        this.price = requestDto.getPrice();
    }
    public Food(FoodRequestDto requestDto, Restaurant restaurantId) {

        this.name = requestDto.getName();
        this.restaurantId = restaurantId;
        this.price = requestDto.getPrice();
    }


}
