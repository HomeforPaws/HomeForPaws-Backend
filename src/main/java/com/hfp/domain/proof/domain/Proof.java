package com.hfp.domain.proof.domain;

import com.hfp.domain.animal.domain.Animal;
import com.hfp.domain.common.BaseEntity;
import com.hfp.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Proof extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
