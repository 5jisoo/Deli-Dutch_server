package com.cokothon.DeliDutch.service;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.dto.BoardSepDto;
import com.cokothon.DeliDutch.dto.BoardTogDto;
import com.cokothon.DeliDutch.entity.BoardSep;
import com.cokothon.DeliDutch.entity.BoardTog;
import com.cokothon.DeliDutch.repository.BoardSepRepository;
import com.cokothon.DeliDutch.repository.BoardTogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardSepService {
    private final BoardSepRepository boardSepRepository;

    public BoardSep save(BoardSep boardSep) {
        return boardSepRepository.save(boardSep);
    }

    @Transactional(readOnly = true)
    public List<BoardSepDto> retrieve(Dormitory dormitory) {
        List<BoardSep> boardSepList = boardSepRepository.findBoardSepList(dormitory.name());
        List<BoardSepDto> setList = new ArrayList<>();
        for (BoardSep boardSep : boardSepList) {
            setList.add(BoardSep.of(boardSep));
        }
        return setList;
    }
}
