package com.hfp.domain.animal.dto;

import com.hfp.domain.animal.domain.Gender;
import com.hfp.domain.animal.domain.Species;
import lombok.Data;

@Data
public class PostAnimalReq {
    private Long rescue_id;
    private String name;
    private Gender gender;
    private Species species;
    private String place;
    private Integer age;
    private String description;
    private String bank;
    private String account;
}
