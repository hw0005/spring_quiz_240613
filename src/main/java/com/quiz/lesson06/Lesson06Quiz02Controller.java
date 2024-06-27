package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson06/quiz02")
@Controller
public class Lesson06Quiz02Controller {
	
	// 즐겨찾기 추가 화면
	// http://localhost:8080/lesson06/quiz02/add-boomark-view
	@GetMapping("/add-boomark-view")
	public String addBookmarkView() {
		
		return "lesson06/quiz02AddBookmark";
	}
	
}
