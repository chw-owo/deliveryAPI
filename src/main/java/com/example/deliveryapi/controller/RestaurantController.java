package com.example.deliveryapi.controller;
import com.example.deliveryapi.dto.RestaurantRequestDto;
import com.example.deliveryapi.exception.DeliveryFeeException;
import com.example.deliveryapi.exception.MinOrderPriceException;
import com.example.deliveryapi.exception.NotAuthenticatedException;
import com.example.deliveryapi.exception.PriceMinMaxException;
import com.example.deliveryapi.model.UserRoleEnum;
import com.example.deliveryapi.security.UserDetailsImpl;
import com.example.deliveryapi.model.Restaurant;
import com.example.deliveryapi.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class RestaurantController {

    private final RestaurantService RestaurantService;

    @Autowired
    public RestaurantController(RestaurantService RestaurantService) {
        this.RestaurantService = RestaurantService;
    }

    @GetMapping("/restaurant")
    public List<Restaurant> getRestaurants() throws SQLException {
        List<Restaurant> restaurants = RestaurantService.getRestaurant();
        // 응답 보내기
        return restaurants;
    }

    // 신규 상품 등록
    @PostMapping("/restaurant/register")
    public Restaurant registerRestaurant(@RequestBody RestaurantRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) throws SQLException { //@AuthenticationPrincipal UserDetailsImpl userDetails
        if(requestDto.getDeliveryFee()% 500 != 0){
            throw new DeliveryFeeException();
        }
        if(requestDto.getMinOrderPrice()% 100 != 0){
            throw new MinOrderPriceException();
        }
        if(requestDto.getMinOrderPrice() < 0 || requestDto.getMinOrderPrice() > 100000){
            throw new PriceMinMaxException();
        }
        if(requestDto.getDeliveryFee() < 0 || requestDto.getDeliveryFee() >10000){
            throw new PriceMinMaxException();
        }
        if (userDetails.getRole()!= UserRoleEnum.ADMIN){
            throw new NotAuthenticatedException();
        }
        Restaurant restaurant = RestaurantService.registerRestaurant(requestDto);

        return restaurant;
    }

//    // 설정 가격 변경
//    @PutMapping("/api/Restaurants/{id}")
//    public Long updateRestaurant(@PathVariable Long id, @RequestBody RestaurantMypriceRequestDto requestDto) throws SQLException {
//        Restaurant Restaurant = RestaurantService.updateRestaurant(id, requestDto);
//
//// 응답 보내기 (업데이트된 상품 id)
//        return Restaurant.getId();
//    }

    // 등록된 전체 상품 목록 조회

}