package dev.com.bedev.domain.post.repository;

import dev.com.bedev.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
