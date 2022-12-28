package com.cokothon.DeliDutch.service;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.dto.BoardSepDto;
import com.cokothon.DeliDutch.dto.BoardTogDto;
import com.cokothon.DeliDutch.dto.FoodDto;
import com.cokothon.DeliDutch.entity.BoardSep;
import com.cokothon.DeliDutch.entity.BoardTog;
import com.cokothon.DeliDutch.entity.Food;
import com.cokothon.DeliDutch.repository.BoardSepRepository;
import com.cokothon.DeliDutch.repository.BoardTogRepository;
import com.cokothon.DeliDutch.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardSepService {
    private final BoardSepRepository boardSepRepository;
    private final FoodRepository foodRepository;

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

    public List<FoodDto> showFoodList(Long boardSepId) {
        BoardSep boardSep = boardSepRepository.findById(boardSepId).get();
        List<Food> foodList = foodRepository.findFoodList(boardSep.getRestaurant().getId());
        List<FoodDto> dtoList = new ArrayList<>();
        for (Food food : foodList) {
            dtoList.add(Food.of(food));
        }
        return dtoList;
    }
}
