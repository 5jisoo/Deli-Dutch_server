package com.cokothon.DeliDutch.dto;

import com.cokothon.DeliDutch.entity.Food;
import com.cokothon.DeliDutch.entity.OrderSep;
import com.cokothon.DeliDutch.entity.Restaurant;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Data
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class FoodDto {

    private Long id;

    private Long restaurant_id;

    private String name;

    private int price;

    public FoodDto (Food food) {
        this.id = food.getId();
        this.restaurant_id = food.getRestaurant().getId();
        this.name = food.getName();
        this.price = food.getPrice();
    }
}
