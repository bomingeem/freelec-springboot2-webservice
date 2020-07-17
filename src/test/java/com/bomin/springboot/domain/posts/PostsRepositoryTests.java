package com.bomin.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest //H2 데이터베이스를 자동으로 실행
public class PostsRepositoryTests {

    @Autowired
    PostsRepository postsRepository;

    @After //단위 테스트가 끝날 때마다 수행되는 메소드 지정
    public void cleanup() {
        postsRepository.deleteAll();
    }
    
    @Test
    public void boardSaveRoad() {
        //given
        String title = "보민의 게시글";
        String content = "보민이 내용을 썼다";
        
        postsRepository.save(Posts.builder()
                                  .title(title)
                                  .content(content)
                                  .author("bomingeem@gmail.com")
                                  .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntityRegister() {
        //given
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder()
                       .title("title")
                       .content("content")
                       .author("author")
                       .build());
    }
}
