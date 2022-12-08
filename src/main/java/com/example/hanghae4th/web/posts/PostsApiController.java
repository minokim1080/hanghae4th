package com.example.hanghae4th.web.posts;

import com.example.hanghae4th.domain.businesslogic.BadResponse;
import com.example.hanghae4th.domain.dto.ResponseBodyDto;
import com.example.hanghae4th.domain.jwt.JwtUtil;
import com.example.hanghae4th.service.posts.PostsService;
import com.example.hanghae4th.domain.dto.posts.PostsRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;
    private final JwtUtil jwtUtil;

    //전체 게시글 확인
    @GetMapping("/posts")
    public ResponseEntity<ResponseBodyDto> showPosts() {
        return postsService.showPosts();
    }

    //게시글 등록
    @PostMapping("/posts")
    public ResponseEntity<ResponseBodyDto> savePosts(@RequestBody PostsRequestDto postsRequestDto, HttpServletRequest request){
        String token = jwtUtil.resolveToken(request);
        //토큰 검증 후 실패시 에러 반환, 성공시 null
        jwtUtil.validateToken(token);
        return postsService.savePosts(postsRequestDto, token);
    }

    //게시글 조회
    @GetMapping("/posts/{postId}")
    public ResponseEntity<ResponseBodyDto> showPostsDetail(@PathVariable Long postId){
        return postsService.showPostsDetail(postId);
    }

    //게시글 수정
    @PutMapping("/posts/{postId}")
    public ResponseEntity<ResponseBodyDto> updatePosts(@PathVariable Long postId, @RequestBody PostsRequestDto postsRequestDto, HttpServletRequest request){
        String token = jwtUtil.resolveToken(request);
        //토큰 검증 후 실패시 에러 반환, 성공시 null
        jwtUtil.validateToken(token);
        return postsService.updatePosts(postId, postsRequestDto, token);
    }

    //게시글 삭제
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ResponseBodyDto> deletePosts(@PathVariable Long postId, @RequestBody PostsRequestDto postsRequestDto, HttpServletRequest request){
        String token = jwtUtil.resolveToken(request);
        //토큰 검증 후 실패시 에러 반환, 성공시 null
        jwtUtil.validateToken(token);
        return postsService.deletePosts(postId, postsRequestDto, token);
    }
}
