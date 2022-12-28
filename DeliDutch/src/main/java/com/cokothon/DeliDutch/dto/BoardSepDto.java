package com.cokothon.DeliDutch.dto;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.entity.Address;
import com.cokothon.DeliDutch.entity.BoardSep;
import com.cokothon.DeliDutch.entity.Restaurant;
import com.cokothon.DeliDutch.entity.User;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardSepDto {
    private Long id;

    private Long host_id;

    private Long restaurant_id;

    private LocalDateTime end_time;

    private String pick_up;

    private String openKakako;

    private String board_title;

    private String content;

    private Dormitory dormitory;

    public BoardSepDto(BoardSep boardSep) {
        this.id = boardSep.getId();
        this.host_id = boardSep.getUser().getId();
        this.restaurant_id = boardSep.getRestaurant().getId();
        this.end_time = boardSep.getEndTime();
        this.pick_up = boardSep.getPick_up();
        this.openKakako = boardSep.getOpenKakao();
        this.board_title = boardSep.getBoardTitle();
        this.content = boardSep.getContents();
        this.dormitory = boardSep.getDormitory();
    }
}
