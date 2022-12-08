package com.example.hanghae4th.domain.repository.posts;

import com.example.hanghae4th.domain.model.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
