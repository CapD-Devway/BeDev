package dev.com.bedev.api.project.dto.response;

import dev.com.bedev.domain.project.Project;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProjectResponseDto {
    private String teamName;
    private String teamContent;
    private Long id;

    public static ProjectResponseDto from(Project project) {
        return ProjectResponseDto.builder()
                .teamContent(project.getContent())
                .teamName(project.getName())
                .build();
    }
}
