package com.example.deliveryapi.repository;

import com.example.deliveryapi.dto.FoodRequestDto;
import com.example.deliveryapi.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.List;

@Repository
@Transactional
public class FoodCustomRepositoryImpl implements CustomRepository {
    @Autowired
    EntityManager entityManager;


    @Override
    public List<Food> findAllFood(){
        String jpql = "SELECT f FROM Food f ";
        TypedQuery<Food> query = entityManager.createQuery(jpql, Food.class);
        List<Food> foodList = query.getResultList();

        Food foodReturn = null;
        List<Food> foodReturnList = null;

        for( Food food : foodList) {

            foodReturn.setName(food.getName());
            foodReturn.setPrice(food.getPrice());
            foodReturnList.add(foodReturn);

        }
        return foodReturnList;
    }
}
