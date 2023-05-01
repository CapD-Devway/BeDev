package dev.com.bedev.domain.project;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dev.com.bedev.domain.post.Post;
import dev.com.bedev.domain.post.PostRepositoryCustom;
import dev.com.bedev.domain.post.QPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class ProjectRepositoryCustomImpl implements ProjectRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public PostRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(Post.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        QPost post = QPost.post;

        return jpaQueryFactory.selectFrom(Post)
                .where(post.title.containsIgnoreCase(keyword))
                .fetch();
    }


}
