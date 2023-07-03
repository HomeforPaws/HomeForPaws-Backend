package com.hfp.domain.proof.application;

import com.hfp.domain.animal.domain.Animal;
import com.hfp.domain.animal.domain.repository.AnimalRepository;
import com.hfp.domain.proof.domain.Proof;
import com.hfp.domain.proof.domain.dto.response.ProofResponseDto;
import com.hfp.domain.proof.domain.repository.ProofRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProofService {

    private final ProofRepository proofRepository;
    private final AnimalRepository animalRepository;

    public ProofResponseDto getProof(Long animal_id) {

        Animal supported_animal = animalRepository.findById(animal_id).orElseThrow(
                () -> new IllegalArgumentException("해당하는 동물 정보를 찾을 수 없습니다.")
        );

        Proof proof = proofRepository.findBySupportedAnimal(supported_animal).orElseThrow(
                () -> new IllegalArgumentException("해당하는 후원 증빙 정보를 찾을 수 없습니다.")
        );

        return ProofResponseDto.builder()
                .proof_id(proof.getId())
                .animal_name(supported_animal.getName())
                .proof_url(proof.getProof_url())
                .recent_url(proof.getRecent_url())
                .description(proof.getDescription())
                .build();
    }
}
