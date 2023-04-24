package dev.com.bedev.api.user.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserInfo;
import dev.com.bedev.api.user.dto.request.UserRequestDto;
import dev.com.bedev.api.user.dto.response.UserResponseDto;
import dev.com.bedev.api.user.service.UserService;
import dev.com.bedev.api.util.RequestUtil;
import dev.com.bedev.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class UserController {

    private final FirebaseAuth firebaseAuth;

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<?> register(@RequestHeader("Authorization") String authorization,
                             @RequestBody UserRequestDto requestDto) {
        // TOKEN을 가져온다.
        FirebaseToken decodedToken;
        try {
            String token = RequestUtil.getAuthorizationToken(authorization);
            decodedToken = firebaseAuth.verifyIdToken(token);
        } catch (IllegalArgumentException | FirebaseAuthException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                    "{\"code\":\"INVALID_TOKEN\", \"message\":\"" + e.getMessage() + "\"}");
        }
        // 사용자를 등록한다.
        User registeredUser = userService.register(
                decodedToken.getUid(), decodedToken.getEmail(), requestDto.getNickname());

        UserResponseDto userInfo = UserResponseDto.from(registeredUser);
        return ResponseEntity.ok().body(userInfo);
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponseDto>  getUserMe(Authentication authentication) {
        User customUser = ((User) authentication.getPrincipal());
        UserResponseDto userInfo = UserResponseDto.from(customUser);
        return ResponseEntity.ok().body(userInfo);
    }
}
