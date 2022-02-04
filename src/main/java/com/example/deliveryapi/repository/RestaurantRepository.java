package com.example.deliveryapi.repository;
import com.example.deliveryapi.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> { }
