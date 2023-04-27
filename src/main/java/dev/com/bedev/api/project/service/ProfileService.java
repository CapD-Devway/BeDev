package dev.com.bedev.api.project.service;

import dev.com.bedev.api.project.dto.request.ProfileRequestDto;
import dev.com.bedev.domain.enums.DevelopmentPart;
import dev.com.bedev.domain.profile.Profile;
import dev.com.bedev.domain.profile.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    @Transactional
    public Profile createProject(ProfileRequestDto profileRequestDto){
        Set<DevelopmentPart> developmentParts = profileRequestDto.getDevelopmentPart();
        Profile profile = Profile.builder()
                .image(profileRequestDto.getImage())
                .department(profileRequestDto.getDepartment())
                .introduce(profileRequestDto.getIntroduce())
                .name(profileRequestDto.getName())
                .developmentPart(developmentParts)
                .developTool(profileRequestDto.getDevelopTool())
                .email(profileRequestDto.getEmail())
                .schoolId(profileRequestDto.getSchoolId())
                .build();
        profileRepository.save(profile);
        return profile;
    }

    public List<Profile> view(){
        return profileRepository.findAll();
    }


}
