package com.hfp.domain.animal.presentation;

import com.hfp.domain.animal.application.AnimalService;
import com.hfp.domain.animal.domain.Species;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/animal")
public class AnimalController {

    private final AnimalService animalService;

    @GetMapping("/{species}")
    public ResponseEntity<?> getAnimalBySpecies(@PathVariable Species species) {
        return animalService.getAnimalBySpecies(species);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAnimalList() {
        return animalService.getAnimalList();
    }

    @GetMapping("/{animalId}")
    public ResponseEntity<?> getAnimal(
            @PathVariable("animalId") Long animalId) {
        return animalService.getAnimal(animalId);
    }
  
}
