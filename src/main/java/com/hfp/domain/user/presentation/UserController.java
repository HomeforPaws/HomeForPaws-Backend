package com.hfp.domain.user.presentation;

import com.hfp.domain.user.application.UserService;
import com.hfp.domain.user.domain.User;
import com.hfp.domain.user.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{userId}")
    public Result getUser(@PathVariable Long userId) {

        Optional<User> findUser = userService.findOne(userId);
        //엔티티 -> DTO 변환
        User result = (User) findUser.stream()
                .map(m -> new UserDto(m.getName(), m.getNickname(), m.getPhone(), m.getEmail()));

        return new Result(findUser);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

}
