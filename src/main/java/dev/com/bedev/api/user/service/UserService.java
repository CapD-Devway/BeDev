package dev.com.bedev.api.user.service;

import dev.com.bedev.api.user.dto.response.UserResponseDto;
import dev.com.bedev.domain.user.User;
import dev.com.bedev.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;



    @Transactional
    public User register(String uid, String email,String picture,String name) {
        User customUser = User.builder()
                .userName(name)
                .email(email)
                .picture(picture)
                .id(uid)
                .build();
        userRepository.save(customUser);
        return customUser;
    }
}
