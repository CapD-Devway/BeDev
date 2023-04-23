package dev.com.bedev.domain.post.dto;

import dev.com.bedev.domain.category.Category;
import dev.com.bedev.domain.post.Post;
import dev.com.bedev.domain.project.Project;
import dev.com.bedev.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRequestDto {

    private Long id;
    private Long projectId;
    private Long userId;
    //private User user;
    private String title;
    private String content;
    private Category category;
    private String views;
    private String stack;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Post toEntity() {
        Post post = Post.builder()
                .id(id)
                .title(title)
                .content(content)
                .category(category)
                .views(views)
                .stack(stack)
                .build();

        return post;
    }
}
