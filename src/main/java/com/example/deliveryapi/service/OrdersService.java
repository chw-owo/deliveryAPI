package com.example.deliveryapi.service;

import com.example.deliveryapi.dto.OrdersRequestDto;
import com.example.deliveryapi.model.Food;
import com.example.deliveryapi.model.Orders;
import com.example.deliveryapi.model.Orders_Foods;
import com.example.deliveryapi.model.Restaurant;
import com.example.deliveryapi.repository.FoodRepository;
import com.example.deliveryapi.repository.OrdersRepository;
import com.example.deliveryapi.repository.RestaurantRepository;
import com.example.deliveryapi.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;


    public List<Orders> getOrders() throws SQLException {
        List<Orders> orders = ordersRepository.findAll();
        return orders;
    }

    // 신규 상품 등록
    public Orders registerOrders(@RequestBody OrdersRequestDto requestDto, Long restaurantIdCheck, @AuthenticationPrincipal UserDetailsImpl userDetails) throws SQLException {

        Orders ordersRequest = new Orders(requestDto);
        Restaurant restaurantId = restaurantRepository.findById(restaurantIdCheck).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 식당입니다.")
        );
//        Food foods = foodRepository.findById(ordersRequest.getFoods().getId()).orElseThrow(
//                () -> new IllegalArgumentException("존재하지 않는 메뉴입니다.")
//        );

        Orders_Foods orderFoods = ordersRequest.getFoods();

//
//        orderFoods.setName(ordersRequest.getFoods().getName());
//        orderFoods.setPrice(ordersRequest.getFoods().getPrice());cd cgw
//        orderFoods.setQuantity(ordersRequest.getFoods().getQuantity());
        int totalPrice = 1000;

        Orders ordersResponse = new Orders(restaurantId, totalPrice, orderFoods);

        return ordersRepository.save(ordersResponse);
    }
}
