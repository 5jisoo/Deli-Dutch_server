package com.cokothon.DeliDutch.repository;

import com.cokothon.DeliDutch.entity.BoardSep;
import com.cokothon.DeliDutch.entity.BoardTog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardTogRepository extends JpaRepository<BoardTog, Long> {
}
