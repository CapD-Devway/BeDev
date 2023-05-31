package dev.com.bedev.api.project.dto.request;

import dev.com.bedev.domain.project.Project;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectRequestDto {

    private Long id;
    private String name;
    private String content;

    public Project toEntity() {
        Project project = Project.builder()
                .id(id)
                .name(name)
                .content(content)
                .build();

        return project;
    }
}
