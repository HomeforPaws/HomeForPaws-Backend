package com.hfp.domain.badge.domain;

import com.hfp.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Badge")
public class Badge extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long badge_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String image_url;

    public Badge(String name, String image_url){
        this.name = name;
        this.image_url = image_url;
    }

}
