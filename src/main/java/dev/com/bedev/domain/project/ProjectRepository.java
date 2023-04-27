package dev.com.bedev.domain.project;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> , ProjectRepositoryCustom {
}
