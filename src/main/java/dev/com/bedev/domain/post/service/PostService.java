package dev.com.bedev.domain.post.service;

import dev.com.bedev.domain.post.Post;
import dev.com.bedev.domain.post.dto.PostRequestDto;
import dev.com.bedev.domain.post.dto.PostResponseDto;
import dev.com.bedev.domain.post.repository.PostRepository;
import dev.com.bedev.domain.user.User;
import dev.com.bedev.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;

    //Create 로그인 시 글작성은 이후 리팩토링
    @Transactional
    public Long save(PostRequestDto postRequestDto) {
        Post post = postRequestDto.toEntity();
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
    /* 조회수

    @Transactional
    public int viewCount(Long id) {

    }

     */

    /*
    메인페이지에 해당하는 list
     */

    /*
    메인페이지에 해당하는 검색기능
     */
}
