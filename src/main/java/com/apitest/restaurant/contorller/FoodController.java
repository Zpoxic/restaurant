package com.apitest.restaurant.contorller;

import com.apitest.restaurant.dto.FoodDto;
import com.apitest.restaurant.model.Food;
import com.apitest.restaurant.repository.FoodRepository;
import com.apitest.restaurant.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final FoodService FoodService;
    private final FoodRepository FoodRepository;

    //POST /restaurant/{restaurantId}/food/register
    //[{ name: (String)value, price: (Int? Long?)value }]
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void createFood(@PathVariable Long restaurantId, @RequestBody List<FoodDto> requestDto){
        FoodService.createFood(restaurantId, requestDto);
    }

    //GET /restaurant/{restaurantId}/foods
    //[{ id:(Int? Long?)value, name: (String)value, price: (Int? Long?)value }]
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFood(@PathVariable Long restaurantId){
        return FoodRepository.findAllByRestaurantId(restaurantId);
    }
}
