package com.hfp.domain.user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String name;
    private String nickname;
    private String phone;
    private String email;
}
