package com.example.deliveryapi.repository;

import com.example.deliveryapi.model.Food;
import com.example.deliveryapi.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
