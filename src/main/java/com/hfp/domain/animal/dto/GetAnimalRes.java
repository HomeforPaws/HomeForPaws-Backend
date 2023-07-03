package com.hfp.domain.animal.dto;

import com.hfp.domain.animal.domain.Gender;
import com.hfp.domain.animal.domain.Species;
import com.hfp.domain.user.domain.Users;
import lombok.Builder;
import lombok.Data;

@Data
public class GetAnimalRes {
    private Long animal_id;
    private Long rescue_id;
    private String name;
    private Species species;
    private Gender gender;
    private String image_url;
    private String place;
    private Integer age;
    private String description;

    @Builder

    public GetAnimalRes(Long animal_id, Long rescue_id, String name, Species species, Gender gender, String image_url, String place, Integer age, String description) {
        this.animal_id = animal_id;
        this.rescue_id = rescue_id;
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.image_url = image_url;
        this.place = place;
        this.age = age;
        this.description = description;
    }
}
