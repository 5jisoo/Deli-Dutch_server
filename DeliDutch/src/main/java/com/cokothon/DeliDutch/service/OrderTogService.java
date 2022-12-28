package com.cokothon.DeliDutch.service;

import com.cokothon.DeliDutch.entity.BoardTog;
import com.cokothon.DeliDutch.entity.OrderTog;
import com.cokothon.DeliDutch.repository.BoardTogRepository;
import com.cokothon.DeliDutch.repository.OrderTogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderTogService {
    private final OrderTogRepository orderTogRepository;
    private final BoardTogRepository boardTogRepository;

    public OrderTog sendOrder(OrderTog orderTog) {
        BoardTog boardTog = orderTog.getBoardTog();
        boardTog.setRecruits_cnt(boardTog.getRecruits_cnt() - 1);

//        BoardTog boardTog1 = boardTogRepository.findById(orderTog.getBoardTog().getId()).get();
//        boardTog1.setRecruits_cnt(boardTog1.getRecruits_cnt()-1);

        return orderTogRepository.save(orderTog);
    }
}
