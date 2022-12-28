package com.cokothon.DeliDutch.entity;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Embedded
    private Address pick_up;

    @Column(name = "open_kakao")
    private String openKakao;

    @Column(name = "board_sep_title")
    private String boardTitle;

    @Column(name = "board_sep_content")
    @Lob
    private String contents;
}
