package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson06")
public class Lesson06Controller {
	
	// 즐겨찾기 추가 화면
	// http://localhost:8080/lesson06/add-boomark-view
	@GetMapping("/add-boomark-view")
	public String addBookmarkView() {
		
		return "lesson06/addBookmark";
	}
	
	// 즐겨찾기 추가
	
	
	// 회원 가입 성공 화면
	// http://localhost:8080/lesson06/after-add-bookmark-view
	@GetMapping("/after-add-bookmark-view")
	public String afterAddBookmarkView() {
		
		return "lesson06/afterAddBookmark";
	}
	
	
	
	
	
}
