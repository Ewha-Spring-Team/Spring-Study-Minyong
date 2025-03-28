package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity  // 엔티티 선언
@Getter  // 롬복으로 게터 추가
public class Article {
    @Id  // 엔티티의 ㄴ대푯값 지정
    @GeneratedValue   // 자동 생성 기능 추가
    private Long id;
    @Column  // title 필드 선언, DB 테이블의 title 열과 연결됨
    private String title;
    @Column  // content 필드 선언, DB 테이블의 content 열과 연결됨
    private String content;

//    public String getId() {  // getId() 메서드 삭제
//    }
}
