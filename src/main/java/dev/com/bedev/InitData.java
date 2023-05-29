/*
package dev.com.bedev;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dev.com.bedev.domain.category.Category;
import dev.com.bedev.domain.post.Post;
import dev.com.bedev.domain.project.Project;
import dev.com.bedev.domain.user.User;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class InitData {

    private final EntityManagerFactory emf;

    @PostConstruct
    public void init() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
        try {
            tx.begin();

            for (int i = 0; i < 50; i++) {
                User user = User.builder()
                        .email("user" + i + "@example.com")
                        .password("1111")
                        .name("User " + i)
                        .build();

                em.persist(user);

                for (int j = 0; j < 50; j++) {
                    Post.PostBuilder postBuilder = Post.builder()
                            .user(user)
                            .title("Test post " + j)
                            .content("Test content " + j)
                            .stack("back")
                            .createdDateTeam(LocalDateTime.parse("2023-05-16T15:30:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                            .description("Please" + j);

                    if (j % 2 == 0) { // Include an image file for every other post
                        File imgFile = new File("/path/to/image/file" + j + ".jpg");
                        postBuilder.imgPath(imgFile.getAbsolutePath());
                    }

                    Post post = postBuilder.build();
                    em.persist(post);
                }
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
*/