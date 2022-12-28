package com.cokothon.DeliDutch.entity;

import com.cokothon.DeliDutch.dto.BoardSepDto;
import com.cokothon.DeliDutch.dto.FoodDto;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(name = "food_name")
    private String name;

    @Column
    private int price;
    public static FoodDto of(Food food) {
        return FoodDto.builder()
                .id(food.getId())
                .restaurant_id(food.getRestaurant().getId())
                .name(food.getName())
                .price(food.getPrice())
                .build();
    }
}

