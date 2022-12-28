package com.cokothon.DeliDutch.repository;

import com.cokothon.DeliDutch.dto.FoodDto;
import com.cokothon.DeliDutch.entity.BoardSep;
import com.cokothon.DeliDutch.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    @Query(value = "SELECT * FROM FOOD f WHERE f.restaurant_id =:restaurant_id ;", nativeQuery = true)
    List<Food> findFoodList(@Param("restaurant_id") Long id);
}
