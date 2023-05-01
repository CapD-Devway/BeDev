package dev.com.bedev.domain.post;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dev.com.bedev.api.condition.PostSearchCondition;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static dev.com.bedev.domain.post.QPost.post;
import static dev.com.bedev.domain.project.QProject.project;
import static org.springframework.util.StringUtils.hasText;

@Repository
public class PostRepositoryCustomImpl implements PostRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public PostRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<Post> searchPosts(PostSearchCondition searchCondition, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();

        if (searchCondition.getTitle() != null && !searchCondition.getTitle().isEmpty()) {
            builder.or(post.title.containsIgnoreCase(searchCondition.getTitle()));
        }
        if (searchCondition.getContent() != null && !searchCondition.getContent().isEmpty()) {
            builder.or(post.content.containsIgnoreCase(searchCondition.getContent()));
        }
        if (searchCondition.getProjectName() != null && !searchCondition.getProjectName().isEmpty()) {
            builder.or(post.project.name.containsIgnoreCase(searchCondition.getProjectName()));
        }
        if (searchCondition.getStack() != null && !searchCondition.getStack().isEmpty()) {
            builder.or(post.stack.containsIgnoreCase(searchCondition.getStack()));
        }

        List<Post> content = queryFactory.selectFrom(post)
                .leftJoin(post.project, project)
                .where(builder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(post.count())
                .from(post)
                .leftJoin(post.project, project)
                .where(
                    titleEq(searchCondition.getTitle()),
                    contentEq(searchCondition.getContent()),
                    projectNameEq(searchCondition.getProjectName()),
                    stackEq(searchCondition.getStack())
                );


        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    private BooleanExpression titleEq(String title) {
        return hasText(title) ? null : post.title.eq(title);
    }

    private BooleanExpression contentEq(String content) {
        return hasText(content) ? null : post.content.eq(content);
    }

    private BooleanExpression projectNameEq(String projectName) {
        return hasText(projectName) ? null : project.name.eq(projectName);
    }

    private BooleanExpression stackEq(String stack) {
        return hasText(stack) ? null : post.stack.eq(stack);
    }
}
