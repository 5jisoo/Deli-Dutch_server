package com.cokothon.DeliDutch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Board_Together {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JoinColumn(name = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private User created_by;

    @JoinColumn(name = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Food food_id;

    @Column
    private int recruits_cnt;

    @Column
    private String pick_up;

    @Column
    private String open_kakao;

}
