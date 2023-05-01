package dev.com.bedev.api.project.service;

import dev.com.bedev.api.condition.PostSearchCondition;
import dev.com.bedev.domain.post.Post;
import dev.com.bedev.api.project.dto.request.PostRequestDto;
import dev.com.bedev.api.project.dto.response.PostResponseDto;
import dev.com.bedev.domain.post.PostRepository;
import dev.com.bedev.domain.project.Project;
import dev.com.bedev.domain.project.ProjectRepository;
import dev.com.bedev.domain.user.User;
import dev.com.bedev.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/*
카테고리에 따른 게시판 분류 -> 팀원 모집 글
 */
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public Page<PostResponseDto> findAll(Pageable pageable) {
        Page<Post> posts = postRepository.findAll(pageable);
        return posts.map(PostResponseDto::new);
    }

    //Create
    @Transactional
    public Long save(PostRequestDto postRequestDto) {
        User user = userRepository.findById(postRequestDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("해당하는 유저는 없습니다."));
        Project project = projectRepository.findById(postRequestDto.getProjectId()).orElseThrow(()-> new IllegalArgumentException("해당 프로젝트는 없습니다."));

        Post post = postRequestDto.toEntity();
        post.associateUser(user);
        post.associateProject(project);

        postRepository.save(post);
        return post.getId();
    }

    //Read
    @Transactional(readOnly = true)
    public PostResponseDto findById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당하는 게시글이 없습니다."));
        return new PostResponseDto(post);
    }

    // update (dirty checking)
    @Transactional
    public void update(Long id, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당하는 게시글이 없습니다."));

        post.update(postRequestDto.getTitle(), postRequestDto.getContent(), postRequestDto.getStack());
    }

    @Transactional
    public void delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당하는 게시글이 없습니다."));

        postRepository.delete(post);
    }

    //검색 기능 추가
    public Page<PostResponseDto> getSearchPosts(PostSearchCondition searchCondition, Pageable pageable) {
        Page<Post> posts = postRepository.searchPosts(searchCondition, pageable);
        return posts.map(PostResponseDto::new);
    }
}
