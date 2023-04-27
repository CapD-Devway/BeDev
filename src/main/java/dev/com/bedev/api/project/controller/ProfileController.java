package dev.com.bedev.api.project.controller;

import dev.com.bedev.api.project.dto.request.ProfileRequestDto;
import dev.com.bedev.api.project.dto.response.ProfileResponseDto;
import dev.com.bedev.api.project.service.ProfileService;
import dev.com.bedev.domain.profile.Profile;
import dev.com.bedev.domain.project.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/api/profile")
    public ResponseEntity<?> createProfile(@RequestBody ProfileRequestDto profileRequestDto){
        Profile profile = profileService.createProject(profileRequestDto);
        ProfileResponseDto profileResponseDto = ProfileResponseDto.from(profile);
        return ResponseEntity.ok().body(profileResponseDto);

    }

    @GetMapping("/api/profile")
    public ResponseEntity<?> viewProfile(){
        List<Profile> profiles = profileService.view();
        return ResponseEntity.ok().body(profiles);
    }
}
