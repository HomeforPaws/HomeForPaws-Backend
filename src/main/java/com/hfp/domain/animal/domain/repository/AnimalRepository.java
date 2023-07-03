package com.hfp.domain.animal.domain.repository;

import com.hfp.domain.animal.domain.Animal;
import com.hfp.domain.animal.domain.Species;
import com.hfp.domain.support.domain.Support;
import com.hfp.domain.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findAnimalBySpecies(Species species);
}
