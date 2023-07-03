package com.hfp.domain.animal.presentation;

import com.hfp.domain.animal.application.AnimalService;
import com.hfp.domain.animal.dto.PostAnimalReq;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/animal")
public class AnimalController {

    private final AnimalService animalService;

    @GetMapping("/list")
    public ResponseEntity<?> getAnimalList() {
        return animalService.getAnimalList();
    }

    @GetMapping("/{animalId}")
    public ResponseEntity<?> getAnimal(
            @PathVariable("animalId") Long animalId) {
        return animalService.getAnimal(animalId);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> postAnimal(
            @Valid @RequestPart("postAnimalReq")PostAnimalReq postAnimalReq,
            @RequestPart(value = "image", required = false) MultipartFile image
            )throws IOException {
        return animalService.postAnimal(postAnimalReq, image);
    }
}
