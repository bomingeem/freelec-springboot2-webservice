package com.bomin.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    //앞으로 만들 프로젝트의 메인 클래스
    public static void main(String[] args) {
        //내장 WAS 실행
        //내장 WAS 권장하는 이유 → '언제 어디서나 같은 환경에서 스프링 부트를 배포'할 수 있기 때문
        SpringApplication.run(Application.class, args);
    }
}
