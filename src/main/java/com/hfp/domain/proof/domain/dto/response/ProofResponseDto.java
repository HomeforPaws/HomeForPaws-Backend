package com.hfp.domain.proof.domain.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProofResponseDto {

    private Long proof_id;

    private String animal_name;

    private String proof_url;

    private String recent_url;

    private String description;
}
