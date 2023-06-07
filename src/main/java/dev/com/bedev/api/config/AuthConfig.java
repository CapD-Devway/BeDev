package dev.com.bedev.api.config;

import com.google.firebase.auth.FirebaseAuth;
import dev.com.bedev.api.filter.AuthFilterContainer;
import dev.com.bedev.api.filter.JwtFilter;
import dev.com.bedev.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class AuthConfig {

    private final UserService userService;

    private final FirebaseAuth firebaseAuth;



    @Bean
    public AuthFilterContainer firebaseAuthFilter() {
        log.info("Initializing Firebase AuthFilter");
        AuthFilterContainer authFilterContainer = new AuthFilterContainer();
        authFilterContainer.setAuthFilter(new JwtFilter(userService, firebaseAuth));
        return authFilterContainer;
    }
}