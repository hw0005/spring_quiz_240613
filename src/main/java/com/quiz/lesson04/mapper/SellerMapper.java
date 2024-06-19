package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson04.domain.Seller;

@Mapper
public interface SellerMapper {
	
	public void insertUser(
			@Param("nickname") String nickname, 
			@Param("profileImageUrl") String profileImageUrl, 
			@Param("temperature") double temperature);
	
	public Seller selectLatestSeller(Integer id);
	public Seller selectLatestSellerById(Integer id);

}
