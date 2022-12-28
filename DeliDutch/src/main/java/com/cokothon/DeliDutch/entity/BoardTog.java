package com.cokothon.DeliDutch.entity;

import com.cokothon.DeliDutch.constant.Dormitory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
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

    @Enumerated(EnumType.STRING)
    private Dormitory dormitory;
}
