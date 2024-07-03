package com.quiz.lesson07.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer>{
	
	public List<RecruitEntity> findAllById(int id);
	public List<RecruitEntity> findAllByCompanyId(int id);
	public List<RecruitEntity> findAllByPositionAndType(String position, String type);

}
