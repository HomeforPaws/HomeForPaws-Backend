package com.hfp.domain.animal.domain;

import com.hfp.domain.common.BaseEntity;
import com.hfp.domain.user.domain.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Animal extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rescue_id")
    private Users rescueUsers;

    private String name;

    @Enumerated(EnumType.STRING)
    private Species species;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String image_url;

    private String place;

    private Integer age;

    private String description;

    private String bank;

    private String account;

    @Builder
    public Animal(Users rescueUsers, String name, Species species, Gender gender, String image_url, String place, Integer age, String description, String bank, String account) {
        this.rescueUsers = rescueUsers;
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.image_url = image_url;
        this.place = place;
        this.age = age;
        this.description = description;
        this.bank = bank;
        this.account = account;
    }

}
