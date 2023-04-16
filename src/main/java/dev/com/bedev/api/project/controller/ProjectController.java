package dev.com.bedev.api.project.controller;

import dev.com.bedev.api.project.dto.request.ProjectRequestDto;
import dev.com.bedev.api.project.dto.response.ProjectResponseDto;
import dev.com.bedev.api.project.service.ProjectService;
import dev.com.bedev.domain.project.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ProjectController {

    private final ProjectService projectService;
    @PostMapping("api/project")
    public ResponseEntity<?> createProject(@RequestBody ProjectRequestDto projectRequestDto){
        Project project = projectService.createProject(projectRequestDto);
        ProjectResponseDto projectResponseDto = ProjectResponseDto.builder()
                .id(project.getId())
                .teamContent(project.getContent())
                .teamName(project.getName())
                .build();
        return ResponseEntity.ok().body(projectResponseDto);
    }
}
