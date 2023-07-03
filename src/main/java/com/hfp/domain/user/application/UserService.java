package com.hfp.domain.user.application;

import com.hfp.domain.user.domain.Users;
import com.hfp.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(Users users) {

        validateDuplicateUsers(users); //중복 회원 검증
        userRepository.save(users);
        return users.getId();
    }

    private void validateDuplicateUsers(Users users) {
        Optional<Users> findUsers = userRepository.findByEmail(users.getEmail());
        if (!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Users> findUsers() {
        return userRepository.findAll();
    }

    public Optional<Users> findOne(Long userId) {
        return userRepository.findById(userId);
    }
}
