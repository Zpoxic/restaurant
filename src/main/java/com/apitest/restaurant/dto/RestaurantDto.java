package com.apitest.restaurant.dto;

import lombok.Getter;

@Getter
public class RestaurantDto {
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
}