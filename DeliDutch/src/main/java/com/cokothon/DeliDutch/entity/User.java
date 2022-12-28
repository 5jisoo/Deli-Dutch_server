package com.cokothon.DeliDutch.entity;

import com.cokothon.DeliDutch.constant.Dormitory;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Dormitory dormitory;


//    public User(String username, String email, String password, Dormitory dormitory) {
//        this.username = username;
//        this.email = email;
//        this.password = password;
//        this.dormitory = dormitory;
//    }

    // 생성 메서드

}

