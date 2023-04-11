package dev.com.bedev.api.project.dto.respone;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateProject {
    private String teamName;
    private String teamContent;
}
