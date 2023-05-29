package dev.com.bedev.api.project.controller;

import dev.com.bedev.api.condition.PostSearchCondition;
import dev.com.bedev.api.project.dto.request.PostRequestDto;
import dev.com.bedev.api.project.dto.response.PostResponseDto;
import dev.com.bedev.api.project.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/teampost")
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 팀원 모집 글 - 피드형식
    @GetMapping("/all")
    public Page<PostResponseDto> getAllPosts(Pageable pageable) {
        return postService.findAll(pageable);
    }


    // Create
    @PostMapping("/write")
    public ResponseEntity save(@ModelAttribute PostRequestDto postRequestDto) {
        return ResponseEntity.ok(postService.save(postRequestDto));
    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity read(@PathVariable Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @ModelAttribute PostRequestDto postRequestDto) {
        postService.update(id, postRequestDto);
        return ResponseEntity.ok(id);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok(id);
    }

    // 검색 결과
    @GetMapping
    public ResponseEntity<Page<PostResponseDto>> getSearchedPosts(
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
            @ModelAttribute PostSearchCondition searchCondition) {
        Page<PostResponseDto> postList = postService.getSearchPosts(searchCondition, pageable);
        return ResponseEntity.ok(postList);
    }
}
