package com.hfp.domain.animal.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class GetAnimalListRes {
    private List<GetAnimalRes> animals;

    @Builder

    public GetAnimalListRes(List<GetAnimalRes> animals) {
        this.animals = animals;
    }
}
