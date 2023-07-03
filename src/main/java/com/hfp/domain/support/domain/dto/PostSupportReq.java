package com.hfp.domain.support.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class PostSupportReq {
    private Long animal_id;
    private Long sponsor_id;
    private Long rescue_id;
    private Integer money;
    private LocalDate support_date;
}
