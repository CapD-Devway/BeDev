package dev.com.bedev.api.project.dto.response;

import dev.com.bedev.domain.category.Category;
import dev.com.bedev.domain.post.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {

    private final Long id;
    private final Long user_id;
    private final String title;
    private final String content;
    private final String stack;
    private final String description;
    private final String imgPath;
    private final LocalDateTime createdDateTeam;
    private final LocalDateTime createTime;
    private final LocalDateTime updateTime;
    /*
    private final Long project_id;
    private final Category category;
    private final String views;
     */

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.user_id = post.getUser().getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.stack = post.getStack();
        this.description = post.getDescription();
        this.imgPath = post.getImgPath();
        this.createTime = post.getCreateTime();
        this.updateTime = post.getUpdateTime();
        this.createdDateTeam = post.getCreatedDateTeam();
        /*
        this.project_id = post.getProject().getId();
        this.category = post.getCategory();
        this.view = post.getView();
         */
    }
}
