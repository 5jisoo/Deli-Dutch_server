package com.cokothon.DeliDutch.dto;

import com.cokothon.DeliDutch.constant.Dormitory;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class BoardTogFormDto {
    private Long id;

    private Long host_id;           // 게시판 만든 사용자 아이디
    private Long food_id;           // 음식 이름
    private int recruits_cnt;

    private LocalDateTime end_time;
    private String pick_up;
    private String openKakao;
    private Dormitory dormitory;
    private String content;
}
