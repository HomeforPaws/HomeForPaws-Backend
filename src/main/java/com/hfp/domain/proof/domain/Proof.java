package com.hfp.domain.proof.domain;

import com.hfp.domain.animal.domain.Animal;
import com.hfp.domain.common.BaseEntity;
import com.hfp.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Proof extends BaseEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proof_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id")
    private Animal supportedAnimal;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rescue_id")
    private User rescueUser;

    @Column(nullable = false)
    private String proof_url;

    @Column(nullable = false)
    private String recent_url;

    @Column(nullable = false)
    private String description;
}
