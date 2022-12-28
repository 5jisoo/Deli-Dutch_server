package com.cokothon.DeliDutch.controller;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.dto.BoardTogDto;
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

            List<BoardTog> entities = boardTogService.retrieve(tempDormitory);

            List<BoardTogDto> dtos = entities.stream().map(BoardTogDto::new).collect(Collectors.toList());

            ResponseDTO<BoardTogDto> response = ResponseDTO.<BoardTogDto>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            String error = e.getMessage();
            return ResponseEntity.badRequest().body(error);
        }
    }

    @PostMapping
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
