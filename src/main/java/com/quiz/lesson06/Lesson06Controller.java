package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@Controller
@RequestMapping("/lesson06")
public class Lesson06Controller {
	
	@Autowired
	private BookmarkBO bookmarkBO;
	
	// 즐겨찾기 추가 화면
	// http://localhost:8080/lesson06/add-boomark-view
	@GetMapping("/add-boomark-view")
	public String addBookmarkView() {
		
		return "lesson06/addBookmark";
	}
	
	//AJAX가 하는 요청
	// 즐겨찾기 추가
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// db insert
		bookmarkBO.addBookmark(name, url);
		
		// 성공 JSON
		// {"code":200, "result":"성공"}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
	}
	
	// 회원 가입 성공 화면
	// http://localhost:8080/lesson06/after-add-bookmark-view
	@GetMapping("/after-add-bookmark-view")
	public String afterAddBookmarkView(Model model) {
		
		// db select
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		
		// model에 담기
		model.addAttribute("bookmarkList", bookmarkList);
		
		return "lesson06/afterAddBookmark";
	}
	
	
	
	
	
}
