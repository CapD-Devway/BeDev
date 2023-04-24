package dev.com.bedev.api.project.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class ProfileRequestDto {

    private String image;
    
    private String department;

    private String schoolId;

    private String email;

    private String phoneNumber;

    private String developmentPart;

    private String developTool;

    private String introduce;

    private String name;
}
