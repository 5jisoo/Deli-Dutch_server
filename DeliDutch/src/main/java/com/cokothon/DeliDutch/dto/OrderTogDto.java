package com.cokothon.DeliDutch.dto;

import com.cokothon.DeliDutch.entity.OrderSep;
import com.cokothon.DeliDutch.entity.OrderTog;
import lombok.*;

@Data
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
public class OrderTogDto {
    private Long id;

    private Long boardTog_id;

    private Long joinUser_id;

    public OrderTogDto (OrderTog orderTog) {
        this.id = orderTog.getId();
        this.boardTog_id = orderTog.getBoardTog().getId();
        this.joinUser_id = orderTog.getJoinUser().getId();
    }
}
