package com.cokothon.DeliDutch.dto;

import com.cokothon.DeliDutch.entity.BoardSep;
import com.cokothon.DeliDutch.entity.Food;
import com.cokothon.DeliDutch.entity.OrderSep;
import com.cokothon.DeliDutch.entity.User;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class OrderSepDto {
    private Long id;

    private Long boardSep_id;

    private Long joinUser_id;

    private Long food_id;

    public OrderSepDto (OrderSep orderSep) {
        this.id = orderSep.getId();
        this.boardSep_id = orderSep.getBoardSep().getId();
        this.joinUser_id = orderSep.getJoinUser().getId();
        this.food_id = orderSep.getFood().getId();
    }
}
