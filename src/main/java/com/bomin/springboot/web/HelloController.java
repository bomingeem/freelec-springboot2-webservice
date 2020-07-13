package com.bomin.springboot.web;

import com.bomin.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//JSON을 반환하는 컨트롤러로 만들어줌
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    //@RequestParam : 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
    //외부에서 name이란 이름으로 넘긴 파라미터를 메소드 파라미터에 저장
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
