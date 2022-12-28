package com.cokothon.DeliDutch.dto;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.entity.*;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class BoardTogDto {

    private Long id;
    private Long host_id;     // 게시판 만든 사용자 아이디
    private Long food_id;           // 음식 아이디
    private int recruits_cnt;

    private LocalDateTime end_time;
    private String pick_up;
    private String openKakao;
    private Dormitory dormitory;

    public BoardTogDto(BoardTog boardTog) {
        this.id = boardTog.getId();
        this.host_id = boardTog.getCreated_by().getId();
        this.food_id = boardTog.getFood().getId();
        this.recruits_cnt = boardTog.getRecruits_cnt();
        this.pick_up = boardTog.getPick_up();
        this.openKakao = boardTog.getOpenKakao();
        this.dormitory = boardTog.getDormitory();
    }
}
