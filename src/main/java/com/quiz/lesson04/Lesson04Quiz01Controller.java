package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;
	
	// 1. 판매자 등록 화면
	// http://localhost:8080/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// 2. DB 저장 => 입력 성공 화면
	@PostMapping("/add-seller")
	public String addSeller(
		@RequestParam("nickname") String nickname,
		@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
		@RequestParam(value = "temperature", defaultValue ="36.5") double temperature) {
		
		// db insert
		sellerBO.addUser(nickname, profileImageUrl, temperature);
		
		// 성공화면으로 이동
		return "lesson04/afterAddSeller";
	}
	
	// 3. 최근 가입자 뿌리는 화면
	// http://localhost:8080/lesson04/quiz01/seller-info-view
	// http://localhost:8080/lesson04/quiz01/seller-info-view?id=1
	@GetMapping("seller-info-view")
	public String sellerInfoView(
			@RequestParam(value = "id", required = false) Integer id,
			Model model) {
		
		Seller seller = null;
		
		if (id == null) {
			// DB sellect
			seller = sellerBO.getLatestSeller(id);
			
			// Model 주머니에 담는다 => HTML에서 꺼내쓴다.
			model.addAttribute("seller", seller);
			model.addAttribute("title", "판매자 정보!");
			
		} else {
			// DB sellect
			seller = sellerBO.getLatestSellerById(id);
			
			// Model 주머니에 담는다 => HTML에서 꺼내쓴다.
			model.addAttribute("seller", seller);
			model.addAttribute("title", "판매자 정보!");
		}
						
		// 화면 이동
		return "lesson04/sellerInfo";
	}
	
}
