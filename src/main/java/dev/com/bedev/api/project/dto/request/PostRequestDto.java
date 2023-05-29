package dev.com.bedev.api.project.dto.request;

import dev.com.bedev.domain.post.Post;
import dev.com.bedev.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRequestDto {

    private Long id;
    private Long user_id;
    private String title;
    private String content;
    private String stack;
    private String description;
    private String imgPath;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private LocalDateTime createdDateTeam;
    /*
    private Category category;
    private Long projectId;
    private String views;
     */

    public Post toEntity(User user, String imgPath) {
        Post post = Post.builder()
                .id(id)
                .title(title)
                .content(content)
                .stack(stack)
                .createdDateTeam(createdDateTeam)
                .description(description)
                .imgPath(imgPath)
                //.category(category)
                //.views(views)
                .build();

        post.associateUser(user);
        return post;
    }
}