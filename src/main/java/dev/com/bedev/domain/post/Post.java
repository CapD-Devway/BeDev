package dev.com.bedev.domain.post;

import dev.com.bedev.domain.date.BaseTimeEntity;
import dev.com.bedev.domain.category.Category;
import dev.com.bedev.domain.project.Project;
import dev.com.bedev.domain.tag.Tag;
import dev.com.bedev.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    private String views;

    @Column(nullable = false)
    private String stack;

    // 제목 및 내용 수정
    public void update(String title, String content, String stack) {
        this.title = title;
        this.content = content;
        this.stack = stack;
    }

    //연관관계 메서드
    public void associateUser(User user) {
        this.user = user;
        user.getPosts().add(this);
    }

    public void associateProject(Project project) {
        this.project = project;
        project.getPosts().add(this);
    }

}
