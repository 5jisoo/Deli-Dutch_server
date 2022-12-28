package com.cokothon.DeliDutch.controller;

import com.cokothon.DeliDutch.dto.BoardTogDto;
import com.cokothon.DeliDutch.entity.BoardTog;
import com.cokothon.DeliDutch.repository.BoardTogRepository;
import com.cokothon.DeliDutch.repository.FoodRepository;
import com.cokothon.DeliDutch.repository.UserRepository;
import com.cokothon.DeliDutch.service.BoardTogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardTogController {
    private final UserRepository userRepository;
    private final FoodRepository foodRepository;
    private final BoardTogService boardTogService;
    @PostMapping("/api/v1/boardTog")
    public BoardTogDto create(@RequestBody BoardTogDto boardTogDto) {
        BoardTog entity = BoardTog.builder()
                .created_by(userRepository.findById(boardTogDto.getHost_id()).get())
                .food(foodRepository.findById(boardTogDto.getFood_id()).get())
                .recruits_cnt(boardTogDto.getRecruits_cnt())
                .pick_up(boardTogDto.getPick_up())
                .openKakao(boardTogDto.getOpenKakao())
                .dormitory(boardTogDto.getDormitory()).build();

        return new BoardTogDto(boardTogService.save(entity));
    }

}
