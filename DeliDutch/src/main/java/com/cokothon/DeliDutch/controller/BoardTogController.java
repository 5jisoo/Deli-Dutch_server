package com.cokothon.DeliDutch.controller;

import com.cokothon.DeliDutch.dto.BoardTogDto;
import com.cokothon.DeliDutch.service.BoardTogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class BoardTogController {

    private final BoardTogService boardTogService;
    @PostMapping("/api/v1/boardTog")
    public long save(@RequestBody BoardTogDto boardTogDto) {
        return boardTogService.save(boardTogDto);
    }

}
