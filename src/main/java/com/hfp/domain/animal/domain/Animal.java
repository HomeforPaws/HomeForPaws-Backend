package com.hfp.domain.animal.domain;

import com.hfp.domain.common.BaseEntity;
import com.hfp.domain.user.domain.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Animal extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String species;

    private String gender;

    private String image_url;

    private String place;

    private Integer age;

    private String description;

    private String bank;

    private String account;

}
