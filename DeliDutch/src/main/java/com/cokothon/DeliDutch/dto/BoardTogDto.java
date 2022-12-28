package com.cokothon.DeliDutch.dto;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.entity.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class BoardTogDto {

    private Long id;
    private Long host_id;       // 게시판 만든 사용자 아이디
    private String food_name;   // 음식 이름
    private int recruits_cnt;   // 정원

    @DateTimeFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss")
    private LocalDateTime end_time;
    private String pick_up;
    private String openKakao;
    private Dormitory dormitory;

    public BoardTogDto(BoardTog boardTog) {
        this.id = boardTog.getId();
        this.host_id = boardTog.getCreated_by().getId();
        this.food_name = boardTog.getFood().getName();
        this.recruits_cnt = boardTog.getRecruits_cnt();
        this.end_time = boardTog.getEndTime();
        this.pick_up = boardTog.getPick_up();
        this.openKakao = boardTog.getOpenKakao();
        this.dormitory = boardTog.getDormitory();
    }
}
