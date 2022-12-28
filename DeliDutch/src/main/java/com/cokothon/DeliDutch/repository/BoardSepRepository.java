package com.cokothon.DeliDutch.repository;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.entity.BoardSep;
import com.cokothon.DeliDutch.entity.BoardTog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardSepRepository extends JpaRepository<BoardSep, Long> {
    List<BoardSep> findByDormitory(Dormitory dormitory);

    @Query(value = "SELECT * FROM Board_Separate b WHERE b.dormitory =:dormitory AND b.end_time > SYSDATE() ORDER BY end_time; ", nativeQuery = true)
    List<BoardSep> findBoardSepList(@Param("dormitory") String dormitory);
}
