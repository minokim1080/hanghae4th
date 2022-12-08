package com.example.hanghae4th.domain.model.users;

import com.example.hanghae4th.domain.model.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Users extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, nullable = false)
    private String username;

    @Column(length = 256, nullable = false)
    private String password;

    @Builder
    public Users(String username, String password){
        this.username = username;
        this.password = password;
    }
}
