package com.example.deliveryapi.controller;

import com.example.deliveryapi.dto.FoodRequestDto;
import com.example.deliveryapi.exception.MinOrderPriceException;
import com.example.deliveryapi.model.Food;
import com.example.deliveryapi.repository.FoodRepository;
import com.example.deliveryapi.security.UserDetailsImpl;
import com.example.deliveryapi.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class FoodController {

    private final FoodService foodService;


    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFoods(@PathVariable("restaurantId") Long restaurantId) throws SQLException {
        List<Food> foods = foodService.getFood(restaurantId);
        return foods;
    }

    // 신규 상품 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public Food registerFood(@PathVariable("restaurantId") Long restaurantId, @RequestBody FoodRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) throws SQLException {

        Food food = foodService.registerFood(requestDto, restaurantId, userDetails);
        return food;
    }


}
