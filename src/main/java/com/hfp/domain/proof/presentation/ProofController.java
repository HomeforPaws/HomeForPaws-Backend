package com.hfp.domain.proof.presentation;

import com.hfp.domain.proof.application.ProofService;
import com.hfp.domain.proof.domain.dto.response.ProofResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/support")
@RequiredArgsConstructor
public class ProofController {

    private final ProofService proofService;

    @GetMapping("/{animal_id}")
    public ResponseEntity<?> getProof(@PathVariable Long animal_id) {

        ProofResponseDto proofResponseDto = proofService.getProof(animal_id);

        return ResponseEntity.ok(proofResponseDto);
    }
}
