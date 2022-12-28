package com.cokothon.DeliDutch.repository;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.entity.BoardSep;
import com.cokothon.DeliDutch.entity.BoardTog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardTogRepository extends JpaRepository<BoardTog, Long> {
    List<BoardTog> findByDormitory(Dormitory dormitory);
}
