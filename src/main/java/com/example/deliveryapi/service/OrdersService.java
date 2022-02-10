package com.example.deliveryapi.service;

import com.example.deliveryapi.dto.OrdersRequestDto;
import com.example.deliveryapi.model.Food;
import com.example.deliveryapi.model.Orders;
import com.example.deliveryapi.model.Orders_Foods;
import com.example.deliveryapi.model.Restaurant;
import com.example.deliveryapi.repository.FoodRepository;
import com.example.deliveryapi.repository.OrdersFoodsRepository;
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
    public Orders registerOrders(@RequestBody OrdersRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) throws SQLException {


        Restaurant restaurantId = restaurantRepository.findById(requestDto.getRestaurantId()).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 식당입니다.")
        );


        Food food = foodRepository.findById(requestDto.getFoods().getId()).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 음식입니다.")
        );

        Orders_Foods ordersFoods = new Orders_Foods();
        ordersFoods.setName(food.getName());
        ordersFoods.setPrice(food.getPrice());
        ordersFoods.setQuantity(1);//foods.getQuantity());

        int totalPrice = 1000;
        Orders ordersResponse = new Orders(restaurantId, totalPrice, ordersFoods);

//        Orders_Foods ordersFoods = new Orders_Foods();
//        for (int i =0; i<requestDto.getFoods().size(); i++){
//            Food food = requestDto.getFoods().get(i).getFoodId();
//            ordersFoods.setName(food.getName());
//            ordersFoods.setPrice(food.getPrice());
//            ordersFoods.setQuantity(1);//foods.getQuantity());
//        }
//        int totalPrice = 1000;
//        Orders ordersResponse = new Orders(restaurantId, totalPrice, ordersFoods);




        return ordersRepository.save(ordersResponse);
    }
}
