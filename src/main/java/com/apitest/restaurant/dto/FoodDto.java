package com.apitest.restaurant.dto;

import lombok.Getter;

@Getter
public class FoodDto {
    private Long restaurantId;
    private String name;
    private int price;
}