package com.example.deliveryapi.repository;

import com.example.deliveryapi.model.Orders;
import com.example.deliveryapi.model.Orders_Foods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersFoodsRepository extends JpaRepository<Orders_Foods, Long> {
}
