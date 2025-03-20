package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j   // 로깅 기능을 위한 어노테이션 추가
@Controller    // 컨트롤러 선언
public class ArticleController {
    @Autowired  // 스프링 부트가 미리 생성해 놓은 리파지터리 객체 주입(DI)
    private ArticleRepository articleRepository;  // articleRepository 객체 선언

    @GetMapping("/articles/new")  // URL 요청 접수
    public String newArticleForm() {   // 메서드 생성 및 반환값 작성
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {  // 폼 데이터를 DTO로 받기
        log.info(form.toString());
        //System.out.println(form.toString());         // DTO에 폼 데이터가 잘 담겼는지 확인
        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info(form.toString());  // 로깅 코드 추가
        //System.out.println(article.toString());  // DTO가 엔티티로 잘 변환되는지 확인 출력
        // 2. 리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);  // article 엔티티를 저장해 saved 객체에 반환
        log.info(saved.toString());  // 로깅 코드 추가
        //System.out.println(saved.toString());   // article이 DB에 잘 저장되는지 확인 출력
        return "redirect:/articles/" + saved.getId();   // 리다이렉트를 작성할 위치
    }

    @GetMapping("/articles/{id}")  // 데이터 조회 요청 접수
    public String show(@PathVariable Long id, Model model) {  // 매개변수로 id 받아 오기
        log.info("id = " + id);  // id를 잘 받았는지 확인하는 로그 찍기
        // 1. id를 조회해 데이터 가져오기
        //Optional<Article> articleEntity = articleRepository.findById(id);
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 2. 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);
        // 3. 뷰 페이지 반환하기
        return "articles/show";  // 목록으로 돌아가기 링크를 넣을 뷰 파일 확인
    }

    @GetMapping("/articles")
    public String index(Model model) {  // model 객체 받아 오기
        // 1. 모든 데이터 가져오기
        //List<Article> ArticleEntityList = (List<Article>)articleRepository.findAll();  // 다운캐스팅
        //Iterable<Article> ArticleEntityList = articleRepository.findAll();  // 업캐스팅
        List<Article> articleEntityList = articleRepository.findAll();

        // 2. 모델에 데이터 등록하기
        model.addAttribute("articleList", articleEntityList);  // articleEntityList 등록

        // 3. 뷰 페이지 설정하기
        return "articles/index";
    }
}
