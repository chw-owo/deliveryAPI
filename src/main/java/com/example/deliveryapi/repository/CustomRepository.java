package com.example.deliveryapi.repository;

import com.example.deliveryapi.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodCustomRepository{
    List<Food> responseAllFood();
}
