package dev.com.bedev.api.project.service;

import dev.com.bedev.api.project.dto.request.ProfileRequestDto;
import dev.com.bedev.api.project.dto.request.ProjectRequestDto;
import dev.com.bedev.domain.profile.Profile;
import dev.com.bedev.domain.profile.ProfileRepository;
import dev.com.bedev.domain.project.Project;
import dev.com.bedev.domain.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    @Transactional
    public Profile createProject(ProfileRequestDto profileRequestDto){

        Profile profile = Profile.builder()
                .image(profileRequestDto.getImage())
                .department(profileRequestDto.getDepartment())
                .introduce(profileRequestDto.getIntroduce())
                .phoneNumber(profileRequestDto.getPhoneNumber())
                .name(profileRequestDto.getName())
                .developmentPart(profileRequestDto.getDevelopmentPart())
                .developTool(profileRequestDto.getDevelopTool())
                .email(profileRequestDto.getEmail())
                .schoolId(profileRequestDto.getSchoolId())
                .build();
        profileRepository.save(profile);
        return profile;
    }


}
