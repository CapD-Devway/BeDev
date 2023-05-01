package dev.com.bedev.api.project.dto.response;

import dev.com.bedev.domain.project.Project;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
public class ProjectResponseDto {

    private Long id;
    private String name;
    private String content;

    public ProjectResponseDto(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.content = project.getContent();
    }
}