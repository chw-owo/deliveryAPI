package com.example.deliveryapi.repository;

import com.example.deliveryapi.model.Food;
import com.example.deliveryapi.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long>{

    List<Food> findAll();
    List<Food> findByName(String name);
    List<Food> findAllByRestaurantId(Restaurant restaurantId);

    Food findOneByName(String name);
}
