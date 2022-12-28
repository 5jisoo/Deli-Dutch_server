package com.cokothon.DeliDutch.entity;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(name = "food_name")
    private String name;

    @Column
    private int price;
}

