package dev.com.bedev.domain.post.dto;

import dev.com.bedev.domain.category.Category;
import dev.com.bedev.domain.post.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {

    private final Long id;
    private final Long project_id;
    private final Long user_id;
    private final String title;
    private final String content;
    private final Category category;
    private final String views;
    private final String stack;
    private final LocalDateTime createTime;
    private final LocalDateTime updateTime;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.project_id = post.getProject().getId();
        this.user_id = post.getUser().getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.category = post.getCategory();
        this.views = post.getViews();
        this.stack = post.getStack();
        this.createTime = post.getCreateTime();
        this.updateTime = post.getUpdateTime();
    }
}
