package com.cokothon.DeliDutch.controller;

import com.cokothon.DeliDutch.dto.OrderSepDto;
import com.cokothon.DeliDutch.dto.OrderTogDto;
import com.cokothon.DeliDutch.entity.OrderSep;
import com.cokothon.DeliDutch.entity.OrderTog;
import com.cokothon.DeliDutch.repository.BoardSepRepository;
import com.cokothon.DeliDutch.repository.FoodRepository;
import com.cokothon.DeliDutch.repository.OrderSepRepository;
import com.cokothon.DeliDutch.repository.UserRepository;
import com.cokothon.DeliDutch.service.OrderSepService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderSepController {
    private final FoodRepository foodRepository;
    private final UserRepository userRepository;
    private final BoardSepRepository boardSepRepository;
    private final OrderSepService orderSepService;

    @PostMapping("/api/v1/orderSep")
    public OrderSepDto makeOrder(@RequestBody OrderSepDto orderSepDto) {
        OrderSep orderSep = OrderSep.builder()
                .boardSep(boardSepRepository.findById(orderSepDto.getBoardSep_id()).get())
                .food(foodRepository.findById(orderSepDto.getFood_id()).get())
                .joinUser(userRepository.findById(orderSepDto.getJoinUser_id()).get()).build();

        return new OrderSepDto(orderSepService.sendOrder(orderSep));
    }
}
