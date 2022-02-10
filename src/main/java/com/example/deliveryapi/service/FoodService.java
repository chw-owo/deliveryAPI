package com.example.deliveryapi.service;

import com.example.deliveryapi.dto.FoodRequestDto;
import com.example.deliveryapi.exception.MinOrderPriceException;
import com.example.deliveryapi.model.Food;
import com.example.deliveryapi.model.Restaurant;
import com.example.deliveryapi.repository.FoodRepository;
import com.example.deliveryapi.repository.RestaurantRepository;
import com.example.deliveryapi.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import java.sql.SQLException;
import java.util.List;
@RequiredArgsConstructor
@Service
public class FoodService {

    private final EntityManager em;
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;



    public Food registerFood(FoodRequestDto requestDto, Long restaurantIdLong, @AuthenticationPrincipal UserDetailsImpl userDetails) throws SQLException {
// 요청받은 DTO 로 DB에 저장할 객체 만들기


        if(requestDto.getPrice()% 100 != 0) {
            throw new MinOrderPriceException();
        }

//        if (userDetails.getRole()!= UserRoleEnum.ADMIN){
//            throw new NotAuthenticatedException();
//        }
        Restaurant restaurantId = restaurantRepository.findById(restaurantIdLong).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 식당입니다.")
        );

        if(foodRepository.findOneByName(requestDto.getName()) != null &&
            foodRepository.findOneByName(requestDto.getName()).getRestaurantId() == restaurantId){

                throw new NonUniqueResultException("이미 존재하는 메뉴입니다.");

        }

        Food food = new Food(requestDto, restaurantId);
        return foodRepository.save(food);
    }

    public List<Food> getFood(Long restaurantIdLong) throws SQLException {


        Restaurant restaurantId = restaurantRepository.findById(restaurantIdLong).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 식당입니다.")
        );
        List<Food> food = foodRepository.findAllByRestaurantId(restaurantId);
        return food;
    }

}