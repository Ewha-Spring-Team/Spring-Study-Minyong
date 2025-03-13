package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")       // URL 요청 접수
    public String niceToMeetYou(Model model) {   // 메서드 작성: model 객체 받아 오기
        model.addAttribute("username", "minyong");  // 모델 변수 등록하기
        return "greetings";  // greetings.mustache 파일 반환
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "홍길동");
        return "goodbye";
    }
}
