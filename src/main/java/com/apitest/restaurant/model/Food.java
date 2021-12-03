package com.apitest.restaurant.model;

import com.apitest.restaurant.dto.FoodDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Food {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private Long restaurantId;


    public Food(Long restaurantId, String name, int price){
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
    }
}
