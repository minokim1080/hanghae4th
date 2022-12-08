package com.example.hanghae4th.domain.dto.posts;

import com.example.hanghae4th.domain.model.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsResponseDto {
    private Long id;
    private String title;
    private String username;
    private String content;
    private LocalDateTime createdAt;

    @Builder
    public PostsResponseDto(Long id, String title, String username, String content, LocalDateTime createdAt){
        this.id = id;
        this.title = title;
        this.username = username;
        this.content = content;
        this.createdAt = createdAt;
    }
}
