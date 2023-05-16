package dev.com.bedev.api.config;


import com.google.firebase.auth.FirebaseAuth;

import dev.com.bedev.api.filter.JwtFilter;
import dev.com.bedev.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final FirebaseAuth firebaseAuth;
    private final UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                httpBasic().disable()
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers("/login","/").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JwtFilter(userService, firebaseAuth), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }




}
