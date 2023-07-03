package com.hfp.domain.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hfp.domain.common.BaseEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import lombok.Builder;
import lombok.Getter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Users extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nickname;
    private String phone;
    private String email;


    @Builder
    public Users(String name, String nickname, String phone, String email){
        this.name = name;
        this.nickname = nickname;
        this.phone = phone;
        this.email = email;
    }

    public void updateNickname(String nickname){
        this.nickname = nickname;
    }

}
