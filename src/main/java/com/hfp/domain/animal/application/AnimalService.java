package com.hfp.domain.animal.application;

import com.hfp.domain.animal.domain.Animal;
import com.hfp.domain.animal.domain.repository.AnimalRepository;
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
        List<Animal> animals = animalRepository.findAll();

        ApiResponse apiResponse = ApiResponse.builder()
                .check(true)
                .information(animals)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    public ResponseEntity<?> getAnimal(Long animalId) {
        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new DefaultException(ErrorCode.INVALID_CHECK));

        ApiResponse apiResponse = ApiResponse.builder()
                .check(true)
                .information(animal)
                .build();

        return ResponseEntity.ok(apiResponse);
    }
  
}
