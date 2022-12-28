package com.cokothon.DeliDutch.entity;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.dto.BoardSepDto;
import com.cokothon.DeliDutch.dto.BoardTogDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Board_Separate")
public class BoardSep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_sep_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(name = "pick_up")
    private String pick_up;

    @Column(name = "open_kakao")
    private String openKakao;

    @Column(name = "board_sep_title")
    private String boardTitle;


    @Enumerated(EnumType.STRING)
    private Dormitory dormitory;

    public static BoardSepDto of(BoardSep boardSep) {
        return BoardSepDto.builder()
                .id(boardSep.getId())
                .dormitory(boardSep.getDormitory())
                .openKakao(boardSep.getOpenKakao())
                .pick_up(boardSep.getPick_up())
                .end_time(boardSep.getEndTime())
                .host_id(boardSep.getUser().getId())
                .restaurant_id(boardSep.getRestaurant().getId())
                .board_title(boardSep.getBoardTitle())
                .build();
    }
}
