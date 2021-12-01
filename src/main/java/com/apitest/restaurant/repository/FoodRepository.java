package com.apitest.restaurant.repository;

import com.apitest.restaurant.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    Optional<Food> findByNameAndRestaurantId(String name, Long RestaurantId);
    List<Food> findAllByRestaurantId(Long restaurantId);
}
