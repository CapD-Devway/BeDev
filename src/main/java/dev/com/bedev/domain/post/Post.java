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
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String title; // 팀 이름

    @Column(nullable = false) // 한 줄 소개
    private String description;

    @Column(nullable = true) // 썸네일 경로
    private String imgPath;

    @Lob
    @Column(nullable = false)
    private String content; // 상세 소개

    @Column(nullable = false)
    private String stack; // 구하는 직무

    @Column(nullable = false) //팀 생성 날짜
    private LocalDateTime createdDateTeam;

    // 제목 및 내용 수정
    public void update(String title, String content, String stack, String imgPath,LocalDateTime createdDateTeam) {
        this.title = title;
        this.content = content;
        this.stack = stack;
        this.imgPath = imgPath;
        this.createdDateTeam = createdDateTeam;
    }
    public void updateImage(String imgPath) {
        this.imgPath = imgPath;
    }

    //연관관계 메서드
    public void associateUser(User user) {
        this.user = user;
        user.getPosts().add(this);
    }

    /*
    추후 변경
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(nullable = false) //마감기한
    private LocalDateTime deadline;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(nullable = false)
    private String views; //조회수

    public void associateProject(Project project) {
        this.project = project;
        project.getPosts().add(this);
    }

 */
}
