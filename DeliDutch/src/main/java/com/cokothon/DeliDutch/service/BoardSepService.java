package com.cokothon.DeliDutch.service;

import com.cokothon.DeliDutch.repository.BoardSepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardSepService {
    private final BoardSepRepository boardSepRepository;
}
