package com.cokothon.DeliDutch.repository;

import com.cokothon.DeliDutch.entity.BoardSep;
import com.cokothon.DeliDutch.entity.OrderTog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTogRepository extends JpaRepository<OrderTog, Long> {
}
