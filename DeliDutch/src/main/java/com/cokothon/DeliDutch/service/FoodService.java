package com.cokothon.DeliDutch.service;

import com.cokothon.DeliDutch.entity.Food;
import com.cokothon.DeliDutch.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;

    public Food save(Food food) {
        return foodRepository.save(food);
    }

    public Optional<Food> find(Long foodId) {
        return foodRepository.findById(foodId);
    }
}
