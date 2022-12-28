package com.cokothon.DeliDutch.dto;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.entity.*;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class BoardTogDto {

    private Long id;
    private User created_by;
    private Food food_id;
    private int recruits_cnt;
    private String pick_up;
    private String openKakao;
    private String content;

    private Dormitory dormitory;

    public BoardTogDto(BoardTog boardTog) {
        this.id = boardTog.getId();
        this.created_by = boardTog.getCreated_by();
        this.food_id = boardTog.getFood_id();
        this.recruits_cnt = boardTog.getRecruits_cnt();
        this.pick_up = boardTog.getPick_up();
        this.openKakao = boardTog.getOpenKakao();
        this.content = boardTog.getContent();
        this.dormitory = boardTog.getDormitory();
    }

    public BoardTog toBoardTogEntity(BoardTogDto boardTogDto) {
        BoardTog boardTog = BoardTog.builder()
                .id(boardTogDto.getId())
                .created_by(boardTogDto.getCreated_by())
                .food_id(boardTogDto.getFood_id())
                .recruits_cnt(boardTogDto.getRecruits_cnt())
                .pick_up(boardTogDto.getPick_up())
                .openKakao(boardTogDto.getOpenKakao())
                .content(boardTogDto.getContent())
                .dormitory(boardTogDto.getDormitory())
                .build();

        return boardTog;
    }
}
