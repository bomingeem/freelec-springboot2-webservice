package com.bomin.springboot.service.posts;

import com.bomin.springboot.domain.posts.PostsRepository;
import com.bomin.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
