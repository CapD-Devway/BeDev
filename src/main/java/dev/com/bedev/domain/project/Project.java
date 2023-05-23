package dev.com.bedev.domain.project;

import dev.com.bedev.domain.UserProject;
import dev.com.bedev.domain.date.BaseTimeEntity;
import dev.com.bedev.domain.post.Post;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Project extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String content;

    /*
    @OneToMany(mappedBy = "project")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    private List<UserProject> userProjects = new ArrayList<>();
*/
}
