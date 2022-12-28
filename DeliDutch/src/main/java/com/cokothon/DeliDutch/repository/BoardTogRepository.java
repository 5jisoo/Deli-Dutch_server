package com.cokothon.DeliDutch.repository;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.entity.BoardTog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardTogRepository extends JpaRepository<BoardTog, Long> {
    List<BoardTog> findByDormitory(Dormitory dormitory);

    @Query(value = "SELECT * FROM Board_tog b WHERE b.dormitory =:dormitory AND b.end_time > SYSDATE() ORDER BY end_time; ", nativeQuery = true)
    List<BoardTog> findBoardTogList(@Param("dormitory") String dormitory);

}
