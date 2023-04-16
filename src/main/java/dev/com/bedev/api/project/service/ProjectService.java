package dev.com.bedev.api.project.service;

import dev.com.bedev.api.project.dto.request.ProjectRequestDto;
import dev.com.bedev.api.project.dto.response.ProjectResponseDto;
import dev.com.bedev.domain.project.Project;
import dev.com.bedev.domain.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional
    public Project createProject(ProjectRequestDto projectRequestDto){

        Project project = Project.builder()
                .name(projectRequestDto.getTeamName())
                .content(projectRequestDto.getTeamContent())
                .build();
        projectRepository.save(project);
        return project;
    }


}
