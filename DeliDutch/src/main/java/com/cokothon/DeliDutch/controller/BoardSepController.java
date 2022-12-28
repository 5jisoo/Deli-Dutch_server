package com.cokothon.DeliDutch.controller;

import com.cokothon.DeliDutch.dto.BoardSepDto;
import com.cokothon.DeliDutch.dto.BoardTogDto;
import com.cokothon.DeliDutch.entity.BoardSep;
import com.cokothon.DeliDutch.entity.BoardTog;
import com.cokothon.DeliDutch.repository.FoodRepository;
import com.cokothon.DeliDutch.repository.RestaurantRepository;
import com.cokothon.DeliDutch.repository.UserRepository;
import com.cokothon.DeliDutch.service.BoardSepService;
import com.cokothon.DeliDutch.service.BoardTogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class BoardSepController {

    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final BoardSepService boardSepService;

    @PostMapping("/api/v1/boardSep")
    public BoardSepDto create(@RequestBody BoardSepDto boardSepDto) {
        BoardSep entity = BoardSep.builder()
                .user(userRepository.findById(boardSepDto.getHost_id()).get())
                .restaurant(restaurantRepository.findById(boardSepDto.getRestaurant_id()).get())
                .endTime(boardSepDto.getEnd_time())
                .openKakao(boardSepDto.getOpenKakako())
                .pick_up(boardSepDto.getPick_up())
                .boardTitle(boardSepDto.getBoard_title())
                .dormitory(boardSepDto.getDormitory()).build();

        return new BoardSepDto(boardSepService.save(entity));
    }

}
