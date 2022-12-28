package com.cokothon.DeliDutch.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "Food_ID")
    private final Restaurant restaurant;

    @Column
    private final String name;

    @Column
    private final int price;
}
