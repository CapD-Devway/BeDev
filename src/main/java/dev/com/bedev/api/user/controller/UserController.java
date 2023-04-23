package dev.com.bedev.api.user.controller;

import dev.com.bedev.api.user.dto.request.UserRequestDto;
import dev.com.bedev.api.user.dto.response.UserResponseDto;
import dev.com.bedev.api.user.service.UserService;
import dev.com.bedev.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class UserController {

    private final UserService userService;

    @PostMapping("/singup")
    public ResponseEntity<?> signUp(@RequestBody UserRequestDto userRequestDto){
        User user = userService.signup(userRequestDto);
        UserResponseDto userResponseDto = UserResponseDto.builder()
                .build();
        return ResponseEntity.ok().body(userResponseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> signIn(){
        return ResponseEntity.ok().body("");
    }
}
