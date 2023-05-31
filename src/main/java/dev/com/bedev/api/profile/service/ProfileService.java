package dev.com.bedev.api.profile.service;

import dev.com.bedev.api.profile.dto.request.ProfileRequestDto;
import dev.com.bedev.domain.profile.Profile;
import dev.com.bedev.domain.profile.ProfileRepository;
import dev.com.bedev.domain.uploadfile.UploadFile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;


    public Profile createProfile(ProfileRequestDto profileRequestDto, UploadFile uploadFile) {
        Profile result = Profile.builder()
                .department(profileRequestDto.getDepartment())
                .introduce(profileRequestDto.getIntroduce())
                .name(profileRequestDto.getName())
                .developmentPart(profileRequestDto.getDevelopmentPart())
                .developTool(profileRequestDto.getDevelopTool())
                .email(profileRequestDto.getEmail())
                .schoolId(profileRequestDto.getSchoolId())
                .image(uploadFile)
                .build();
        return profileRepository.save(result);
    }



    public List<Profile> view(){
        return profileRepository.findAll();
    }


}
