package dev.com.bedev.api.user.service;

import dev.com.bedev.api.user.dto.request.UserRequestDto;
import dev.com.bedev.domain.user.User;
import dev.com.bedev.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User signup(UserRequestDto userRequestDto){
        User user = User.builder()
                .name("1")
                .email("2")
                .build();
        return user;

    }
}
