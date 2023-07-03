package com.hfp.domain.user.domain;

import jakarta.persistence.*;

import com.hfp.domain.common.BaseEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "Users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User extends BaseEntity {

    @Id
    @Column(name = "users_id")
    private Long id;

    private String name;
    private String nickname;
    private String phone;
    private String email;


    @Builder
    public User(String name, String nickname, String phone, String email){
        this.name = name;
        this.nickname = nickname;
        this.phone = phone;
        this.email = email;
    }

    public void updateNickname(String nickname){
        this.nickname = nickname;
    }

}
