package com.bomin.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
//기본 생성자 자동 추가
//public Posts(){}와 같은 효과
@NoArgsConstructor
//테이블과 링크될 클래스임을 나타냄
//기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭
//ex) SalesManager.java → sales_manager table
@Entity
public class Posts {
    //해당 테이블의 PK 필드를 나타냄
    @Id
    //PK의 생성규칙을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //테이블 컬럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    //해당 클래스의 빌더 패턴 클래스를 생성
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
