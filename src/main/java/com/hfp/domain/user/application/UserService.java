package com.hfp.domain.user.application;

import com.hfp.domain.animal.domain.Animal;
import com.hfp.domain.animal.dto.GetAnimalRes;
import com.hfp.domain.user.domain.Users;
import com.hfp.domain.user.domain.dto.GetUsersRes;
import com.hfp.domain.user.domain.repository.UserRepository;
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
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    //회원 전체 조회
    public List<Users> findUsers() {
        return userRepository.findAll();
    }


    public ResponseEntity<?> getUser(Long userId) {
        Users users = userRepository.findById(userId)
                .orElseThrow(() -> new DefaultException(ErrorCode.INVALID_CHECK));

        ApiResponse apiResponse = ApiResponse.builder()
                .check(true)
                .information(GetUsersRes.builder()
                        .name(users.getName())
                        .nickname(users.getNickname())
                        .phone(users.getPhone())
                        .email(users.getEmail()))
                .build();

        return ResponseEntity.ok(apiResponse);
    }
}
