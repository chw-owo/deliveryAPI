package com.example.deliveryapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Orders_Foods {


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "Food_Id", nullable = true)
    private Food foodId;

    @Column(nullable=true)
    private int quantity;

    @Column(nullable=true)
    private String name;// = OrdersFoodRepository.findOneById(Orders_Foods.getId()).getName();

    @Column(nullable=true)
    private int price;//= OrdersFoodRepository.findOneById(Orders_Foods.getId()).getPrice();

}
