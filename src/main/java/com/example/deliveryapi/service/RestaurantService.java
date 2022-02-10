package com.example.deliveryapi.service;
import com.example.deliveryapi.dto.RestaurantRequestDto;
import com.example.deliveryapi.exception.DeliveryFeeException;
import com.example.deliveryapi.exception.MinOrderPriceException;
import com.example.deliveryapi.exception.NotAuthenticatedException;
import com.example.deliveryapi.exception.PriceMinMaxException;
import com.example.deliveryapi.model.Food;
import com.example.deliveryapi.model.Restaurant;
import com.example.deliveryapi.model.UserRoleEnum;
import com.example.deliveryapi.repository.RestaurantRepository;
import com.example.deliveryapi.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant registerRestaurant(RestaurantRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) throws SQLException {
// 요청받은 DTO 로 DB에 저장할 객체 만들기

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
//        if (userDetails.getRole()!= UserRoleEnum.ADMIN){
//            throw new NotAuthenticatedException();
//        }

        Restaurant restaurant = new Restaurant(requestDto);
        return restaurantRepository.save(restaurant);

    }

    public List<Restaurant> getRestaurant() throws SQLException {
        List<Restaurant> restaurant = restaurantRepository.findAll();
        return restaurant;
    }

//    public Restaurant updateRestaurant(Long id, RestaurantRequestDto requestDto) throws SQLException {
//        Restaurant Restaurant = RestaurantRepository.findById(id)
//                .orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));
//
//        int myprice = requestDto.getMyprice();
//        Restaurant.setMyprice(myprice);
//        RestaurantRepository.save(Restaurant);
//
//        return Restaurant;
//    }


}


