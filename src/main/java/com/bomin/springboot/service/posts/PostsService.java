package com.bomin.springboot.service.posts;

import com.bomin.springboot.domain.posts.Posts;
import com.bomin.springboot.domain.posts.PostsRepository;
import com.bomin.springboot.web.dto.PostsListResponseDto;
import com.bomin.springboot.web.dto.PostsResponseDto;
import com.bomin.springboot.web.dto.PostsSaveRequestDto;
import com.bomin.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

//final이 선언된 모든 필드를 인자값으로 하는 생성자를 롬복의 어노테이션이 대신 생성
//@Autowired를 사용하지 않아도 대신 생성해줌
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        //.map(posts -> new PostsListResponseDto(posts))
        //.map(PostsListResponseDto::new)
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postsRepository.delete(posts);
    }
}
