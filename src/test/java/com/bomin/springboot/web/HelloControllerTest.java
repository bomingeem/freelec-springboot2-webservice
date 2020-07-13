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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//스프링 부트 테스트와 JUnit 사이에 연결자 역할을 함
@RunWith(SpringRunner.class)
//Web(Spring MVC)에 집중할 수 있는 어노테이션
@WebMvcTest
public class HelloControllerTest {
    //스프링이 관리하는 Bean을 주입받음
    @Autowired
    //웹 API를 테스트할 때 사용
    //스프링 MVC 테스트의 시작점
    private MockMvc mvc;

    @Test
    public void helloReturn() throws Exception {
        String hello = "hello";
        //체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언가능
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDtoReturn() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                    .param("name", name)
                    .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
