package com.example.deliveryapi.model;

import com.example.deliveryapi.dto.FoodRequestDto;
import com.example.deliveryapi.dto.OrdersRequestDto;
import com.example.deliveryapi.dto.OrdersResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Orders {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Restaurant_ID", nullable = false)
    private Restaurant restaurantId;

    @OneToOne //Many
    @JoinColumn(name = "Orders_Foods", nullable = false)
    private Orders_Foods foods;

//    @Column(nullable = true)
//    private long restaurantId;

//    @Column(nullable = true)
//    private long foods;

    @Column(nullable = true)
    private String restaurantName;

    @Column(nullable = true)
    private int deliveryFee;

    @Column(nullable = true)
    private int totalPrice;




    //request
    public Orders(Restaurant restaurantId, int totalPrice, Orders_Foods foods) {

        this.restaurantName= restaurantId.getName();
        this.deliveryFee= restaurantId.getDeliveryFee();;
        this.totalPrice=totalPrice;
        this.foods = foods;
    }

    public Orders(Restaurant restaurantId, Orders_Foods foods) {

        this.restaurantId = restaurantId;
        this.foods = foods;
    }

}
