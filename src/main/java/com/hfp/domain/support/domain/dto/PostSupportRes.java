package com.hfp.domain.support.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class PostSupportRes {
    private Long support_id;
    private Long animal_id;
    private Long sponsor_id;
    private Long rescue_id;
    private Integer money;
    private LocalDate support_date;

//    @Builder
//    public PostSupportRes(Long support_id, Long animal_id, Long sponsor_id, Long rescue_id, Integer money, LocalDate support_date){
//        this.support_id = support_id;
//        this.animal_id = animal_id;
//        this.sponsor_id = sponsor_id;
//        this.rescue_id = rescue_id;
//        this.money = money;
//        this.support_date = support_date;
//    }
}
