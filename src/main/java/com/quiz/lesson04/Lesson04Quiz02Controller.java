package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@Controller
@RequestMapping("/lesson04/quiz02")
public class Lesson04Quiz02Controller {
	
	@Autowired
	private RealtorBO realtorBO;
	
	// 공인중개사 추가 화면
	// http://localhost:8080/lesson04/quiz02/add-realtor-view
	@GetMapping("/add-realtor-view")
	public String addRealtorView() {
		
		return "lesson04/addRealtor";
	}
	
	// 공인중개사 추가 완료 페이지(1: insert, 2: select)
	@PostMapping("/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model) {
		// DB INSERT
		realtorBO.addRealtor(realtor);
		
		// DB SELECT => 방금 가입된 공인중개사
		int id = realtor.getId();
		Realtor latestRealtor = realtorBO.getRealtorById(id);
		
		// model에 담기
		model.addAttribute("realtor", latestRealtor);
		
		// 화면 이동
		return "lesson04/afterAddRealtor";
	}
	
	
	
}
