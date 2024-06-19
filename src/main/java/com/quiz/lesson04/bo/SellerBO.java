package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	@Autowired
	private SellerMapper sellerMapper;
	
	public void addUser(String nickname, String profileImageUrl, double temperature) {
		sellerMapper.insertUser(nickname, profileImageUrl, temperature);
	}
	
	public Seller getLatestSeller(Integer id) {
		return sellerMapper.selectLatestSeller(id);
	}
	public Seller getLatestSellerById(Integer id) {
		return sellerMapper.selectLatestSellerById(id);
	}
	
}
