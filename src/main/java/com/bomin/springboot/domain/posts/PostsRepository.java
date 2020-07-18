package com.bomin.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//보통 ibatis나 MyBatis 등에서 Dao라고 불리는 DB Layer 접근자
//단순히 인터페이스를 생성 후, JpaRepository<Entity 클래스, PK타입>를 상속하면 기본적인 CRUD 메소드가 자동으로 생성됨
//주의할 점 : Entity 클래스와 기본 Entity Repository는 함께 위치해야 함
//둘은 밀접한 관계이고, Entity 클래스는 기본 Repository 없이는 제대로 역할을 할 수가 없음
public interface PostsRepository extends JpaRepository<Posts, Long> {
    //SpringDataJpa에서 제공하지 않는 메소드는 쿼리로 작성해도 되는것을 보여줌
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
