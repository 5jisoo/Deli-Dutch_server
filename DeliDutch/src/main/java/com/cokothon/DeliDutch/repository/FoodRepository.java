package com.cokothon.DeliDutch.repository;

import com.cokothon.DeliDutch.entity.BoardSep;
import com.cokothon.DeliDutch.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
