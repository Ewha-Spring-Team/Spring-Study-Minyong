package com.example.firstproject.entity;

import jakarta.persistence.*;
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

    @Id  // 엔티티의 대푯값 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // DB가 id 자동 생성
    private Long id;

    @Column  // title 필드 선언, DB 테이블의 title 열과 연결됨
    private String title;

    @Column  // content 필드 선언, DB 테이블의 content 열과 연결됨
    private String content;

}
