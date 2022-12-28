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

    private User host;

    private Restaurant restaurant;

    private LocalDateTime end_time;

    private String pick_up;

    private String openKakako;

    private String board_title;

    private String content;

    private Dormitory dormitory;

    public BoardSepDto(BoardSep boardSep) {
        this.id = boardSep.getId();
        this.host = boardSep.getUser();
        this.restaurant = boardSep.getRestaurant();
        this.end_time = boardSep.getEndTime();
        this.pick_up = boardSep.getPick_up();
        this.openKakako = boardSep.getOpenKakao();
        this.board_title = boardSep.getBoardTitle();
        this.content = boardSep.getContents();
        this.dormitory = boardSep.getDormitory();
    }

    public static BoardSep toEntity(final BoardSepDto boardSepDto) {
        return BoardSep.builder()
                .id(boardSepDto.getId())
                .boardTitle(boardSepDto.getBoard_title())
                .user(boardSepDto.getHost())
                .restaurant(boardSepDto.getRestaurant())
                .endTime(boardSepDto.getEnd_time())
                .pick_up(boardSepDto.getPick_up())
                .openKakao(boardSepDto.getOpenKakako())
                .contents(boardSepDto.getContent())
                .dormitory(boardSepDto.getDormitory())
                .build();
    }
}
