package com.hfp.domain.animal.application;

import com.hfp.domain.animal.domain.Animal;
import com.hfp.domain.animal.domain.repository.AnimalRepository;
import com.hfp.global.payload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
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

}
