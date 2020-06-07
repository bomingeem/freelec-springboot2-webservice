package com.bomin.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
//별다른 설정 없이 사용할 경우 H2 데이터베이스를 자동으로 실행
@SpringBootTest
public class PostsRepositoryTests {

    @Autowired
    PostsRepository postsRepository;
    
    //Junit에서 단위 테스트가 끝날 떄마다 수행되는 메소드를 지정
    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void boardSaveLoad() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        
        //테이블 posts에 isnert/update 쿼리를 실행
        postsRepository.save(Posts.builder()
                       .title(title)
                       .content(content)
                       .author("bomingeem@gmail.com")
                       .build());

        //when
        //테이블 posts에 있는 모든 데이터를 조회
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
