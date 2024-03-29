package com.hfp.domain.proof.domain.repository;

import com.hfp.domain.animal.domain.Animal;
import com.hfp.domain.proof.domain.Proof;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProofRepository extends JpaRepository<Proof, Long> {

    Optional<Proof> findBySupportedAnimal(Animal supportedAnimal);
}
