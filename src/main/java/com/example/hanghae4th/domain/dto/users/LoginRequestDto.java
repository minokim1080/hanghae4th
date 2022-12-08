package com.example.hanghae4th.domain.dto.users;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequestDto {

    @Pattern(regexp = "^[a-z0-9]{4,10}$")
    private String username;

    //(?=.*)는 *뒤에 있는 범위 중 하나가 최소한은 있어야 된다는 의미.
    //즉, 비밀번호는 최소 영어 1개, 숫자 1개, 특수문자 1개는 반드시 들어가야함.
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,15}$")
    private String password;

    @Builder
    public LoginRequestDto(String username, String password){
        this.username = username;
        this.password = password;
    }
}
