package com.cokothon.DeliDutch.controller;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.dto.BoardTogDto;
import com.cokothon.DeliDutch.dto.BoardTogFormDto;
import com.cokothon.DeliDutch.dto.ResponseDTO;
import com.cokothon.DeliDutch.entity.BoardTog;
import com.cokothon.DeliDutch.repository.BoardTogRepository;
import com.cokothon.DeliDutch.repository.FoodRepository;
import com.cokothon.DeliDutch.repository.UserRepository;
import com.cokothon.DeliDutch.service.BoardTogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/boardTog")
@RequiredArgsConstructor
public class BoardTogController {
    private final UserRepository userRepository;
    private final FoodRepository foodRepository;
    private final BoardTogService boardTogService;

    @GetMapping
    public ResponseEntity<?> retrieveBoardTogList() {
        try {
            Dormitory tempDormitory = Dormitory.KOOKMIN;

            List<BoardTogDto> dtos = boardTogService.retrieve(tempDormitory);

            ResponseDTO<BoardTogDto> response = ResponseDTO.<BoardTogDto>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            String error = e.getMessage();
            return ResponseEntity.badRequest().body(error);
        }
    }


    @PostMapping
    public BoardTogDto create(@RequestBody BoardTogFormDto boardTogFormDto) {
        BoardTog entity = BoardTog.builder()
                .created_by(userRepository.findById(boardTogFormDto.getHost_id()).get())
                .food(foodRepository.findById(boardTogFormDto.getFood_id()).get())
                .recruits_cnt(boardTogFormDto.getRecruits_cnt())
                .endTime(boardTogFormDto.getEnd_time())
                .pick_up(boardTogFormDto.getPick_up())
                .openKakao(boardTogFormDto.getOpenKakao())
                .dormitory(boardTogFormDto.getDormitory())
                .content(boardTogFormDto.getContent())
                .build();

        return new BoardTogDto(boardTogService.save(entity));
    }

}
