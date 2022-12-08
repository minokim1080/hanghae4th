package com.example.hanghae4th.web.users;

import com.example.hanghae4th.domain.dto.ResponseBodyDto;
import com.example.hanghae4th.domain.dto.users.LoginRequestDto;
import com.example.hanghae4th.service.users.UsersService;
import com.example.hanghae4th.domain.dto.users.SignupRequestDto;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UsersApiController {

    private final UsersService usersService;

    //회원가입
    @PostMapping("/signup")
    public ResponseEntity<ResponseBodyDto> signup(@RequestBody @Valid SignupRequestDto signupRequestDto){
        return usersService.signup(signupRequestDto);
    }

    //로그인
    @PostMapping("/login")
    public ResponseEntity<ResponseBodyDto> login(@RequestBody @Valid LoginRequestDto loginRequestDto, HttpServletResponse response){
        return usersService.login(loginRequestDto, response);
    }
}
