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
public class Order_Together {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private User join_user_id;

    @ManyToOne
    @JoinColumn(name = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Board_Together board_id;
}
