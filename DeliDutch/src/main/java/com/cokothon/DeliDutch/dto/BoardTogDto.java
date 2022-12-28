package com.cokothon.DeliDutch.dto;

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
    private Address pick_up;
    private String openKakao;
    private String content;

    public BoardTogDto(BoardTog boardTog) {
        this.id = boardTog.getId();
        this.created_by = boardTog.getCreated_by();
        this.food_id = boardTog.getFood_id();
        this.recruits_cnt = boardTog.getRecruits_cnt();
        this.pick_up = boardTog.getPick_up();
        this.openKakao = boardTog.getOpenKakao();
        this.content = boardTog.getContent();
    }

    public BoardTog toBoardTogEntity() {
        BoardTog boardTog = BoardTog.builder()
                .id(id)
                .created_by(created_by)
                .food_id(food_id)
                .recruits_cnt(recruits_cnt)
                .pick_up(pick_up)
                .openKakao(openKakao)
                .content(content)
                .build();

        return boardTog;
    }
}
