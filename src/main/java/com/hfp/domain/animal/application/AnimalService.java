package com.hfp.domain.animal.application;

import com.hfp.domain.animal.domain.Animal;
import com.hfp.domain.animal.domain.repository.AnimalRepository;
import com.hfp.domain.animal.dto.GetAnimalRes;
import com.hfp.global.error.DefaultException;
import com.hfp.global.payload.ApiResponse;
import com.hfp.global.payload.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AnimalService {

    private final AnimalRepository animalRepository;

    public ResponseEntity<?> getAnimalList() {
        List<Animal> findAnimals = animalRepository.findAll();

        List<GetAnimalRes> animalRes = findAnimals.stream()
                .map(animal -> GetAnimalRes.builder()
                        .animal_id(animal.getId())
                        .rescue_id(animal.getRescueUser().getId())
                        .name(animal.getName())
                        .species(animal.getSpecies())
                        .gender(animal.getGender())
                        .image_url(animal.getImage_url())
                        .place(animal.getPlace())
                        .age(animal.getAge())
                        .description(animal.getDescription())
                        .build())
                .toList();

        ApiResponse apiResponse = ApiResponse.builder()
                .check(true)
                .information(animalRes)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    public ResponseEntity<?> getAnimal(Long animalId) {
        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new DefaultException(ErrorCode.INVALID_CHECK));

        ApiResponse apiResponse = ApiResponse.builder()
                .check(true)
                .information(GetAnimalRes.builder()
                        .animal_id(animal.getId())
                        .rescue_id(animal.getRescueUser().getId())
                        .name(animal.getName())
                        .species(animal.getSpecies())
                        .gender(animal.getGender())
                        .image_url(animal.getImage_url())
                        .place(animal.getPlace())
                        .age(animal.getAge())
                        .description(animal.getDescription()))
                .build();

        return ResponseEntity.ok(apiResponse);
    }
  
}
