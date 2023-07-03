package com.hfp.domain.support.domain.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class SupportListResponseDto {

    private Long support_id;

    private LocalDate support_date;

    private int money;

    private String animal_name;

    private String animal_url;

}
