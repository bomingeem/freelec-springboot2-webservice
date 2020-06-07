package com.bomin.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

//스프링 부트 테스트와 JUnit 사이에 연결자 역할을 함
@RunWith(SpringRunner.class)
//Web(Spring MVC)에 집중할 수 있는 어노테이션
@WebMvcTest
public class HelloControllerTest {
    //스프링이 관리하는 Bean을 주입받음
    @Autowired
    private MockMvc mvc;

    @Test
    public void helloReturn() throws Exception {
        //체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언가능
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void helloDtoReturn() throws Exception {
        String name = "hello";
        int amount = 1000;
        //param : 값은 String만 허용
        //jsonPath : JSON 응답값을 필드별로 검증할 수 있는 메소드
        //$를 기준으로 필드명을 명시
        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
