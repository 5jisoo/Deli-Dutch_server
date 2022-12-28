package com.cokothon.DeliDutch.dto;

import com.cokothon.DeliDutch.constant.Dormitory;
import com.cokothon.DeliDutch.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Dormitory dormitory;

    public UserDto toUserDtoEntity() {
        UserDto userDto = UserDto.builder()
                .id(id)
                .username(username)
                .email(email)
                .password(password)
                .dormitory(dormitory)
                .build();

        return userDto;
    }
}
