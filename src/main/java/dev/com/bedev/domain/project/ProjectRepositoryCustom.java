package dev.com.bedev.domain.project;

import dev.com.bedev.domain.post.Post;

import java.util.List;

public interface ProjectRepositoryCustom {
    List<Post> searchPosts(String keyword);
}
