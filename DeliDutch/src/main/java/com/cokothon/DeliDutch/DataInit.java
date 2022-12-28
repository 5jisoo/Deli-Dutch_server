package com.cokothon.DeliDutch;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.entity.BoardSep;
import com.cokothon.DeliDutch.entity.Food;
import com.cokothon.DeliDutch.entity.Restaurant;
import com.cokothon.DeliDutch.entity.User;
import com.cokothon.DeliDutch.service.BoardSepService;
import com.cokothon.DeliDutch.service.FoodService;
import com.cokothon.DeliDutch.service.RestaurantService;
import com.cokothon.DeliDutch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final FoodService foodService;
    private final RestaurantService restaurantService;
    private final UserService userService;
    private final BoardSepService boardSepService;

    @PostConstruct
    public void init() {

        Restaurant kyochon = restaurantService.save(Restaurant.builder()
                .category("chicken")
                .build());

        Food ch1 = foodService.save(Food.builder().name("허니콤보").price(17000).restaurant(kyochon).build());
        Food ch2 = foodService.save(Food.builder().name("레드콤보").price(16000).restaurant(kyochon).build());
        Food ch3 = foodService.save(Food.builder().name("오리지널콤보").price(15000).restaurant(kyochon).build());

        Restaurant domino = restaurantService.save(Restaurant.builder()
                .category("pizza")
                .build());

        Food pz1 = foodService.save(Food.builder().name("콤비네이션 피자").price(24000).restaurant(domino).build());
        Food pz2 = foodService.save(Food.builder().name("파인애플 피자").price(20000).restaurant(domino).build());
        Food pz3 = foodService.save(Food.builder().name("페페로니 피자").price(34000).restaurant(domino).build());

        User user = userService.save(User.builder()
                .email("aaa@naver.com")
                .username("s나송")
                .password("aaa")
                .dormitory(Dormitory.SOOKMYUNG).build());

    }
}
