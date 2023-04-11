package dev.com.bedev.domain.post.controller;

import dev.com.bedev.domain.post.dto.PostRequestDto;
import dev.com.bedev.domain.post.dto.PostResponseDto;
import dev.com.bedev.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // Create
    @PostMapping("/post")
    public ResponseEntity save(@RequestBody PostRequestDto postRequestDto) {
        return ResponseEntity.ok(postService.save(postRequestDto));
    }

    // Read
    @GetMapping("/post/{id}")
    public ResponseEntity read(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    // Update
    @PutMapping("/post/{postId}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        postService.update(id, postRequestDto);
        return ResponseEntity.ok(id);
    }

    // Delete
    @DeleteMapping("/post/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok(id);
    }
}
