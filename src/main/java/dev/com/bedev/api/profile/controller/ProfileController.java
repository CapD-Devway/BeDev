package dev.com.bedev.api.profile.controller;

import dev.com.bedev.api.profile.service.ProfileService;
import dev.com.bedev.api.profile.dto.request.ProfileRequestDto;
import dev.com.bedev.api.profile.dto.response.ProfileResponseDto;
import dev.com.bedev.api.profile.service.UploadFileService;
import dev.com.bedev.domain.enums.DevelopmentPart;
import dev.com.bedev.domain.profile.Profile;
import dev.com.bedev.domain.uploadfile.UploadFile;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ProfileController {

    private final ProfileService profileService;
    private final UploadFileService uploadFileService;

    @PostMapping("/api/profile")
    public ResponseEntity<?> createProfile(@Valid @ModelAttribute ProfileRequestDto profileRequestDto)throws Exception{
        UploadFile uploadFile = uploadFileService.addUploadFile(profileRequestDto.getImage());
        Profile profile = profileService.createProfile(profileRequestDto,uploadFile);
        ProfileResponseDto profileResponseDto = ProfileResponseDto.from(profile);

        return ResponseEntity.ok().body(profileResponseDto);
    }

//    @PutMapping("/api/profile/{id}")
//    public ResponseEntity<?> updateProfile(@ModelAttribute ProfileRequestDto profileRequestDto) throws Exception {
//
//        return ResponseEntity.ok().body(profileResponseDto);
//    }

    @GetMapping("/api/profile")
    public ResponseEntity<?> viewProfile(){
        List<Profile> profiles = profileService.view();
        return ResponseEntity.ok().body(profiles);
    }
}
