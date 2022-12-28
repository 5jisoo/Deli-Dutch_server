package com.cokothon.DeliDutch.service;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.dto.BoardTogDto;
import com.cokothon.DeliDutch.entity.BoardTog;
import com.cokothon.DeliDutch.repository.BoardTogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardTogService {
    private final BoardTogRepository boardTogRepository;

    public BoardTog save(BoardTog boardTog) {
        return boardTogRepository.save(boardTog);
    }

    @Transactional(readOnly = true)
    public List<BoardTog> retrieve(Dormitory dormitory) {
        return boardTogRepository.findByDormitory(dormitory);
    }
}
