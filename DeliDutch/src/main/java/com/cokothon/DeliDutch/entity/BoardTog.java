package com.cokothon.DeliDutch.entity;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.dto.BoardTogDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class BoardTog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_tog_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User created_by;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    @Column
    private int recruits_cnt;

    @Column
    private String pick_up;

    @Column(name = "open_kakao")
    private String openKakao;

    @Column
    private String content;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private Dormitory dormitory;

    public static BoardTogDto of(BoardTog boardTog) {
        return BoardTogDto.builder()
                .id(boardTog.getId())
                .dormitory(boardTog.getDormitory())
                .openKakao(boardTog.getOpenKakao())
                .pick_up(boardTog.getPick_up())
                .recruits_cnt(boardTog.getRecruits_cnt())
                .end_time(boardTog.getEndTime())
                .host_id(boardTog.getCreated_by().getId())
                .food_name(boardTog.getFood().getName())
                .build();
    }
}
