package com.cokothon.DeliDutch.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long id;

    @OneToMany(mappedBy = "restaurant")
    private List<Food> food = new ArrayList<>();

    @Column
    private String category;
}
