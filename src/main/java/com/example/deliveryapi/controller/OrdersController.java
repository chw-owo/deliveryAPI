package com.example.deliveryapi.controller;

import com.example.deliveryapi.dto.FoodRequestDto;
import com.example.deliveryapi.dto.OrdersRequestDto;
import com.example.deliveryapi.model.Food;
import com.example.deliveryapi.model.Orders;
import com.example.deliveryapi.security.UserDetailsImpl;
import com.example.deliveryapi.service.FoodService;
import com.example.deliveryapi.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
public class OrdersController {

    private final OrdersService ordersService;


    @GetMapping("/orders")
    public List<Orders> getOrders() throws SQLException {
        List<Orders> orders = ordersService.getOrders();
        return orders;
    }

    // 신규 상품 등록
    @PostMapping("/order/request")
    public Orders registerOrders(@RequestBody OrdersRequestDto requestDto,  @AuthenticationPrincipal UserDetailsImpl userDetails) throws SQLException {

        Orders orders = ordersService.registerOrders(requestDto, userDetails);
        return orders;
    }
}
