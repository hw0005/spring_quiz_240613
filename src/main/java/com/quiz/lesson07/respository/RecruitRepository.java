package com.quiz.lesson07.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer>{
	
	// JPQL => Entity에 조회
	// quiz02 2번
	public List<RecruitEntity> findByCompanyId(int companyId);
	//3번
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	//4번
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	//5번
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	//6번
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int startSalary, int endSalary);

	//7번 - native query (DB에 직접 SQL)
//	마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 연봉 내림차순으로 조회하세요.
	@Query(value="select * from `recruit` "
			+ "where `deadline` >= : deadline "
			+ "and `salary` > : salary "
			+ "and `type` = : type "
			+ "order by `salary` desc", nativeQuery = true)
	public List<RecruitEntity> findByDeadlineAndSalaryAndType(
			@Param("deadline") String deadline,
			@Param("salary") int salary,
			@Param("type") String type);
}
