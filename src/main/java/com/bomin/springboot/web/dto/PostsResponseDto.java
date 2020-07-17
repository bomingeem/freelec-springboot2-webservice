package com.bomin.springboot.web.dto;

import com.bomin.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){ 
        //굳이 모든 필드를 가진 생성자가 필요하진 않으므로 Dto는 Entity를 받아 처리
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
