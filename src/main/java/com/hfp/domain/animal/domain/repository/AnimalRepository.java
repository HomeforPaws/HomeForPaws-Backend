package com.hfp.domain.animal.domain.repository;

import com.hfp.domain.animal.domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
