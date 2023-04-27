package dev.com.bedev.api.project.dto.request;

import dev.com.bedev.domain.enums.DevelopmentPart;
import jakarta.persistence.Column;
import lombok.Getter;

import java.util.Set;

@Getter
public class ProfileRequestDto {

    private String image;
    
    private String department;

    private String schoolId;
    private String content;

    private String email;


    private Set<DevelopmentPart> developmentPart;

    private String developTool;

    private String introduce;

    private String name;
}
