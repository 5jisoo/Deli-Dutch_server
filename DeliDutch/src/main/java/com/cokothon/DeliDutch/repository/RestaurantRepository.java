package com.cokothon.DeliDutch.repository;

import com.cokothon.DeliDutch.entity.BoardSep;
import com.cokothon.DeliDutch.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
