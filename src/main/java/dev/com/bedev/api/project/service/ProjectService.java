package dev.com.bedev.api.project.service;

import dev.com.bedev.api.project.dto.respone.CreateProject;
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
    public CreateProject createProject(){

        Project project = Project.builder()
                .name("1")
                .content("1")
                .build();
        projectRepository.save(project);
        CreateProject createProject = CreateProject.builder()
                .teamContent(project.getContent())
                .teamName(project.getName())
                .build();
        return createProject;
    }
}
