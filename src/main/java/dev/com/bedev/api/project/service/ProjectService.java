package dev.com.bedev.api.project.service;

import dev.com.bedev.api.project.dto.request.ProjectRequestDto;
import dev.com.bedev.api.project.dto.response.ProjectResponseDto;
import dev.com.bedev.domain.project.Project;
import dev.com.bedev.domain.project.ProjectRepository;
import dev.com.bedev.domain.user.User;
import dev.com.bedev.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectService {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    @Transactional
    public Long createProject(ProjectRequestDto projectRequestDto) {

        User user;
        Project project = projectRequestDto.toEntity();

        projectRepository.save(project);
        return project.getId();
    }

    @Transactional(readOnly = true)
    public List<ProjectResponseDto> findAllProjects() {
        return projectRepository.findAll().stream()
                .map(ProjectResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProjectResponseDto findById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 없습니다."));
        return new ProjectResponseDto(project);
    }
}