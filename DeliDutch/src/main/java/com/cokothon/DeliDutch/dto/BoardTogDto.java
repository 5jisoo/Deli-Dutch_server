package com.cokothon.DeliDutch.dto;

import com.cokothon.DeliDutch.entity.Address;
import com.cokothon.DeliDutch.entity.BoardTog;
import com.cokothon.DeliDutch.entity.Food;
import com.cokothon.DeliDutch.entity.User;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class BoardTogDto {

    private Long id;
    private User created_by;
    private Food food_id;
    private int recruits_cnt;
    private Address pick_up;
    private String openKakao;
    private String content;

    public BoardTog toBoardTogEntity() {
        BoardTog boardTog = BoardTog.builder()
                .id(id)
                .created_by(created_by)
                .food_id(food_id)
                .recruits_cnt(recruits_cnt)
                .pick_up(pick_up)
                .openKakao(openKakao)
                .content(content)
                .build();

        return boardTog;
    }
}
