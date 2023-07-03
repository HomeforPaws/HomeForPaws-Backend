package com.hfp.domain.animal.application;

import com.hfp.domain.animal.domain.Animal;
import com.hfp.domain.animal.domain.repository.AnimalRepository;
import com.hfp.domain.animal.dto.GetAnimalRes;
import com.hfp.domain.animal.dto.PostAnimalReq;
import com.hfp.domain.user.domain.User;
import com.hfp.domain.user.domain.repository.UserRepository;
import com.hfp.global.error.DefaultException;
import com.hfp.global.infrastructure.S3Uploader;
import com.hfp.global.payload.ApiResponse;
import com.hfp.global.payload.ErrorCode;
import com.hfp.global.payload.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final UserRepository userRepository;
    private final S3Uploader s3Uploader;

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
                        .description(animal.getDescription())
                        .build())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @Transactional
    public ResponseEntity<?> postAnimal(PostAnimalReq postAnimalReq, MultipartFile image) throws IOException {

        User user = userRepository.findById(postAnimalReq.getRescue_id())
                .orElseThrow(() -> new DefaultException(ErrorCode.INVALID_CHECK));

        Animal animal = Animal.builder()
                .rescueUser(user)
                .name(postAnimalReq.getName())
                .species(postAnimalReq.getSpecies())
                .gender(postAnimalReq.getGender())
                .place(postAnimalReq.getPlace())
                .age(postAnimalReq.getAge())
                .description(postAnimalReq.getDescription())
                .bank(postAnimalReq.getBank())
                .account(postAnimalReq.getAccount())
                .build();

        // img가 비어있는지 체크
        // 업로드할 디렉토리 이름 설정 (record의 이미지는 record_img, 프로필의 이미지는 profile_img
        if (image != null) {
            String storedFileName = s3Uploader.upload(image, "animal_image");
            animal.updateImageUrl(storedFileName);
        }

        animalRepository.save(animal);

        ApiResponse apiResponse = ApiResponse.builder()
                .check(true)
                .information(Message.builder().message("유기동물이 등록되었습니다.").build())
                .build();

        return ResponseEntity.ok(apiResponse);
    }
}
