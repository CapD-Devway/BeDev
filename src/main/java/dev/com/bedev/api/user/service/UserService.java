package dev.com.bedev.api.user.service;

import dev.com.bedev.domain.user.User;
import dev.com.bedev.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException  {
        log.info("ClubUserDetailsService loadUserByUsername"+userId);
        return null;
    }



    @Transactional
    public User register(String uid, String email,String picture) {
        User customUser = User.builder()
                .uid(uid)
                .email(email)
                .picture(picture)
                .build();
        userRepository.save(customUser);
        return customUser;
    }

    @Transactional     public List<User> findall(){
        return userRepository.findAll();
    }

}
