package com.example.hanghae4th.domain.model.posts;

import com.example.hanghae4th.domain.model.BaseTimeEntity;
import com.example.hanghae4th.domain.model.users.Users;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Users user_id;

    @Column(length = 15, nullable = false)
    private String username;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Builder
    public Posts(String title, String content, Users user_id, String username){
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.username = username;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
