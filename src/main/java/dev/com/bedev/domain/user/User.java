package dev.com.bedev.domain.user;

import dev.com.bedev.domain.UserProject;
import dev.com.bedev.domain.date.BaseTimeEntity;
import dev.com.bedev.domain.post.Post;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;


    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();
}
