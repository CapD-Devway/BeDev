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


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/create")
    public ResponseEntity<Long> createProject(@RequestBody ProjectRequestDto projectRequestDto) {
        Long projectId = projectService.createProject(projectRequestDto);
        return ResponseEntity.ok(projectId);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseDto>> findAllProjects() {
        List<ProjectResponseDto> projects = projectService.findAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDto> findProjectById(@PathVariable Long id) {
        ProjectResponseDto project = projectService.findById(id);
        return ResponseEntity.ok(project);
    }
}