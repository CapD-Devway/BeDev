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

import java.util.List;

@RequestMapping("/post")
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 팀원 모집 글 - 피드형식
    @GetMapping
    public Page<PostResponseDto> getAllPosts(Pageable pageable) {
        return postService.findAll(pageable);
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
    @PutMapping("/{id}")
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

    // 검색 결과
    @GetMapping
    public ResponseEntity<Page<PostResponseDto>> getSearchedPosts(
            @PageableDefault(size = 20, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
            @ModelAttribute PostSearchCondition searchCondition) {
        Page<PostResponseDto> postList = postService.getSearchPosts(searchCondition, pageable);
        return ResponseEntity.ok(postList);
    }
}
