package com.hfp.domain.animal.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User {
    @Id
    @Column(name = "users_id")
    private Long id;

    private String name;

    private String nickname;
    private String phone;
    private String email;
}
