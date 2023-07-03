package com.hfp.domain.user.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class GetUsersRes {

    private String name;
    private String nickname;
    private String phone;
    private String email;

    @Builder

    public GetUsersRes(String name, String nickname, String phone, String email) {
        this.name = name;
        this.nickname = nickname;
        this.phone = phone;
        this.email = email;
    }
}
