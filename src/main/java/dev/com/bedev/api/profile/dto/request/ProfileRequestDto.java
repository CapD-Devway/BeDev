package dev.com.bedev.api.profile.dto.request;

import dev.com.bedev.domain.enums.DevelopmentPart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProfileRequestDto {

    private MultipartFile image;
    
    private String department;

    private String schoolId;
    private String content;

    private String email;


    private Set<DevelopmentPart> developmentPart;

    private String developTool;

    private String introduce;

    private String name;
}
