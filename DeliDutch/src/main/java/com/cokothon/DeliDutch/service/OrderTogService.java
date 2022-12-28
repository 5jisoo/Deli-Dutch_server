package com.cokothon.DeliDutch.service;

import com.cokothon.DeliDutch.entity.BoardTog;
import com.cokothon.DeliDutch.entity.OrderTog;
import com.cokothon.DeliDutch.repository.BoardTogRepository;
import com.cokothon.DeliDutch.repository.OrderTogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderTogService {
    private final OrderTogRepository orderTogRepository;
    private final BoardTogRepository boardTogRepository;

    public OrderTog createOrder(OrderTog orderTog) {
        Optional<BoardTog> boardTog = boardTogRepository.findById(orderTog.getBoardTog().getId());

        boardTog.ifPresent(BoardTog::decreaseCnt);

        return orderTogRepository.save(orderTog);
    }
}
