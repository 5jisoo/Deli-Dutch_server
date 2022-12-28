package com.cokothon.DeliDutch.service;

import com.cokothon.DeliDutch.entity.BoardSep;
import com.cokothon.DeliDutch.entity.BoardTog;
import com.cokothon.DeliDutch.repository.BoardSepRepository;
import com.cokothon.DeliDutch.repository.BoardTogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardSepService {
    private final BoardSepRepository boardSepRepository;

    public BoardSep save(BoardSep boardSep) {
        return boardSepRepository.save(boardSep);
    }
}
