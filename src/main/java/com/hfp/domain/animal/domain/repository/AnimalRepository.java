package com.hfp.domain.animal.domain.repository;

import com.hfp.domain.animal.domain.Animal;
import com.hfp.domain.animal.domain.Species;
import com.hfp.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    Optional<Animal> findBySpecies(Species species);
}
