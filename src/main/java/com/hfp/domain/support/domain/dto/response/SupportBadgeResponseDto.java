package com.hfp.domain.support.domain.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SupportBadgeResponseDto {

    private List<Integer> badge_list;

    private List<SupportListResponseDto> support_list;
}
