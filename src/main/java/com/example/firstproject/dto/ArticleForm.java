package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private Long id;  // id 필드 추가
    private String title;
    private String content;

//    // 전송받은 제목과 내용을 필드에 저장하는 생성자 추가
//    public ArticleForm(String content, String title) {
//        this.content = content;
//        this.title = title;
//    }

//    // 데이터를 잘 받았는지 확인할 toString() 메서드 추가
//    @Override
//    public String toString() {
//        return "ArticleForm{" +
//                "title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
