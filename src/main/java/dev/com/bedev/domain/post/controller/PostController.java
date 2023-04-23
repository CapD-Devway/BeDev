package dev.com.bedev.domain.post.controller;

import dev.com.bedev.domain.post.dto.PostRequestDto;
import dev.com.bedev.domain.post.dto.PostResponseDto;
import dev.com.bedev.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/post")
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 팀원 모집 글 - 피드형식
    @GetMapping
    public ResponseEntity<List<PostResponseDto>> findAll() {
        List<PostResponseDto> responseDtos = postService.findAll();
        return ResponseEntity.ok(responseDtos);
    }

    /*메인 - 카테고리에 따른 분류 - cancel
    @GetMapping("/category/{category}")
    public ResponseEntity<List<PostResponseDto>> findByCategory(@PathVariable Category category) {
        List<PostResponseDto> responseDtos = postService.findByCategory(category);
        return ResponseEntity.ok(responseDtos);
    }

     */

    // Create
    @PostMapping("/write")
    public ResponseEntity save(@RequestBody PostRequestDto postRequestDto) {
        return ResponseEntity.ok(postService.save(postRequestDto));
    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity read(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    // Update
    @PutMapping("/{postId}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        postService.update(id, postRequestDto);
        return ResponseEntity.ok(id);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok(id);
    }
}
