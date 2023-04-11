package dev.com.bedev.api.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class ProjectController {

    @PostMapping("api/project")
    public ResponseEntity<?> createProject(){

        return ResponseEntity.ok().body("1");
    }
}
