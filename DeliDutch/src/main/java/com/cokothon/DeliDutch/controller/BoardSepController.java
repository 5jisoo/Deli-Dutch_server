package com.cokothon.DeliDutch.controller;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.dto.BoardSepDto;
import com.cokothon.DeliDutch.dto.BoardTogDto;
import com.cokothon.DeliDutch.dto.ResponseDTO;
import com.cokothon.DeliDutch.entity.BoardSep;
import com.cokothon.DeliDutch.entity.BoardTog;
import com.cokothon.DeliDutch.repository.FoodRepository;
import com.cokothon.DeliDutch.repository.RestaurantRepository;
import com.cokothon.DeliDutch.repository.UserRepository;
import com.cokothon.DeliDutch.service.BoardSepService;
import com.cokothon.DeliDutch.service.BoardTogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardSepController {

    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final BoardSepService boardSepService;

    @GetMapping("/api/v1/boardSep")
    public ResponseEntity<?> retrieveBoardSepList() {
        try {
            Dormitory tempDormitory = Dormitory.KOOKMIN;

            List<BoardSepDto> dtos = boardSepService.retrieve(tempDormitory);

            ResponseDTO<BoardSepDto> response = ResponseDTO.<BoardSepDto>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            String error = e.getMessage();
            return ResponseEntity.badRequest().body(error);
        }
    }

    @PostMapping("/api/v1/boardSep")
    public BoardSepDto create(@RequestBody BoardSepDto boardSepDto) {
        BoardSep entity = BoardSep.builder()
                .user(userRepository.findById(boardSepDto.getHost_id()).get())
                .restaurant(restaurantRepository.findById(boardSepDto.getRestaurant_id()).get())
                .endTime(boardSepDto.getEnd_time())
                .openKakao(boardSepDto.getOpenKakao())
                .pick_up(boardSepDto.getPick_up())
                .boardTitle(boardSepDto.getBoard_title())
                .dormitory(boardSepDto.getDormitory()).build();

        return new BoardSepDto(boardSepService.save(entity));
    }
}
