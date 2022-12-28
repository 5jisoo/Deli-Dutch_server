package com.cokothon.DeliDutch.service;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.dto.BoardTogDto;
import com.cokothon.DeliDutch.entity.BoardTog;
import com.cokothon.DeliDutch.repository.BoardTogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<BoardTogDto> retrieve(Dormitory dormitory) {
        List<BoardTog> boardTogList = boardTogRepository.findByDormitory(dormitory);
        List<BoardTogDto> retList = new ArrayList<>();
        for (BoardTog boardTog : boardTogList) {
            retList.add(BoardTog.of(boardTog));
        }
        return retList;
    }
}
