package com.cokothon.DeliDutch.service;

import com.cokothon.DeliDutch.dto.OrderSepDto;
import com.cokothon.DeliDutch.entity.OrderSep;
import com.cokothon.DeliDutch.repository.OrderSepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderSepService {
    private final OrderSepRepository orderSepRepository;

    public OrderSep sendOrder(OrderSep orderSep) {
        return orderSepRepository.save(orderSep);
    }
}
