package com.cokothon.DeliDutch.controller;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.dto.BoardSepDto;
import com.cokothon.DeliDutch.dto.BoardTogDto;
import com.cokothon.DeliDutch.dto.FoodDto;
import com.cokothon.DeliDutch.dto.ResponseDTO;
import com.cokothon.DeliDutch.entity.BoardSep;
import com.cokothon.DeliDutch.entity.BoardTog;
import com.cokothon.DeliDutch.entity.Food;
import com.cokothon.DeliDutch.repository.FoodRepository;
import com.cokothon.DeliDutch.repository.RestaurantRepository;
import com.cokothon.DeliDutch.repository.UserRepository;
import com.cokothon.DeliDutch.service.BoardSepService;
import com.cokothon.DeliDutch.service.BoardTogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BoardSepController {

    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final BoardSepService boardSepService;

    @GetMapping("/api/v1/boardSep")
    public ResponseEntity<?> retrieveBoardSepList(@RequestParam String category) {
        try {
            Dormitory tempDormitory = Dormitory.KOOKMIN;

            log.info("category: {}", category);
            List<BoardSepDto> dtos = boardSepService.retrieve(tempDormitory, category);

            ResponseDTO<BoardSepDto> response = ResponseDTO.<BoardSepDto>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            String error = e.getMessage();
            return ResponseEntity.badRequest().body(error);
        }
    }

    @PostMapping("/api/v1/boardSep")
    public ResponseDTO<BoardSepDto> create(@RequestBody BoardSepDto boardSepDto) {
        BoardSep entity = BoardSep.builder()
                .user(userRepository.findById(boardSepDto.getHost_id()).get())
                .restaurant(restaurantRepository.findById(boardSepDto.getRestaurant_id()).get())
                .endTime(boardSepDto.getEnd_time())
                .openKakao(boardSepDto.getOpenKakao())
                .pick_up(boardSepDto.getPick_up())
                .boardTitle(boardSepDto.getBoard_title())
                .dormitory(boardSepDto.getDormitory()).build();

        BoardSepDto dto = new BoardSepDto(boardSepService.save(entity));
        List<BoardSepDto> dtos = new ArrayList<>();
        dtos.add(dto);

        ResponseDTO<BoardSepDto> response = ResponseDTO.<BoardSepDto>builder().data(dtos).build();

        return response;
    }

    @GetMapping("/api/v1/boardSep/{id}")
    public ResponseDTO<FoodDto> getBoardSepById(@PathVariable("id") long id) {
        List<FoodDto> dtos = boardSepService.showFoodList(id);
        ResponseDTO<FoodDto> response = ResponseDTO.<FoodDto>builder().data(dtos).build();
        return response;
    }
}
