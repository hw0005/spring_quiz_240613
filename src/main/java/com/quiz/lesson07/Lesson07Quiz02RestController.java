package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.respository.RecruitRepository;

@RestController
@RequestMapping("/lesson07/quiz02")
public class Lesson07Quiz02RestController {
	
	@Autowired
	private RecruitRepository recruitRepository;
	
	// http://localhost:8080/lesson07/quiz02/1
	@GetMapping("/1")
	public List<RecruitEntity> quiz1() {
		return recruitRepository.findAllById(8);
	}
	
	// http://localhost:8080/lesson07/quiz02/2
	@GetMapping("/2")
	public List<RecruitEntity> quiz2() {
		return recruitRepository.findAllByCompanyId(1);
	}
	
	// http://localhost:8080/lesson07/quiz02/3
	@GetMapping("/3")
	public List<RecruitEntity> quiz3() {
		return recruitRepository.findAllByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	// http://localhost:8080/lesson07/quiz02/4
	@GetMapping("/4")
	public List<RecruitEntity> quiz4() {
		return recruitRepository.findAllByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
}
