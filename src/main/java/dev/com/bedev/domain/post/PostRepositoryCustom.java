package dev.com.bedev.domain.post;

import dev.com.bedev.api.condition.PostSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostRepositoryCustom {
    Page<Post> searchPosts(PostSearchCondition searchCondition, Pageable pageable);
}
