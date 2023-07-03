package com.hfp.domain.proof.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Proof {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proof_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id")
    private Long animal_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rescue_id")
    private Long rescue_id;

    @Column(nullable = false)
    private String proof_url;

    @Column(nullable = false)
    private String recent_url;

    @Column(nullable = false)
    private String description;
}
