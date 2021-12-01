package com.apitest.restaurant.service;

import com.apitest.restaurant.dto.RestaurantDto;
import com.apitest.restaurant.model.Restaurant;
import com.apitest.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository RestaurantRepository;

    @Transactional
    public Restaurant createRestaurant(RestaurantDto requestDto) {
        int minOrderPriceChek = requestDto.getMinOrderPrice();
        int deliveryFeeCheck = requestDto.getDeliveryFee();

        Restaurant restaurant = new Restaurant(requestDto);

        // 참고
        // https://sanghaklee.tistory.com/61 Http Status code
        // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/HttpStatus.html
        // https://teamsparta.notion.site/Spring-5-3b73a283a2344117964443f8312b92e2#4fdaa7a6fb284621924449e3c65bcbe4 5주차 강의자료
        if(minOrderPriceChek<1000 || minOrderPriceChek>100000 || minOrderPriceChek%100 != 0){
//            System.out.println("최소 주문 가격이 잘못되었습니다.(1000원 이상, 100000원 이하, 100원 단위로 변경 ");
            throw new IllegalArgumentException("최소 주문 가격이 잘못되었습니다.(1000원 이상, 100000원 이하, 100원 단위로 변경" + minOrderPriceChek);
        }

        if(deliveryFeeCheck<0 || deliveryFeeCheck>10000 || deliveryFeeCheck%500 != 0){
//            System.out.println("기본 배달비가 잘못 입력되었습니다. (0원 이상, 10000원 이하, 500원 단위로 변경)");
            throw new IllegalArgumentException("기본 배달비가 잘못 입력되었습니다. (0원 이상, 10000원 이하, 500원 단위로 변경)" + deliveryFeeCheck);
        }

        RestaurantRepository.save(restaurant);

        return restaurant;
    }
}
