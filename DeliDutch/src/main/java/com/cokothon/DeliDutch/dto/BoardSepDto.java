package com.cokothon.DeliDutch.dto;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.entity.BoardSep;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardSepDto {
    private Long id;

    private Long host_id;

    private Long restaurant_id;

    @DateTimeFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss")
    private LocalDateTime end_time;

    private String pick_up;

    private String openKakao;

    private String board_title;

    private Dormitory dormitory;

    public BoardSepDto(BoardSep boardSep) {
        this.id = boardSep.getId();
        this.host_id = boardSep.getUser().getId();
        this.restaurant_id = boardSep.getRestaurant().getId();
        this.end_time = boardSep.getEndTime();
        this.pick_up = boardSep.getPick_up();
        this.openKakao = boardSep.getOpenKakao();
        this.board_title = boardSep.getBoardTitle();
        this.dormitory = boardSep.getDormitory();
    }
}
