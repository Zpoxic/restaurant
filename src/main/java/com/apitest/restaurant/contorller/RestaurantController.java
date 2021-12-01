package com.apitest.restaurant.contorller;

import com.apitest.restaurant.dto.RestaurantDto;
import com.apitest.restaurant.model.Restaurant;
import com.apitest.restaurant.repository.RestaurantRepository;
import com.apitest.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequiredArgsConstructor
@RestController
public class RestaurantController {
    private final RestaurantService RestaurantService;
    private final RestaurantRepository restaurantRepository;

    // 음식점 등록
    // POST /restaurant/register
    // { name : (String)value,
    //   minOrder : (int? Long?)value,
    //   deliveryFee : (int? Long?)value }
    @PostMapping("/restaurant/register")
    public Restaurant createRestaurant(@RequestBody RestaurantDto requestDto){
        return RestaurantService.createRestaurant(requestDto);
    }


    // 음식점 조회 (음식점 등록 id를 여러개 받아올 수 있도록 되어야할듯함)
    // GET /restaurants
    // { { id : Long value(@GeneratedValue(strategy = GenerationType.AUTO)),
    // restaurant/register (name, minOrder, deliveryFee) } }
    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant(){
        return restaurantRepository.findAll();
    }
}
