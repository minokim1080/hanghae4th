package com.example.hanghae4th.domain.businesslogic.posts;

import com.example.hanghae4th.domain.dto.posts.PostsRequestDto;
import com.example.hanghae4th.domain.dto.posts.PostsResponseDto;
import com.example.hanghae4th.domain.model.posts.Posts;
import com.example.hanghae4th.domain.model.users.Users;
import com.example.hanghae4th.domain.repository.posts.PostsRepository;
import com.example.hanghae4th.domain.repository.users.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PostsMapper {

    private final PostsRepository postsRepository;
    private final UsersRepository usersRepository;

    //게시물 작성시간 기준 내림차순으로 정렬해서 반환
    @Transactional
    public List<Posts> findAllSortedByCreatedAt(){
        List<Posts> entityList = postsRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        return entityList;
    }

    //Posts Dto를 entity에 넣어서 반환
    @Transactional
    public Posts mapDtoToEntity(PostsRequestDto postsRequestDto, String username){
        Users user_id = usersRepository.findByUsername(username).get();

        return Posts.builder()
                .title(postsRequestDto.getTitle())
                .content(postsRequestDto.getContent())
                .user_id(user_id)
                .username(username)
                .build();
    }

    //post 저장
    @Transactional
    public void savePost(PostsRequestDto postsRequestDto, String username){
        Posts post = mapDtoToEntity(postsRequestDto, username);
        postsRepository.save(post);
    }

    //Posts entity를 Dto로 넣어서 반환
    @Transactional
    public PostsResponseDto mapEntityToDto(Posts entity){

        return PostsResponseDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .username(entity.getUsername())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    //매개변수로 들어온 id값에 해당하는 post를 찾아서 Dto에 넣어 반환
    @Transactional
    public PostsResponseDto mapEntityToDTo(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));

        return mapEntityToDto(entity);
    }

    //모든 게시물 리스트 Dto에 넣어서 반환
    @Transactional
    public List<PostsResponseDto> makeAllPostsList(){
        List<Posts> entityList = findAllSortedByCreatedAt();
        List<PostsResponseDto> postsList = new ArrayList<>();

        for(Posts entity : entityList){
            postsList.add(mapEntityToDto(entity));
        }

        return postsList;
    }
}
