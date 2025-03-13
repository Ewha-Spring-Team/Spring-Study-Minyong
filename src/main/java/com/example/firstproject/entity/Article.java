package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity  // 엔티티 선언
public class Article {
    @Id  // 엔티티의 대푯값 지정
    @GeneratedValue   // 자동 생성 기능 추가
    private Long id;
    @Column  // title 필드 선언, DB 테이블의 title 열과 연결됨
    private String title;
    @Column  // content 필드 선언, DB 테이블의 content 열과 연결됨
    private String content;

    // Article 생성자 추가
    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // toString() 메서드 추가
    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
