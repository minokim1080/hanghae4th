package com.example.hanghae4th.domain.dto.posts;

import com.example.hanghae4th.domain.model.posts.Posts;
import com.example.hanghae4th.domain.model.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsRequestDto {
    private String title;
    private String content;

    @Builder
    public PostsRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
