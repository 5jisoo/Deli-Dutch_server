package com.cokothon.DeliDutch.service;

import com.cokothon.DeliDutch.dto.BoardTogDto;
import com.cokothon.DeliDutch.entity.BoardTog;
import com.cokothon.DeliDutch.repository.BoardTogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardTogService {
    private final BoardTogRepository boardTogRepository;

    public BoardTog save(BoardTog boardTog) {
        return boardTogRepository.save(boardTog);
    }


}
