package dev.com.bedev.api.project.dto.response;

import dev.com.bedev.domain.enums.DevelopmentPart;
import dev.com.bedev.domain.profile.Profile;
import dev.com.bedev.domain.project.Project;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class ProfileResponseDto {

    private String image;

    private String department;

    private String schoolId;

    private String email;

    private Set<DevelopmentPart> developmentPart;

    private String developTool;

    private String introduce;

    private String name;
    private Long id;

    public static ProfileResponseDto from(Profile profile) {
        return ProfileResponseDto.builder()
                .image(profile.getImage())
                .schoolId(profile.getSchoolId())
                .department(profile.getDepartment())
                .email(profile.getEmail())
                .developmentPart(profile.getDevelopmentPart())
                .developTool(profile.getDevelopTool())
                .introduce(profile.getIntroduce())
                .name(profile.getName())
                .id(profile.getId())
                .build();
    }


}
