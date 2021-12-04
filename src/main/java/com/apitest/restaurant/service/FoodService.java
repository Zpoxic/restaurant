package com.apitest.restaurant.service;


import com.apitest.restaurant.dto.FoodDto;
import com.apitest.restaurant.model.Food;
import com.apitest.restaurant.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;


@RequiredArgsConstructor
@Service
public class FoodService {
    private final FoodRepository FoodRepository;

    @Transactional
    public void createFood(Long restaurantId, List<FoodDto> requestDto){
        int count = 0;
        for(FoodDto check : requestDto ){
//          //확인용 코드
//          System.out.println(count);
//          System.out.println(requestDto.get(count).getName());
//          System.out.println(requestDto.get(count).getPrice());

            String nameCheck = requestDto.get(count).getName();
            int priceCheck = requestDto.get(count).getPrice();

            Food foods = new Food(restaurantId, nameCheck, priceCheck);

            // 조건문
            Optional<Food> found = FoodRepository.findByNameAndRestaurantId(nameCheck, restaurantId);
            if (found.isPresent()) {
                throw new IllegalArgumentException("중복된 메뉴입니다.");
            }

            if(priceCheck<100 || priceCheck>1000000 || priceCheck%100!=0) {
                throw new IllegalArgumentException("음식 가격이 잘못되었습니다.(100원 이상, 1000000원 이하, 100원 단위로 변경");
            }
            FoodRepository.save(foods);

            count++;
        }
    }
}
