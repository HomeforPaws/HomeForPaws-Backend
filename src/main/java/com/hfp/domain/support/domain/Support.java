package com.hfp.domain.support.domain;

import com.hfp.domain.animal.domain.Animal;
import com.hfp.domain.common.BaseEntity;
import com.hfp.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Table(name="Support")
@Entity
public class Support extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="animal_id")
    private Animal supportAnimal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sponsor_id")
    private User sponsorUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="resque_id")
    private User rescueUser;

    @Column(nullable = false)
    private Integer money;

    @Column(nullable = false)
    private LocalDate support_date;
}
