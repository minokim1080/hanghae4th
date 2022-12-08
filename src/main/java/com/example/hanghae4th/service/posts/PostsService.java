package com.example.hanghae4th.service.posts;


import com.example.hanghae4th.domain.businesslogic.BadResponse;
import com.example.hanghae4th.domain.businesslogic.SuccessResponse;
import com.example.hanghae4th.domain.businesslogic.posts.PostsMapper;
import com.example.hanghae4th.domain.dto.ResponseBodyDto;
import com.example.hanghae4th.domain.dto.posts.PostsRequestDto;
import com.example.hanghae4th.domain.dto.posts.PostsResponseDto;
import com.example.hanghae4th.domain.jwt.JwtUtil;
import com.example.hanghae4th.domain.model.posts.Posts;
import com.example.hanghae4th.domain.model.users.Users;
import com.example.hanghae4th.domain.repository.posts.PostsRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    private final SuccessResponse successResponse;
    private final BadResponse badResponse;
    private final JwtUtil jwtUtil;
    private final PostsMapper postsMapper;

    //전체 게시글 조회
    @Transactional
    public ResponseEntity<ResponseBodyDto> showPosts() {
        //전체 게시글 리스트 만들어서 반환
        List<PostsResponseDto> postsList = postsMapper.makeAllPostsList();
        return successResponse.respondOK(postsList);
    }

    //게시글 저장
    @Transactional
    public ResponseEntity<ResponseBodyDto> savePosts(PostsRequestDto postsRequestDto, String token) {
        //토큰에서 username 추출
        Claims claim = jwtUtil.getUserInfoFromToken(token);
        String username = claim.getSubject();

        //게시글 저장
        postsMapper.savePost(postsRequestDto, username);
        return successResponse.respondCreated();
    }

    //게시글 조회
    @Transactional
    public ResponseEntity<ResponseBodyDto> showPostsDetail(Long postId) {
        //id로 게시글 찾아서 dto로 반환
        PostsResponseDto post = postsMapper.mapEntityToDTo(postId);
        return successResponse.respondOK(post);
    }

    //게시글 수정
    @Transactional
    public ResponseEntity<ResponseBodyDto> updatePosts(Long postId, PostsRequestDto postsRequestDto, String token) {


    }

    //게시글 삭제
    @Transactional
    public ResponseEntity<ResponseBodyDto> deletePosts(Long postId, PostsRequestDto postsRequestDto, String token) {
    }
}
