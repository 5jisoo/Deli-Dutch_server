package com.cokothon.DeliDutch.service;

import com.cokothon.DeliDutch.entity.Restaurant;
import com.cokothon.DeliDutch.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Optional<Restaurant> find(Long restaurantId) {
        return restaurantRepository.findById(restaurantId);
    }
}
