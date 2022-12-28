package com.cokothon.DeliDutch.repository;

import com.cokothon.DeliDutch.entity.BoardSep;
import com.cokothon.DeliDutch.entity.OrderSep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderSepRepository extends JpaRepository<OrderSep, Long> {
}
